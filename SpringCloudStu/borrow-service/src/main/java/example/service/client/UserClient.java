package example.service.client;

import com.test.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient("user-service")
public interface UserClient {

    @RequestMapping("/user/{uid}")
    User getUserById(@PathVariable("uid") int uid);

    @RequestMapping("/user/borrow/{uid}")
    boolean userBorrow(@PathVariable("uid") int uid);

    @RequestMapping("/user/remain/{uid}")
    int userRemain(@PathVariable("uid") int uid);
}