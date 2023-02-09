package com.denizogut.movieserviceapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;


public class DirectorWithFullNameDTO {

    public String fullName;

    @JsonFormat(pattern = "dd-MMM-yyyy", shape = JsonFormat.Shape.STRING)
    public LocalDate birthDate;
}
