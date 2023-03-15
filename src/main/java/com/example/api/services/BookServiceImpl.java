package com.example.api.services;

import com.example.api.entities.Book;
import com.example.api.mappers.BookMapper;
import com.example.api.models.BookDTO;
import com.example.api.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDTO saveNewBook(BookDTO book) {
        return bookMapper
                .bookToBookDto(bookRepository.save(bookMapper.bookDtoToBook(book)));
    }

    @Override
    public List<BookDTO> getAllBooksSorted() {
        return bookRepository.findAll()
                .stream().sorted((b1, b2) -> {
                    if(b1.getAuthor().compareToIgnoreCase(b2.getAuthor()) < 0)
                        return -1;
                    else if(b1.getAuthor().compareToIgnoreCase(b2.getAuthor()) > 0)
                        return 1;
                    else return Integer.compare(b1.getTitle().compareToIgnoreCase(b2.getTitle()), 0);
                })
                .map(bookMapper::bookToBookDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteBookById(UUID id) {
        if(bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public BookDTO getBookByTitle(String title) {
        return bookMapper.bookToBookDto(bookRepository.findByTitle(title));
    }

    @Override
    public BookDTO updateBookAuthor(UUID id, BookDTO bookDTO) {
        Book bookToUpdate = bookRepository.getReferenceById(id);
        bookToUpdate.setAuthor(bookDTO.getAuthor());
        bookRepository.save(bookToUpdate);
        return bookMapper.bookToBookDto(bookToUpdate);
    }
}
