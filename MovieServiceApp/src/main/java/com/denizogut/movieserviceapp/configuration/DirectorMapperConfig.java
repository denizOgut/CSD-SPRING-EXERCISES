package com.denizogut.movieserviceapp.configuration;

import com.denizogut.movieserviceapp.mapper.IDirectorFullNameMapper;
import com.denizogut.movieserviceapp.mapper.IDirectorMapper;
import com.denizogut.movieserviceapp.mapper.IMovieMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectorMapperConfig {
    @Bean("DirectorMapperConfig")
    public IDirectorMapper getDirectorMapper()
    {
        return Mappers.getMapper(IDirectorMapper.class);
    }

    @Bean("DirectorWithFullNameMapperConfig")
    public IDirectorFullNameMapper getDirectorWithFullNameMapper()
    {
        return Mappers.getMapper(IDirectorFullNameMapper.class);
    }
}
