package com.denizogut.movieserviceapp.mapper;

import com.denizogut.movie.data.entity.DirectorWithFullName;
import com.denizogut.movie.data.mapper.IOptinalMapper;
import com.denizogut.movieserviceapp.dto.DirectorWithFullNameDTO;
import com.denizogut.movieserviceapp.dto.DirectorsWithFullNameDTO;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface IDirectorFullNameMapper extends IOptinalMapper {

    DirectorWithFullNameDTO toDirectorWithFullNameDTO(DirectorWithFullName directorWithFullName);

    default DirectorsWithFullNameDTO toDirectorsWithFullNameDTO(List<DirectorWithFullNameDTO> directors)
    {
        var dto = new DirectorsWithFullNameDTO();

        dto.directors = directors;

        return dto;
    }
}
