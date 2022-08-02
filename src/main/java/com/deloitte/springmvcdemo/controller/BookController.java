package com.deloitte.springmvcdemo.controller;

import com.deloitte.springmvcdemo.entity.Book;
import com.deloitte.springmvcdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.NOT_FOUND;

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
        Book res = bookService.updateBook(id, book);
        if (res == null) {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find book with this id");
        }
        return res;
    }

    @DeleteMapping(value = "/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return "Deleted successfully";
    }
}
