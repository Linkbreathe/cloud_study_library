package example;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableAutoDataSourceProxy
@SpringBootApplication
public class BorrowApplication {
    public static void main(String[] args) {
        SpringApplication.run(BorrowApplication.class,args);
    }
}
