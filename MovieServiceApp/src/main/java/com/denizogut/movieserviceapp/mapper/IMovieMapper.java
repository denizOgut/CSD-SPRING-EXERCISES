package com.denizogut.movieserviceapp.mapper;

import com.denizogut.movie.data.entity.Movie;
import com.denizogut.movieserviceapp.dto.MovieDTO;
import com.denizogut.movieserviceapp.dto.MoviesDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMovieMapper {
    MovieDTO toMovieDTO(Movie movie);

    Movie toMovie(MovieDTO movieDto);

    default MoviesDTO toMoviesDTO(List<MovieDTO> movies)
    {
        var dto = new MoviesDTO();

        dto.movies = movies;

        return dto;
    }
}
