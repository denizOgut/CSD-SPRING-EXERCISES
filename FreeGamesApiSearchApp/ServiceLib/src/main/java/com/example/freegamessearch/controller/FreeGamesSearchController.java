package com.example.freegamessearch.controller;

import com.example.freegamessearch.api.freegames.entity.Games;
import com.example.freegamessearch.api.freegames.service.FreeGamesSearchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class FreeGamesSearchController {
    private final FreeGamesSearchService freeGamesSearchService;

    public FreeGamesSearchController(FreeGamesSearchService freeGamesSearchService) {
        this.freeGamesSearchService = freeGamesSearchService;
    }

    @GetMapping("games")
    public ResponseEntity<Games> getAllGames()
    {
        var games = freeGamesSearchService.getAllGames();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @GetMapping("games/category/{category}")
    public ResponseEntity<Games> getAllGamesByCategory(@PathVariable String category)
    {
        var games = freeGamesSearchService.getAllGamesByCategory(category);
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @GetMapping("games/platform/{platform}")
    public ResponseEntity<Games> getAllGamesByPlatform(@PathVariable String platform)
    {
        var games = freeGamesSearchService.getAllGamesByPlatform(platform);
        return new ResponseEntity<>(games, HttpStatus.OK);
    }
}
