package com.deloitte.springmvcdemo.service;

import com.deloitte.springmvcdemo.entity.Book;

public interface BookService {

    Book findBookById(Long id);

    Book saveBook(Book book);

    Book updateBook(Long id, Book book);

    void deleteBookById(Long id);
}
