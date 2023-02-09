package com.denizogut.movieserviceapp.service;

import com.denizogut.movie.data.BeanName;
import com.denizogut.movie.data.dal.MovieServiceHelper;
import com.denizogut.movieserviceapp.dto.CountDTO;
import com.denizogut.movieserviceapp.dto.MovieDTO;
import com.denizogut.movieserviceapp.dto.MoviesDTO;
import com.denizogut.movieserviceapp.mapper.ICountMapper;
import com.denizogut.movieserviceapp.mapper.IMovieMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieService {
    private final MovieServiceHelper movieServiceHelper;
    private final IMovieMapper movieMapper;

    private final ICountMapper countMapper;

    public MovieService(@Qualifier(BeanName.MOVIE_SERVICE_HELPER) MovieServiceHelper movieServiceHelper,
                        @Qualifier("MovieMapperConfig") IMovieMapper movieMapper,
                        @Qualifier("CountMapperConfig") ICountMapper countMapper)
    {
        this.movieServiceHelper = movieServiceHelper;
        this.movieMapper = movieMapper;
        this.countMapper = countMapper;
    }

    public CountDTO countMovies()
    {
        return countMapper.toCountDTO(movieServiceHelper.count());
    }

    public MoviesDTO findMoviesByMonth(int month)
    {
        var moviesDto = StreamSupport.stream(movieServiceHelper.findByMonth(month).spliterator(), false)
                .map(movieMapper::toMovieDTO).collect(Collectors.toList());


        return (MoviesDTO) moviesDto;
    }

    public MoviesDTO findMoviesByYear(int year)
    {
        var moviesDto = StreamSupport.stream(movieServiceHelper.findByYear(year).spliterator(), false)
                .map(movieMapper::toMovieDTO).collect(Collectors.toList());

        return (MoviesDTO) moviesDto;
    }

    public MoviesDTO findMoviesByMonthAndYear(int month, int year)
    {
        var moviesDto = StreamSupport.stream(movieServiceHelper.findByMonthAndYear(month, year).spliterator(), false)
                .map(movieMapper::toMovieDTO).collect(Collectors.toList());

        return (MoviesDTO) moviesDto;
    }

    public MoviesDTO findMoviesByYearBetween(int begin, int end)
    {
        var moviesDto = StreamSupport.stream(movieServiceHelper.findByYearBetween(begin, end).spliterator(), false)
                .map(movieMapper::toMovieDTO).collect(Collectors.toList());

        return (MoviesDTO) moviesDto;
    }

    public MoviesDTO findMoviesOfDirector(long directorId)
    {
        var moviesDto = StreamSupport.stream(movieServiceHelper.findMoviesOfDirector(directorId).spliterator(), false)
                .map(movieMapper::toMovieDTO).collect(Collectors.toList());

        return (MoviesDTO) moviesDto;
    }

    public Optional<MovieDTO> findMoviesById(long movieId)
    {
      return movieServiceHelper.findById(movieId).map(movieMapper::toMovieDTO);
    }

    public MovieDTO saveMovie(MovieDTO movieDTO)
    {
        movieServiceHelper.save(movieMapper.toMovie(movieDTO));

        return movieDTO;
    }

}
