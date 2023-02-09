package com.example.freegamessearch.api.freegames.service;

import com.example.freegamessearch.api.freegames.entity.Game;
import com.example.freegamessearch.api.freegames.entity.Games;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Objects;

@Service
@Scope("prototype")
public class FreeGamesSearchService {
    private final RestTemplate restTemplate;
    @Value("${app.freegamesapi.games.url}")
    private String GAMES_URL;
    @Value("${app.freegamesapi.games.category.url}")
    private String GAMES_CATEGORY_URL;
    @Value("${app.freegamesapi.games.platform.url}")
    private String GAMES_PLATFORM_URL;

    public FreeGamesSearchService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Games getAllGames() {
        var response = restTemplate.getForEntity(GAMES_URL, Game[].class);
        var games = new Games();
        games.gameList = Arrays.asList(Objects.requireNonNull(response.getBody()));
        return games;
    }

    public Games getAllGamesByCategory(String category)
    {
        var response = restTemplate.getForEntity(String.format(GAMES_CATEGORY_URL,category), Game[].class);
        var games = new Games();
        games.gameList = Arrays.asList(Objects.requireNonNull(response.getBody()));
        return games;
    }

    public Games getAllGamesByPlatform(String category)
    {
        var response = restTemplate.getForEntity(String.format(GAMES_PLATFORM_URL,category), Game[].class);
        var games = new Games();
        games.gameList = Arrays.asList(Objects.requireNonNull(response.getBody()));
        return games;
    }
}
