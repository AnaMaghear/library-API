package com.example.api.mappers;

import com.example.api.entities.Book;
import com.example.api.models.BookDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {
    Book bookDtoToBook(BookDTO bookDTO);

    BookDTO bookToBookDto(Book book);
}
