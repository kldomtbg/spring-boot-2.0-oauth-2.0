package com.ywsoftware.oa.authServer;

import com.ywsoftware.oa.authServer.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by userFly on 2018/5/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void saveUser() {
        userService.saveUser("a","付玉","1","1");
    }

    @Test
    public void deleteUser() {
        userService.deleteUser("a");
    }

    @Test
    public void update() {
        userService.update("测试", "3");
    }

    @Test
    public void getUser() {
        userService.getUser("付玉");
    }
}
