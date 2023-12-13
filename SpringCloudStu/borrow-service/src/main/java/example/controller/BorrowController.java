package example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSONObject;
import example.entity.UserBorrowDetail;
import example.service.BorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
public class BorrowController {

    @Resource
    BorrowService service;

    @RequestMapping("/borrow/{uid}")
    UserBorrowDetail findUserBorrows(@PathVariable("uid") int uid){
        return service.getUserBorrowDetailByUid(uid);
    }

    @RequestMapping("/borrow2/{uid}")
    UserBorrowDetail findUserBorrows2(@PathVariable("uid") int uid){
        return service.getUserBorrowDetailByUid(uid);
    }

    @RequestMapping("/blocked")
    JSONObject blocked(){
        JSONObject object = new JSONObject();
        object.put("code", 403);
        object.put("success", false);
        object.put("massage", "您的请求频率过快，请稍后再试！");
        return object;
    }

    @RequestMapping("/test")
    @SentinelResource(value = "test",
            fallback = "except",    //fallback指定出现异常时的替代方案
            blockHandler = "limitStream",
            exceptionsToIgnore = IOException.class)  //忽略那些异常，也就是说这些异常出现时不使用替代方案
    String test(){
        throw new RuntimeException("HelloWorld！");
    }

    //替代方法必须和原方法返回值和参数一致，最后可以添加一个Throwable作为参数接受异常
    String except(Throwable t){
        return t.getMessage();
    }
    String limitStream(BlockException e){
        return "limited stream";
    }

    @RequestMapping("/test_param")
    @SentinelResource(value = "test_param",
            blockHandler = "paramLimitStream",
            fallback = "except_param",
            exceptionsToIgnore = IOException.class)
        //注意这里需要添加@SentinelResource才可以，用户资源名称就使用这里定义的资源名称
    String test_param(@RequestParam(value = "a", required = false) Integer a,
                            @RequestParam(value = "b", required = false) Integer b,
                            @RequestParam(value = "c",required = false) Integer c) {
        return "请求成功！a = "+a+", b = "+b+", c = "+c;
    }

    String except_param(Integer a, Integer b, Integer c, Throwable t){
        return t.getMessage();
    }
    String paramLimitStream(BlockException e){
        return "limited stream";
    }
}