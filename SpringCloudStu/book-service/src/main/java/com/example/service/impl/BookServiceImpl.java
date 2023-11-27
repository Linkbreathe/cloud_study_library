package com.example.service.impl;

import com.example.mapper.BookMapper;
import com.example.service.BookService;
import com.test.entity.Book;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookMapper mapper;

    @Override
    public Book getBookById(int bid) {
        return mapper.getBookById(bid);
    }
}