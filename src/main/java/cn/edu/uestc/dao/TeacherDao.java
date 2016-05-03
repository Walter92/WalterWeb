package cn.edu.uestc.dao;

import cn.edu.uestc.entity.Teacher;

import java.util.List;

/**
 * Created by walter on 16-3-3.
 */
public interface TeacherDao {
    List<Teacher> queryAll();

    List<Teacher> findByCondition(Teacher teacher);

    Teacher query(Integer tid);

    boolean add(Teacher teacher);

    boolean update(Teacher teacher);

    boolean delete(Teacher teacher);
    // String getMaxSid();
}
