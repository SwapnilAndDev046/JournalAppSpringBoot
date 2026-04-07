package com.swapnil.journalapp.Controller;

import com.swapnil.journalapp.Dto.JournalDto;
import com.swapnil.journalapp.Dto.safeEntryDto;
import com.swapnil.journalapp.Repository.JournalRepo;
import com.swapnil.journalapp.Service.JournalService;
import com.swapnil.journalapp.entity.Journal;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping({"/journal", "/journal/"}) // Base URL for all APIs in this controller
@RequiredArgsConstructor
public class JournalController {

    //Dependency injection
    private final JournalRepo journalRepo;
    private final JournalService journalService;

    // ===================== GET APIs =====================

    @GetMapping
    public List<JournalDto> getAll() {
        return journalService.getAllEntries();
    }

    @GetMapping("/{myId}")
    public JournalDto getSpecificId(@PathVariable Long myId){
        return journalService.getById(myId);
    }


    // ===================== POST API =====================

    @PostMapping
    public JournalDto createEntry(@RequestBody safeEntryDto myEntry){
        return journalService.addJournalEntry(myEntry);
    }

    // ===================== PUT API =====================

    @PutMapping("/{id}")
    public JournalDto updateEntry(@PathVariable Long id, @RequestBody safeEntryDto journalDtoEntry){
        return journalService.editEntry(id,journalDtoEntry);//need an object to call
    }

    // ===================== DELETE API =====================

    @DeleteMapping("/{id}")
    public String DeleteEntry(@PathVariable Long id){
        return journalService.deleteEntry(id);
    }


    // ===================== PATCH API =====================
    @PatchMapping("/{id}")
    public JournalDto partialUpdate(@PathVariable Long id, @RequestBody Map<String,Object> values){
        return journalService.partialUpdate(id,values);
    }
}

