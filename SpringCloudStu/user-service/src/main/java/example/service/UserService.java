package example.service;


import com.test.entity.User;

public interface UserService {
    User getUserById(int uid);
    int getRemain(int uid);
    boolean setRemain(int uid, int count);
}