package com.v.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.v.bean.User;
import com.v.service.UserService;


public class MyTest {
    
    @Test
    public void testUser() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "spring-mybatis.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        User user = userService.getUserById(1);
        System.out.println(user);
    }
}
