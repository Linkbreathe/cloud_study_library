package example.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import example.entity.UserBorrowDetail;
import example.service.BorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;

@RestController
public class BorrowController {

    @Resource
    BorrowService service;

    // 采用onError方案
//    @HystrixCommand(fallbackMethod = "onError")
    @RequestMapping("/borrow/{uid}")
    UserBorrowDetail findUserBorrows(@PathVariable("uid") int uid){
        return service.getUserBorrowDetailByUid(uid);
    }

    //备选方案，这里直接返回空列表了
    //注意参数和返回值要和上面的一致
//    UserBorrowDetail onError(int uid){
//        return new UserBorrowDetail(null, Collections.emptyList());
//    }
}