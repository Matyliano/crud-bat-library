package com.matyliano.crudbatlibrary.service;


import com.matyliano.crudbatlibrary.dto.BookDto;
import com.matyliano.crudbatlibrary.entity.Book;
import com.matyliano.crudbatlibrary.mapper.BookMapper;
import com.matyliano.crudbatlibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public List<BookDto> listAllBooks(){
        List<Book> bookList = bookRepository.findAll();
        return bookList.stream().map(bookMapper::toDto).collect(Collectors.toList());
    }

    public Book getBookById(Long id){
        return bookRepository.getOne( id );
    }

    public Book saveBook(Book book){
        return bookRepository.save( book );
    }

    public void deleteBook(Long id){
        bookRepository.deleteById( id );
    }

}
