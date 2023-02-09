package com.denizogut.movieserviceapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;


public class DirectorDTO {

    public String firstName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String middleName;

    public String familyName;

    @JsonFormat(pattern = "dd-MMM-yyyy", shape = JsonFormat.Shape.STRING)
    public LocalDate birthDate;
}
