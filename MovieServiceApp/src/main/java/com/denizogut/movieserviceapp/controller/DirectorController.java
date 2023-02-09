package com.denizogut.movieserviceapp.controller;

import com.denizogut.movieserviceapp.dto.CountDTO;
import com.denizogut.movieserviceapp.dto.DirectorDTO;
import com.denizogut.movieserviceapp.dto.DirectorsDTO;
import com.denizogut.movieserviceapp.service.DirectorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/directors")
public class DirectorController {

    private final DirectorService directorService;

    public DirectorController(DirectorService directorService)
    {
        this.directorService = directorService;
    }

    @GetMapping("count")
    public CountDTO countDirectors()
    {
        return directorService.countDirectors();
    }

    @GetMapping("find/director/movies")
    public DirectorsDTO findDirectorsOfMovie(@RequestParam("id") long movieId)
    {
        return directorService.findDirectorsOfMovie(movieId);
    }

    @GetMapping("find/director")
    public ResponseEntity<DirectorDTO> finDirectorsById(@RequestParam("id")long directorId)
    {
        return ResponseEntity.of(directorService.finDirectorsById(directorId));
    }

    @PostMapping("director/save")
    public DirectorDTO save(@RequestBody DirectorDTO directorSave)
    {
        return directorService.saveDirector(directorSave);
    }
}
