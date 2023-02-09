package com.denizogut.movieserviceapp.service;

import com.denizogut.movie.data.BeanName;
import com.denizogut.movie.data.dal.DirectorServiceHelper;
import com.denizogut.movieserviceapp.dto.*;
import com.denizogut.movieserviceapp.mapper.ICountMapper;
import com.denizogut.movieserviceapp.mapper.IDirectorFullNameMapper;
import com.denizogut.movieserviceapp.mapper.IDirectorMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DirectorService {

    private final DirectorServiceHelper directorServiceHelper;

    private final IDirectorMapper directorMapper;

    private final IDirectorFullNameMapper directorFullNameMapper;

    private final ICountMapper countMapper;

    public DirectorService( @Qualifier(BeanName.DIRECTOR_SERVICE_HELPER) DirectorServiceHelper directorServiceHelper,
                            @Qualifier("DirectorMapperConfig") IDirectorMapper directorMapper,
                            @Qualifier("DirectorWithFullNameMapperConfig") IDirectorFullNameMapper directorFullNameMapper,
                            @Qualifier("CountMapperConfig") ICountMapper countMapper)
    {
        this.directorServiceHelper = directorServiceHelper;
        this.directorMapper = directorMapper;
        this.directorFullNameMapper = directorFullNameMapper;
        this.countMapper = countMapper;
    }

    public CountDTO countDirectors()
    {
        return countMapper.toCountDTO(directorServiceHelper.count());
    }

    public DirectorsDTO findDirectorsOfMovie(long movieId)
    {
        var directorsDto = StreamSupport.stream(directorServiceHelper.findDirectorsOfMovie(movieId).spliterator(), false)
                .map(directorFullNameMapper::toDirectorWithFullNameDTO).collect(Collectors.toList());

        return (DirectorsDTO) directorsDto;
    }

    public Optional<DirectorDTO> finDirectorsById(long directorId)
    {
        return directorServiceHelper.findById(directorId).map(directorMapper::toDirectorDTO);
    }

    public DirectorDTO saveDirector(DirectorDTO directorDTO)
    {
        directorServiceHelper.save(directorMapper.toDirector(directorDTO));

        return directorDTO;
    }
}
