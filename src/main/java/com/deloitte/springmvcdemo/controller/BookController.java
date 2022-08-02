package com.deloitte.springmvcdemo.controller;

import com.deloitte.springmvcdemo.entity.Book;
import com.deloitte.springmvcdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping(value = "/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.findBookById(id);
    }

    @PostMapping(value = "")
    public Book saveBook(@Valid @RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping(value = "/{id}")
    public Book updateBook(@PathVariable Long id, @Valid @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return "Deleted successfully";
    }
}
