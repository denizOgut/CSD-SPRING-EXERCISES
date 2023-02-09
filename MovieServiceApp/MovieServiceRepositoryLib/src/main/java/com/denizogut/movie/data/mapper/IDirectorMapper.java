package com.denizogut.movie.data.mapper;

import com.denizogut.movie.data.entity.Director;
import com.denizogut.movie.data.entity.DirectorSave;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "DirectorMapperImpl")
public interface IDirectorMapper extends IOptinalMapper{

    @Mapping(source = "middleName", target = "middleName", ignore = true,qualifiedByName = "toOptional")
    Director toDirector(DirectorSave veterinarianSave);
}
