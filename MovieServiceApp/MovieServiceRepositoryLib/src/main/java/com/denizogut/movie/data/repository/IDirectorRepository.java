package com.denizogut.movie.data.repository;

import com.denizogut.movie.data.entity.Director;
import com.denizogut.movie.data.entity.DirectorWithFullName;
import com.denizogut.movie.data.entity.Movie;
import org.springframework.data.repository.CrudRepository;

public interface IDirectorRepository extends CrudRepository<Director, Long> {
    Iterable<Director> findByFirstName(String firstName);

    Iterable<DirectorWithFullName> findByBirthDateBetween(int begin, int end);

    Iterable <DirectorWithFullName> findDirectorsOfMovie(long movieId);
}
