package com.example.freegamessearch.service;

import com.denizogut.repositorylib.entity.Game;
import com.denizogut.repositorylib.repository.IGameRepository;
import com.example.freegamessearch.api.freegames.entity.Games;
import com.example.freegamessearch.api.freegames.service.FreeGamesSearchApiService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Scope("prototype")
public class FreeGamesSearchService {

    private  final FreeGamesSearchApiService freeGamesSearchApiService;
    private final IGameRepository gameRepository;

    public FreeGamesSearchService(FreeGamesSearchApiService freeGamesSearchApiService, IGameRepository gameRepository) {
        this.freeGamesSearchApiService = freeGamesSearchApiService;
        this.gameRepository = gameRepository;
    }

    public Games findAllGames() {
        Games games = (Games) gameRepository.findAll();
        if (games.gameList.isEmpty()) {
            games = freeGamesSearchApiService.findAllGames();
        }
        return games;
    }

    public Games findAllGamesByCategory(String category)
    {
        Games games = (Games) gameRepository.findAllByGenre(category);
        if (games.gameList.isEmpty()) {
            games = freeGamesSearchApiService.findAllGamesByCategory(category);
        }
        return games;
    }

    public Games findAllGamesByPlatform(String platform)
    {
        Games games = (Games) gameRepository.findAllByPlatform(platform);
        if (games.gameList.isEmpty()) {
            games = freeGamesSearchApiService.findAllGamesByPlatform(platform);
        }
        return games;
    }

    public Optional<Game> findGameById(int id)
    {
        Optional<com.denizogut.repositorylib.entity.Game> game = gameRepository.findById(id);
        if(game.isEmpty()) {
            game = freeGamesSearchApiService.findGameById(id);
        }
        return game;
    }
}
