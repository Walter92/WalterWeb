package cn.edu.uestc.service.impl;

import java.util.List;

import cn.edu.uestc.dao.UserDao;
import cn.edu.uestc.entity.Users;
import org.springframework.stereotype.Service;
import cn.edu.uestc.service.UserService;

import javax.annotation.Resource;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Resource(name = "userDaoImpl")
    public void setUdao(UserDao udao) {
        this.userDao = udao;
    }


    public UserServiceImpl() {

    }

    @Override
    public boolean login(Users user) {
        List<Users> list = userDao.query(user.getUsername());
        if (list != null && list.size() != 0)
            return true;
        return false;
    }

    @Override
    public void logout() {

    }

}
