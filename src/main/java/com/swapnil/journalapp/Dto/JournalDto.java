package com.swapnil.journalapp.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JournalDto {

    private long id;
    private String title;
    private String content;
}
