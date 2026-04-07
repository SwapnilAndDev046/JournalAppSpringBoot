package com.swapnil.journalapp.Service.Impl;

import com.swapnil.journalapp.Dto.JournalDto;
import com.swapnil.journalapp.Dto.safeEntryDto;
import com.swapnil.journalapp.Repository.JournalRepo;
import com.swapnil.journalapp.Service.JournalService;
import com.swapnil.journalapp.entity.Journal;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JournalServiceImpl implements JournalService {

    private final JournalRepo journalRepo; // data access via database
    private final ModelMapper modelMapper; // security - dto to entity or entity to dto

    @Override
    public List<JournalDto> getAllEntries() {
        List<Journal> journalList = journalRepo.findAll();

        return journalList
                .stream()
                .map(n -> new JournalDto(n.getId(), n.getTitle(), n.getContent()))
                .toList();
    }

    @Override
    public JournalDto getById(Long id) {
        Journal journal = journalRepo
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Journal entry Not Found Entry id " + id));

        return modelMapper.map(journal, JournalDto.class); // converting entity to dto
    }

    @Override
    public JournalDto addJournalEntry(safeEntryDto journalDtoEntry) {
        Journal journalEntry = modelMapper.map(journalDtoEntry, Journal.class);//Convert dto entry to entity entry

        Journal saveEntry = journalRepo.save(journalEntry);// add the converted entry in repo

        return modelMapper.map(saveEntry, JournalDto.class);// again to return convert back to dto
    }

    @Override
    public JournalDto editEntry(Long id, safeEntryDto journalDtoEntry) {
        Journal journalEntry = modelMapper.map(journalDtoEntry,Journal.class);// dto -> entity

        //find by id first then update
        Journal presentEntry = journalRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Not Found"));

        //after finding id update each section inside the section
        presentEntry.setContent(journalEntry.getContent());
        presentEntry.setTitle(journalEntry.getTitle());

        //Now save the Updated entry in repo
        Journal saveEntry = journalRepo.save(presentEntry);


        //again convert that entity -> dto
        return modelMapper.map(saveEntry,JournalDto.class);
    }

    @Override
    public String deleteEntry(Long id) {
        Journal journalId = journalRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Not Found Id"));

        journalRepo.deleteById(journalId.getId());//Deletes the entry via repo from database

        return "Deleted the ID = "+id+" Successfully.";
    }


    // (We use map since we are getting random any one input in JSON) or maybe in rare only 2 outOff many
    @Override
    public JournalDto partialUpdate(Long id, Map<String,Object> values) {
        Journal journalId = journalRepo
                .findById(id)
                .orElseThrow(()->new IllegalArgumentException("Not Found Id"));
        values.forEach((key,value)->{
            switch(key){
                case "title":
                    journalId.setTitle((String) value);
                    break;
                case "content":
                    journalId.setContent((String) value);
                    break;
                default:
                    System.out.println("Error");
            }
        });
        Journal saveEntry = journalRepo.save(journalId);
        return modelMapper.map(saveEntry,JournalDto.class);
    }


}
