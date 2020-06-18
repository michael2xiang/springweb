package com.imooc.web1.dao;

import com.imooc.web1.entity.Book;

import java.util.List;

public interface BookDao {
    List<Book> getAllBook();

    int updateBook(Book book);

    Book getBook(int id);
}
