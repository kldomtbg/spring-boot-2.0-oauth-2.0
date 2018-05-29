package com.ywsoftware.oa.authServer;

import com.ywsoftware.oa.authServer.service.LoginService;
import com.ywsoftware.oa.authServer.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.Mockito.*;

/**
 * Created by userFly on 2018/5/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
// 测试完毕后事物回滚
@Transactional
// 该注释可以控制事物不被回滚

@Rollback(false)
public class UserServiceTest {
    @Autowired
    UserService userService;

    private static Assert anAssert;

    @Test
    public void saveUser() {
        userService.saveUser("a", "付玉", "1", "1");
    }

    @Test
    public void deleteUser() {
        // userService.deleteUser("a");
        anAssert.assertTrue("", true);
    }

    @Test
    public void update() {
        userService.update("测试", "3");
    }

    @Test
    public void getUser() {
        userService.getUser("付玉");

    }

    @Test
    public void test() {
        String id = "1";
        // 使用 mock 模拟 LogingService 对象,
        LoginService loginService = mock(LoginService.class);
        // 设置方法返回值
        when(loginService.getUsr(id)).thenReturn("付玉");
        when(loginService.getAge(id)).thenReturn(1000);
        // 实际调用
        int ret = loginService.getAge("1");
        loginService.getUsr(id);

        // 比较两次的调用顺序
        InOrder inOrder = inOrder(loginService);
        inOrder.verify(loginService).getUsr(id);
        inOrder.verify(loginService).getAge(id);
        // 比较返回值和预期值是否一致
        anAssert.assertEquals(1000, ret);
        // verify 包含了模拟对象和期望的调用次数, 如果调用次数不一致, 会抛异常
        verify(loginService, times(2)).getAge(eq("1"));


    }
}
