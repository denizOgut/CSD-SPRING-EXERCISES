package com.denizogut.movieserviceapp.configuration;

import com.denizogut.movieserviceapp.mapper.IMovieMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieMapperConfig {
    @Bean("MovieMapperConfig")
    public IMovieMapper getMovieMapper()
    {
        return Mappers.getMapper(IMovieMapper.class);
    }
}
