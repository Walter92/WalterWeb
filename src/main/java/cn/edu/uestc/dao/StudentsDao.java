package cn.edu.uestc.dao;

import java.util.List;

import cn.edu.uestc.entity.Students;

public interface StudentsDao {
    List<Students> queryAll();

    List<Students> findBycondition(Students students);

    Students query(String sid);

    boolean add(Students stu);

    boolean update(Students stu);

    boolean delete(Students stu);

    String getMaxSid();
    public List<Students> queryDetailAll();
}
