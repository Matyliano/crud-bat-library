package com.example.batCrudBook.controller;

import com.example.batCrudBook.dto.BookDto;
import com.example.batCrudBook.entity.Book;
import com.example.batCrudBook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/books")
    public String saveBook(Model model) {
        model.addAttribute("book", new BookDto());
        model.addAttribute("books", bookService.findAll());
        return "books";
    }


    @RequestMapping("book/{id}")
    public String showBooks(@PathVariable Long id, Model model) {
        bookService.getBookById(id).ifPresent(o -> model.addAttribute("book", o)); //unwrap an Optional
        return "bookshow";
    }


    @PostMapping("/book/update")
    public String updateBook(@ModelAttribute("editBook") BookDto editBook) {
        if (bookService.saveBook(editBook) != null) {

        }
        return "redirect:/books";
    }


    @PostMapping("/book/add")
    public String addBook(@ModelAttribute("addBook") BookDto addBook) {
        if (bookService.saveBook(addBook) != null) {

        }
        return "redirect:/books";

    }


    @RequestMapping("book/edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        if (bookService.getBookById(id) != null) {
            model.addAttribute("editBook", bookService.getBookById(id));
            return "bookform";
        }
        return "redirect:/books";

    }


    @RequestMapping("book/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/books";
    }
}
