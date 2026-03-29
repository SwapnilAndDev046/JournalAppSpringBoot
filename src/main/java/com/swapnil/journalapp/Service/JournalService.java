package com.swapnil.journalapp.Service;

import com.swapnil.journalapp.Dto.JournalDto;

import java.util.List;


public interface JournalService {

    List<JournalDto> getAllEntries();
    JournalDto getById(Long id);
    JournalDto addJournalEntry(JournalDto journalDtoEntry);
    JournalDto editEntry(Long id, JournalDto journalDtoEntry);
    String deleteEntry(Long id);
}
