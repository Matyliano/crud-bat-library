package com.example.batCrudBook.repository;

import com.example.batCrudBook.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
