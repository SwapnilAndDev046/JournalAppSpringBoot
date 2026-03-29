package com.swapnil.journalapp.Repository;

import com.swapnil.journalapp.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepo extends JpaRepository<Journal, Long> {

}
