package com.denizogut.movie.data.mapper;

import org.mapstruct.Named;

import java.util.Optional;

public interface IOptinalMapper {
    @Named("toOptional")
    static <T> Optional<T> toOptional(T t) {
        return Optional.ofNullable(t);
    }
}
