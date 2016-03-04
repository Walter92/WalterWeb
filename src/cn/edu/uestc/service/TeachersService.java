package cn.edu.uestc.service;

import cn.edu.uestc.entity.Teacher;

import java.util.List;

public interface TeachersService {
    List<Teacher> queryAll();

    List<Teacher> findByCondtion(Teacher teacher);

    Teacher queryById(String tid);

    boolean delete(Teacher teacher);

    boolean add(Teacher teacher);

    boolean update(Teacher teacher);

}
