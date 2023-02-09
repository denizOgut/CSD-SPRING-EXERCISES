package com.denizogut.movieserviceapp.mapper;

import com.denizogut.movie.data.entity.Director;
import com.denizogut.movie.data.entity.Movie;
import com.denizogut.movieserviceapp.dto.CountDTO;
import com.denizogut.movieserviceapp.dto.DirectorDTO;
import com.denizogut.movieserviceapp.dto.DirectorsDTO;
import com.denizogut.movieserviceapp.dto.MovieDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface IDirectorMapper {

    @Mapping(source = "middleName", target = "middleName", qualifiedByName = "unwrap")
    DirectorDTO toDirectorDTO(Director director);

    @Mapping(source = "middleName", target = "middleName", qualifiedByName = "wrap")
    Director toDirector(DirectorDTO directorDTO);

    default DirectorsDTO toDirectorsDTO(List<DirectorDTO> directors)
    {
        var dto = new DirectorsDTO();

        dto.directors = directors;

        return dto;
    }

    @Named("unwrap")
    default <T> T unwrap(Optional<T> optional)
    {
        return optional.orElse(null);
    }

    @Named("wrap")
    default  Optional<String> wrap(String value)
    {
        return Optional.ofNullable(value);
    }
}
