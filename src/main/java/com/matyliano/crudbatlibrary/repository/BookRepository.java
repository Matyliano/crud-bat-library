package com.matyliano.crudbatlibrary.repository;

import com.matyliano.crudbatlibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
