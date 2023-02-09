package com.denizogut.movie.data.repository;

import com.denizogut.movie.data.entity.DirectorWithFullName;
import com.denizogut.movie.data.entity.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IMovieRepository extends CrudRepository<Movie, Long> {

    Iterable<Movie> findByMonthAndYear(int month, int year);

    Iterable<Movie> findByYearBetween(int begin, int end);

    Iterable<Movie> findByMonth(int month);

    Iterable<Movie> findByYear(int year);

    Iterable <Movie> findMoviesOfDirector(long directorId);
}
