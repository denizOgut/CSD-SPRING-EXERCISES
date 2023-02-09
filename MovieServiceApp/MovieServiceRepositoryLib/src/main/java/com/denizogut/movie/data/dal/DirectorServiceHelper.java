package com.denizogut.movie.data.dal;

import com.denizogut.movie.data.BeanName;
import com.denizogut.movie.data.entity.Director;
import com.denizogut.movie.data.entity.DirectorSave;
import com.denizogut.movie.data.entity.DirectorWithFullName;
import com.denizogut.movie.data.mapper.IDirectorMapper;
import com.denizogut.movie.data.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component(BeanName.DIRECTOR_SERVICE_HELPER)
public class DirectorServiceHelper {

    private final DirectorRepository directorRepository;
    private final IDirectorMapper directorMapper;

    public DirectorServiceHelper(@Qualifier(BeanName.DIRECTOR_REPOSITORY) DirectorRepository directorRepository,
                                 @Qualifier(BeanName.DIRECTOR_MAPPER)IDirectorMapper directorMapper)
    {
        this.directorRepository = directorRepository;
        this.directorMapper = directorMapper;
    }

    public Iterable<Director> findByFirstName(String firstName)
    {
        return directorRepository.findByFirstName(firstName);
    }

    public Iterable<DirectorWithFullName> findByBirthDateBetween(int begin, int end)
    {
        return directorRepository.findByBirthDateBetween(begin, end);
    }

    public Iterable<DirectorWithFullName> findDirectorsOfMovie(long movieId)
    {
        return directorRepository.findDirectorsOfMovie(movieId);
    }

    public Director save(Director director)
    {
        return directorRepository.save(director);
    }

    public Optional<Director> findById(Long aLong)
    {
        return directorRepository.findById(aLong);
    }

    public Iterable<Director> findAllById(Iterable<Long> longs)
    {
        return directorRepository.findAllById(longs);
    }

    public long count()
    {
        return directorRepository.count();
    }


}
