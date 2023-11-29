package example.service.client;

import com.test.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserFallbackClient implements UserClient{
    @Override
    public User findUserById(int uid) {
        User user = new User();
        user.setName("我是替代方案");
        return null;
    }
}
