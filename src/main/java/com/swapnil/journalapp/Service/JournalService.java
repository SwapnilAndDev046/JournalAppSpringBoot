package com.swapnil.journalapp.Service;

import com.swapnil.journalapp.Dto.JournalDto;
import com.swapnil.journalapp.Dto.safeEntryDto;

import java.util.List;
import java.util.Map;


public interface JournalService {

    List<JournalDto> getAllEntries();

    JournalDto getById(Long id);

    JournalDto addJournalEntry(safeEntryDto safeDtoEntry);

    JournalDto editEntry(Long id, safeEntryDto safeDtoEntry);

    String deleteEntry(Long id);

    JournalDto partialUpdate(Long id, Map<String,Object> Values);
}
