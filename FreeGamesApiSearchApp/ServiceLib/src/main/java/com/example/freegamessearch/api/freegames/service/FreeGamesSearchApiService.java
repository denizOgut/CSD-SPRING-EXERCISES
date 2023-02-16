package com.example.freegamessearch.api.freegames.service;

import com.example.freegamessearch.api.freegames.entity.Game;
import com.example.freegamessearch.api.freegames.entity.Games;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

@Service
@Scope("prototype")
public class FreeGamesSearchApiService {
    private final RestTemplate restTemplate;
    @Value("${app.freegamesapi.games.url}")
    private String GAMES_URL;
    @Value("${app.freegamesapi.games.category.url}")
    private String GAMES_CATEGORY_URL;
    @Value("${app.freegamesapi.games.platform.url}")
    private String GAMES_PLATFORM_URL;
    @Value("${app.freegamesapi.games.by.id.url}")
    private String GAME_BY_ID_URL;


    public FreeGamesSearchApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Games findAllGames() {
        var response = restTemplate.getForEntity(GAMES_URL, Game[].class);
        var games = new Games();
        games.gameList = Arrays.asList(Objects.requireNonNull(response.getBody()));
        return games;
    }

    public Games findAllGamesByCategory(String category)
    {
        var response = restTemplate.getForEntity(String.format(GAMES_CATEGORY_URL,category), Game[].class);
        var games = new Games();
        games.gameList = Arrays.asList(Objects.requireNonNull(response.getBody()));
        return games;
    }

    public Games findAllGamesByPlatform(String platform)
    {
        var response = restTemplate.getForEntity(String.format(GAMES_PLATFORM_URL,platform), Game[].class);
        var games = new Games();
        games.gameList = Arrays.asList(Objects.requireNonNull(response.getBody()));
        return games;
    }

    public Optional<com.denizogut.repositorylib.entity.Game> findGameById(int id)
    {
        return restTemplate.getForObject(String.format(GAME_BY_ID_URL,id),Game.class);
    }
}
