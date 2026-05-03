package cn.wangruiping.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author wrp
 * @since 2026年04月17日 9:23
 **/
@SpringBootApplication(scanBasePackages = "cn.wangruiping")
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
