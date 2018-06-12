//package com.ywsoftware.oa.authserver;
//
//import com.ywsoftware.oa.authserver.core.services.TestMockService;
//import com.ywsoftware.oa.authserver.core.services.UserService;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;

//import static org.mockito.Mockito.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//// 测试完毕后事物回滚
//@Transactional
//// 该注释可以控制事物不被回滚
//@Rollback(false)
//public class UserServiceTest {
//    private static Assert anAssert;
//    @Autowired
//    UserService userService;
//
//    @Test
//    public void test() {
//        String id = "1";
//        // 使用 mock 模拟 LogingService 对象,
//        TestMockService testMockService = mock(TestMockService.class);
//        // 设置方法返回值
//        when(testMockService.getUsr(id)).thenReturn("付玉");
//        when(testMockService.getAge(id)).thenReturn(1000);
//        // 实际调用
//        int ret = testMockService.getAge("1");
//        testMockService.getUsr(id);
//
//        // 比较两次的调用顺序
//        InOrder inOrder = inOrder(testMockService);
//        inOrder.verify(testMockService).getUsr(id);
//        inOrder.verify(testMockService).getAge(id);
//        // 比较返回值和预期值是否一致
//        anAssert.assertEquals(1000, ret);
//        // verify 包含了模拟对象和期望的调用次数, 如果调用次数不一致, 会抛异常
//        verify(testMockService, times(2)).getAge(eq("1"));
//    }
//}
