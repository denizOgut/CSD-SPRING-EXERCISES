package com.example.freegamessearch.api.freegames.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Game {
    public int id;
    public String title;
    public String thumbnail;

    public String shortDescription;

    public String gameUrl;
    public String genre;
    public String platform;
    public String publisher;
    public String developer;

    public String releaseDate;

    public String freetogameProfileUrl;
}
