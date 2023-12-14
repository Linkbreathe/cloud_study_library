package example.service.impl;

import com.test.entity.User;
import example.service.client.UserClient;
import org.springframework.stereotype.Component;


public class UserClientImpl implements UserClient {
    @Override
    public User getUserById(int uid) {
        User user = new User();
        user.setName("我是替代方案");
        return user;
    }

    @Override
    public boolean userBorrow(int uid) {
        return false;
    }

    @Override
    public int userRemain(int uid) {
        return 0;
    }
}
