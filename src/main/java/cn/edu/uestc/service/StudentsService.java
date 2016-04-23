package cn.edu.uestc.service;

import java.util.List;

import cn.edu.uestc.entity.Students;

public interface StudentsService {
    List<Students> queryAll();

    List<Students> findByCondtion(Students student);

    Students queryById(String sid);

    boolean delete(Students stu);

    boolean add(Students stu);

    boolean update(Students stu);

    public List<Students> queryDetailedAll();


}
