package com.example.api.bootstrap;

import com.example.api.entities.Book;
import com.example.api.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {
    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBookData();
    }

    private void loadBookData(){
        if(bookRepository.count() == 0){
            Book book1 = Book.builder().author("Drumes").title("Elevul Dima dintr-a saptea").build();
            Book book2 = Book.builder().author("Bacovia").title("Plumb").build();

            bookRepository.save(book1);
            bookRepository.save(book2);

        }
    }
}
