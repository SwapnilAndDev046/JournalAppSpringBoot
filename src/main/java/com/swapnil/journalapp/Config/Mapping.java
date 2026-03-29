package com.swapnil.journalapp.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapping {
    //This is 3rd party dependency to convert dto to entity and entity to dto
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
