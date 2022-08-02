package com.deloitte.springmvcdemo.service.impl;

import com.deloitte.springmvcdemo.entity.Book;
import com.deloitte.springmvcdemo.repository.BookRepository;
import com.deloitte.springmvcdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;


    @Override
    public Book findBookById(Long id) {
        return bookRepository.findBookById(id);
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book bookById = bookRepository.findBookById(id);
        if (bookById != null) {
            System.out.println(bookById.getId());
            bookById.setAuthor(book.getAuthor());
            bookById.setTitle(book.getTitle());
            return saveBook(bookById);
        }
        return null;
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteBookById(id);
    }
}
