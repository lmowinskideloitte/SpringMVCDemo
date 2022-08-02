package com.deloitte.springmvcdemo.repository;

import com.deloitte.springmvcdemo.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Book findBookById(Long id);

    void deleteBookById(Long id);
}
