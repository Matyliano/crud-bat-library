package com.example.batCrudBook.service;

import com.example.batCrudBook.entity.Book;
import com.example.batCrudBook.repository.BookRepository;
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
