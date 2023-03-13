package com.sparta.mg.librarywebapp.model.controller;

import com.sparta.mg.librarywebapp.model.repositories.AuthorRepository;
import com.sparta.mg.librarywebapp.model.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class AuthorController {
    private AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository,
                            BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/author/{id}")
    public String getAuthor(Model model, @PathVariable Integer id) {
        model.addAttribute("author",
                authorRepository.findById(id).orElse(null));
        return "author";
    }

    @GetMapping("/authors")
    public String getAllAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("authorsBooks");
        return "authors";
    }
    @GetMapping("/books/{id}")
    public String getBookByTitle(Model model,@PathVariable Integer id){
        model.addAttribute("book", bookRepository.findBookById(id).orElse(null));
        return "book";
    }
}
