package com.swapnil.journalapp.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class safeEntryDto {
    //safer we can use it for POST
    private String title;
    private String content;
}
