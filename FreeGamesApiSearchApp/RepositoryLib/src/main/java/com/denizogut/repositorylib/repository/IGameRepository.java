package com.denizogut.repositorylib.repository;

import com.denizogut.repositorylib.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IGameRepository extends JpaRepository <Game,Integer> {
     Optional<Game> findById(int id);

     List<Game> finAllByPlatform(String platform);

    List<Game> finAllByGenre(String platform);

}
