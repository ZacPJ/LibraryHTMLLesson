package com.sparta.mg.librarywebapp.model.repositories;

import com.sparta.mg.librarywebapp.model.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
       Optional<Author> findAuthorByFullName(String name);
}