package com.example.api.services;

import com.example.api.models.BookDTO;

import java.util.List;
import java.util.UUID;

public interface BookService {

    BookDTO saveNewBook(BookDTO book);

    List<BookDTO> getAllBooksSorted();

    boolean deleteBookById(UUID id);

    BookDTO getBookByTitle(String title);

    BookDTO updateBookAuthor(UUID id, BookDTO bookDTO);

}
