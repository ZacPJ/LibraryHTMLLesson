package com.sparta.mg.librarywebapp.model.repositories;

import com.sparta.mg.librarywebapp.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findBooksByAuthor_Id(Integer id);
    Optional<Book> findBookById(Integer id);
}