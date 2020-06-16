package com.example.batCrudBook.service;

import com.example.batCrudBook.converter.BookConverter;
import com.example.batCrudBook.dto.BookDto;
import com.example.batCrudBook.entity.Book;
import com.example.batCrudBook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookConverter converter;

    @Autowired
    public BookService(BookRepository bookRepository, BookConverter converter) {
        this.bookRepository = bookRepository;
        this.converter = converter;
    }

    public Optional<BookDto> getBookById(Long id) {
        Optional<Book> bookById = bookRepository.findById(id);
        return bookById.map(converter::convert);
    }


    public List<BookDto> findAll() {
        return bookRepository.findAll().stream().map(converter::convert).collect(Collectors.toList());
    }

    public BookDto saveBook(BookDto bookdto) {
        Book entityForNewBook = converter.convert(bookdto);
        Book save = bookRepository.save(entityForNewBook);
        return converter.convert(save);

    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

}
