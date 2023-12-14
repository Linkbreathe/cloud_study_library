package example.service.impl;

import com.test.entity.User;
import example.mapper.UserMapper;
import example.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {


    @Resource
    UserMapper mapper;

    @Override
    public User getUserById(int uid) {
        return mapper.getUserById(uid);
    }

    @Override
    public int getRemain(int uid) {
        return mapper.getUserBookRemain(uid);
    }

    @Override
    public boolean setRemain(int uid, int count) {
        return mapper.updateBookCount(uid, count) > 0;
    }
}