package cn.edu.uestc.user;

import java.util.List;

import cn.edu.uestc.service.UserService;
import org.junit.Test;


import cn.edu.uestc.dao.UserDao;
import cn.edu.uestc.dao.impl.UserDaoImpl;
import cn.edu.uestc.entity.Users;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    UserService service;

    {
        ApplicationContext act = new ClassPathXmlApplicationContext("spring-config.xml");
        service = (UserService) act.getBean("userServiceImpl");

//        Math.pow()
    }

    @Test
    public void usersTest() {
        String name = "walter";
        UserDao userdao = new UserDaoImpl();
        List<Users> users = userdao.query(name);
        System.out.println(users);
    }

    @Test
    public void testUserServiceLogin() {
        System.out.println(service.login(new Users(1, "walter", "123456")));

    }
}
