package com.denizogut.movieserviceapp.mapper;

import com.denizogut.movieserviceapp.dto.CountDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICountMapper {
     CountDTO toCountDTO(Long count);





}
