package com.example.batCrudBook.controller;

import com.example.batCrudBook.entity.Book;
import com.example.batCrudBook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class BookController {

    @Autowired
    private BookService bookService;
//działa
    @GetMapping("/")
    public String savePage(Model model){
        model.addAttribute( "book", new Book() );
        model.addAttribute( "books",bookService.listAllBooks() );
        return "books";
    }

// 3 guzik, view - działa
    @RequestMapping("book/{id}")
    public String showBooks( @PathVariable Long id,Model model){
        model.addAttribute( "book",bookService.getBookById( id ) );
        return "bookshow";
    }


    //zapisywanie do bazy danych new booksów "submit"
 // nie działa
    @PostMapping("/book/update")
    public String updateBook(@ModelAttribute("editBook") Book editBook){
        if( bookService.saveBook(editBook) != null) {
              //  + book.getId()
        }
        return "redirect:/";
    }


    @RequestMapping("book/edit/{id}")   // edit  w guzikach - działa
    public String editBook( @PathVariable Long id, Model model){
        if(bookService.getBookById(id) != null) {
            model.addAttribute( "editBook", bookService.getBookById( id ) );
            return "bookform";
        } else
            return "redirect:/";

    }

    //usuwanie po id - działa, nie tykać.

    @RequestMapping("book/delete/{id}")
    public String delete(@PathVariable Long id){
        bookService.deleteBook(id);
        return "redirect:/";
    }

}
