package example.service.client;

import com.test.entity.Book;
import com.test.entity.User;

public class BookClientFallback implements BookClient{
    @Override
    public Book getBookById(int bid) {
       Book book = new Book();
        book.setTitle("我是替代方案");
        return book;
    }

    @Override
    public boolean bookBorrow(int bid) {
        return false;
    }

    @Override
    public int bookRemain(int bid) {
        return 0;
    }
}
