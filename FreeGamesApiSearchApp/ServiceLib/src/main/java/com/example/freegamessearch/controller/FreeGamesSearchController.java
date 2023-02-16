package com.example.freegamessearch.controller;

import com.denizogut.repositorylib.entity.Game;
import com.example.freegamessearch.api.freegames.entity.Games;
import com.example.freegamessearch.service.FreeGamesSearchService;
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
    public ResponseEntity<Games> findAllGames()
    {
        var games = freeGamesSearchService.findAllGames();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @GetMapping("games/category/{category}")
    public ResponseEntity<Games> findAllGamesByCategory(@PathVariable String category)
    {
        var games = freeGamesSearchService.findAllGamesByCategory(category);
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @GetMapping("games/platform/{platform}")
    public ResponseEntity<Games> findAllGamesByPlatform(@PathVariable String platform)
    {
        var games = freeGamesSearchService.findAllGamesByPlatform(platform);
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @GetMapping("/game/id/{id}")
    public ResponseEntity<Game> findGameById(@PathVariable int id) {
        var gameOptional = freeGamesSearchService.findGameById(id);
        if (gameOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var game = gameOptional.get();
        return ResponseEntity.ok(game);
    }
}
