package com.denizogut.movieserviceapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class MovieDTO {

    public String name;

    @JsonFormat(pattern = "dd-MMM-yyyy" , shape = JsonFormat.Shape.STRING)
    public LocalDate sceneDate;

    public long rating;


    public double cost;

    public double imdb;
}
