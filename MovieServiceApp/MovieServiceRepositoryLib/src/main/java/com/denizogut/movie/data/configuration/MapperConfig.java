package com.denizogut.movie.data.configuration;

import com.denizogut.movie.data.BeanName;
import com.denizogut.movie.data.mapper.IDirectorMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(BeanName.MAPPER_CONFIG)
public class MapperConfig {
    @Bean(BeanName.DIRECTOR_MAPPER)
    public IDirectorMapper getDirectorMapper()
    {
        return Mappers.getMapper(IDirectorMapper.class);
    }
}
