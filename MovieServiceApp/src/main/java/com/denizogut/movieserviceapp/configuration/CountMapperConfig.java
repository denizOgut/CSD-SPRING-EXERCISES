package com.denizogut.movieserviceapp.configuration;

import com.denizogut.movieserviceapp.mapper.ICountMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountMapperConfig {
    @Bean("CountMapperConfig")
    public ICountMapper getCountMapper()
    {
        return Mappers.getMapper(ICountMapper.class);
    }
}
