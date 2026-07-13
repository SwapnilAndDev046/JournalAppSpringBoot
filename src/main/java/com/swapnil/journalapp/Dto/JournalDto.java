package com.swapnil.journalapp.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JournalDto {
    // used in Get since we are accessing the id too which is bad when comes to security
    // do not use for POST
    private long id;
    private String title;
    private String content;
}
