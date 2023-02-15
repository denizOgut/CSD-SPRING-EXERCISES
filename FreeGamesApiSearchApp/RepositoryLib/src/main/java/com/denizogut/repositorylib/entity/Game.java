package com.denizogut.repositorylib.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name =  "id")
    public int id;
    @Column(name =  "title")
    public String title;
    @Column(name =  "thumbnail")
    public String thumbnail;
    @Column(name =  "short_description")
    public String shortDescription;
    @Column(name =  "game_url")
    public String gameUrl;
    @Column(name = "genre")
    public String genre;
    @Column(name =  "platform")
    public String platform;
    @Column(name =  "publisher")
    public String publisher;
    @Column(name = "developer")
    public String developer;
    @Column(name = "release_date")
    public String releaseDate;

    @Column(name = "free_to_game_profile_url")
    public String freetogameProfileUrl;
}
