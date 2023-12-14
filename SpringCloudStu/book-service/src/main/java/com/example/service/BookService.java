package com.example.service;


import com.test.entity.Book;

public interface BookService {
    Book getBookById(int bid);
    boolean setRemain(int bid, int count);
    int getRemain(int bid);
}