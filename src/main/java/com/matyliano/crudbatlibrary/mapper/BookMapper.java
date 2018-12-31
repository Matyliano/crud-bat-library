package com.matyliano.crudbatlibrary.mapper;

import com.matyliano.crudbatlibrary.dto.BookDto;
import com.matyliano.crudbatlibrary.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")

public abstract class BookMapper {

    @Mappings({
    @Mapping(target = "id", source = "dto.id"),
    @Mapping(target = "author", source = "dto.author"),
    @Mapping(target = "title", source = "dto.title")})
    public abstract Book toEntity(BookDto dto);

    @Mappings({
            @Mapping(target = "id", source = "book.id"),
            @Mapping(target = "author", source = "book.author"),
            @Mapping(target = "title", source = "book.title")})
    public abstract BookDto toDto(Book entity);
}
