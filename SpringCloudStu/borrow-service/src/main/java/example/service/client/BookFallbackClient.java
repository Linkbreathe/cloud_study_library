package example.service.client;

import com.test.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookFallbackClient implements BookClient{
    @Override
    public Book findBookById(int bid) {
        Book book = new Book();
        book.setBid(100);
        book.setTitle("报错！报错！");
        book.setTitle("报错了！");
        return book;
    }
}
