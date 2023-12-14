package example.controller;

import com.test.entity.User;
import example.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    UserService service;

    //这里以RESTFul风格为例
    @RequestMapping("/user/{uid}")
    public User findUserById(@PathVariable("uid") int uid){
        return service.getUserById(uid);
    }

    @RequestMapping("/user/remain/{uid}")
    public int userRemain(@PathVariable("uid") int uid){
        return service.getRemain(uid);
    }

    @RequestMapping("/user/borrow/{uid}")
    public boolean userBorrow(@PathVariable("uid") int uid){
        int remain = service.getRemain(uid);
        return service.setRemain(uid, remain - 1);
    }
}