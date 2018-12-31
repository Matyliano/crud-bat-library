package com.matyliano.crudbatlibrary.service;


import com.matyliano.crudbatlibrary.entity.Book;
import com.matyliano.crudbatlibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public List<Book> listAllBooks(){
        return bookRepository.findAll();
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
