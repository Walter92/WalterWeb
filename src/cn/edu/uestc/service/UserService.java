package cn.edu.uestc.service;

import cn.edu.uestc.entity.Users;

public interface UserService {
    boolean login(Users user);

    void logout();

}
