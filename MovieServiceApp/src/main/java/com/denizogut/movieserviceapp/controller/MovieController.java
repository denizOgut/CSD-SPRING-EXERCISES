package com.denizogut.movieserviceapp.controller;

import com.denizogut.movieserviceapp.dto.CountDTO;
import com.denizogut.movieserviceapp.dto.MovieDTO;
import com.denizogut.movieserviceapp.dto.MoviesDTO;
import com.denizogut.movieserviceapp.service.MovieService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService)
    {
        this.movieService = movieService;
    }

    @GetMapping("count")
    public CountDTO count()
    {
        return movieService.countMovies();
    }

    @GetMapping("sdate/between/year")
    public MoviesDTO findByYearBetween(@RequestParam("begin") int begin, @RequestParam("end")int end)
    {
        return movieService.findMoviesByYearBetween(begin, end);
    }

    @GetMapping("sdate/month")
    public MoviesDTO findByMonth(@RequestParam("m") int month)
    {
        return movieService.findMoviesByMonth(month);
    }

    @GetMapping("sdate/year")
    public MoviesDTO findByYear(@RequestParam("y") int year)
    {
        return movieService.findMoviesByMonth(year);
    }

    @GetMapping("sdate/month-year")
    public MoviesDTO findMoviesByMonthAndYear(@RequestParam("m") int month, @RequestParam("y")int year)
    {
        return movieService.findMoviesByMonthAndYear(month, year);
    }

    @PostMapping("director/save")
    public MovieDTO save(@RequestBody MovieDTO movieDTO)
    {
        return movieService.saveMovie(movieDTO);
    }
}
