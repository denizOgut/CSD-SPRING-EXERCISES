package com.denizogut.movie.data.dal;

import com.denizogut.movie.data.BeanName;
import com.denizogut.movie.data.entity.Movie;
import com.denizogut.movie.data.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component(BeanName.MOVIE_SERVICE_HELPER)
public class MovieServiceHelper {

    private  final MovieRepository movieRepository;

    public MovieServiceHelper(@Qualifier(BeanName.MOVIE_REPOSITORY) MovieRepository movieRepository)
    {
        this.movieRepository = movieRepository;
    }

    public Iterable<Movie> findByMonthAndYear(int month, int year)
    {
        return movieRepository.findByMonthAndYear(month,year);
    }

    public Iterable<Movie> findByYearBetween(int begin, int end)
    {
        return movieRepository.findByYearBetween(begin,end);
    }

    public Iterable<Movie> findByMonth(int month)
    {
        return movieRepository.findByMonth(month);
    }

    public Iterable<Movie> findByYear(int year)
    {
        return movieRepository.findByYear(year);
    }

    public Iterable<Movie> findMoviesOfDirector(long directorId)
    {
        return movieRepository.findMoviesOfDirector(directorId);
    }

    public Movie save(Movie movie)
    {
        return movieRepository.save(movie);
    }

    public Optional<Movie> findById(Long aLong)
    {
        return movieRepository.findById(aLong);
    }

    public long count()
    {
        return movieRepository.count();
    }
}
