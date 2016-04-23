package cn.edu.uestc.service.impl;

import cn.edu.uestc.dao.TeacherDao;
import cn.edu.uestc.entity.Teacher;
import cn.edu.uestc.service.TeachersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("teachersServiceImpl")
public class TeachersServiceImpl implements TeachersService {

    @Resource(name = "teacherDaoImpl")
    TeacherDao teacherDao;


    @Override
    public List<Teacher> queryAll() {
        List<Teacher> list = teacherDao.queryAll();
        return list;
    }

    @Override
    public List<Teacher> findByCondtion(Teacher teacher) {
        List<Teacher> list = teacherDao.findByCondition(teacher);
        return list;
    }

    @Override
    public Teacher queryById(String tid) {
        Integer itid = Integer.parseInt(tid);
        Teacher teacher = teacherDao.query(itid);

        return teacher;
    }

    @Override
    public boolean delete(Teacher teacher) {
        // Integer tid = teacher.getTid();
        teacherDao.delete(teacher);
        return true;
    }

    @Override
    public boolean add(Teacher teacher) {
        teacherDao.add(teacher);
        return true;
    }

    @Override
    public boolean update(Teacher teacher) {
        teacherDao.update(teacher);
        return true;
    }
}
