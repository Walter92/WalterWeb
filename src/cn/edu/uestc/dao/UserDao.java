package cn.edu.uestc.dao;

import java.util.List;

import cn.edu.uestc.entity.Users;

public interface UserDao {
	List<Users> query(String username);
	void addUser(Users user);
}
