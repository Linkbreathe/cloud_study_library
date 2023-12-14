package com.example.mapper;

import com.test.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BookMapper {

    @Select("select * from DB_BOOK where bid = #{bid}")
    Book getBookById(int bid);

    @Select("select count from DB_BOOK  where bid = #{bid}")
    int getRemain(int bid);

    @Update("update DB_BOOK set count = #{count}  where bid = #{bid}")
    int setRemain(int bid, int count);
}