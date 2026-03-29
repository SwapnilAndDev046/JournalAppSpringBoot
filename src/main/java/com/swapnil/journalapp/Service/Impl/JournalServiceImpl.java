package com.swapnil.journalapp.Service.Impl;

import com.swapnil.journalapp.Dto.JournalDto;
import com.swapnil.journalapp.Repository.JournalRepo;
import com.swapnil.journalapp.Service.JournalService;
import com.swapnil.journalapp.entity.Journal;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JournalServiceImpl implements JournalService {

    private final JournalRepo journalRepo; // data access via database
    private final ModelMapper modelMapper; //

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
    public JournalDto addJournalEntry(JournalDto journalDtoEntry) {
        Journal journalEntry = modelMapper.map(journalDtoEntry, Journal.class);//Convert dto entry to entity entry

        Journal saveEntry = journalRepo.save(journalEntry);// add the converted entry in repo

        return modelMapper.map(saveEntry, JournalDto.class);// again to return convert back to dto
    }

    @Override
    public JournalDto editEntry(Long id, JournalDto journalDtoEntry) {
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


}
