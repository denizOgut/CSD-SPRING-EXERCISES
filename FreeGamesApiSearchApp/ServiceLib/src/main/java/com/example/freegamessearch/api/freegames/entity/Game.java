package com.example.freegamessearch.api.freegames.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Game {
    public int id;
    public String title;
    public String thumbnail;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String shortDescription;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String gameUrl;
    public String genre;
    public String platform;
    public String publisher;
    public String developer;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String releaseDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String freetogameProfileUrl;
}
