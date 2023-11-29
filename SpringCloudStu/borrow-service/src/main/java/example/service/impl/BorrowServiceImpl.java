package example.service.impl;


import com.test.entity.Book;
import com.test.entity.Borrow;
import com.test.entity.User;
import example.entity.UserBorrowDetail;
import example.mapper.BorrowMapper;
import example.service.BorrowService;
import example.service.client.BookClient;
import example.service.client.UserClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService{

    @Resource
    BorrowMapper mapper;
    //RestTemplate支持多种方式的远程调用
    @Resource
    BookClient bookClient;
    @Resource
    UserClient userClient;
    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(int uid) {
        List<Borrow> borrow = mapper.getBorrowsByUid(uid);
        RestTemplate template = new RestTemplate();
        //这里通过调用getForObject来请求其他服务，并将结果自动进行封装
        //获取User信息
        User user = userClient.findUserById(uid);
        //获取每一本书的详细信息
        List<Book> bookList = borrow
                .stream()
                .map(b -> bookClient.findBookById(b.getBid()) )
                .collect(Collectors.toList());
        return new UserBorrowDetail(user, bookList);
    }
}