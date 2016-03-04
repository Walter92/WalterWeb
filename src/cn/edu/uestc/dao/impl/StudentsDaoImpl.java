package cn.edu.uestc.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.uestc.dao.StudentsDao;
import cn.edu.uestc.entity.Students;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Walter
 */
@Transactional
@Repository("studentsDaoImpl")
public class StudentsDaoImpl implements StudentsDao {

    //自动注入sessionFactory
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public StudentsDaoImpl() {
    }

    //添加一个学生
    @Override
    public boolean add(Students stu) {
        sessionFactory.getCurrentSession().save(stu);
        return true;
    }


    //删除一个学生
    @Override
    public boolean delete(Students stu) {
        sessionFactory
                .getCurrentSession()
                .delete(stu);
        return true;
    }

    //查询所有学生，不使用事务
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<Students> queryAll() {
        List<Students> list = null;
        String hql = "";
        hql = "from Students";
        Query query = sessionFactory
                .getCurrentSession().createQuery(hql);
        list = query.list();
        return list;
    }

    //更新一个学生信息
    @Override
    public boolean update(Students stu) {
        sessionFactory.getCurrentSession().update(stu);
        return true;
    }

    //获取当前最大学生编号，由service层调用来生成最新的学生学号
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public String getMaxSid() {
        String maxSid = null;
        String hql = "";
        //查询最大编号语句
        hql = "select max(sid) from Students";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        maxSid = (String) query.uniqueResult();
        return maxSid;
    }

    //根据学生ID查询一个学生，不使用事务
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Students query(String sid) {
        Students student = null;
//        String hql = "";
//        hql = "from Students where sid=?";
        student = (Students) sessionFactory
                .getCurrentSession().get(Students.class, sid);
        return student;
    }

    //根据条件查询学生，返匹配的学生列表
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<Students> findBycondition(Students students) {
        String hql = "";
        List<Students> list = null;
        String sid = students.getSid();
        String sname = students.getSname();
        //如果sid不为空，添加id查询条件
        if (sid != null && !sid.trim().equals("")) {
            hql = "from Students where sid='" + sid + "'";
        } else if (sname != null && !sname.trim().equals("")) {
            //如果姓名不为空，添加学生姓名模糊匹配查询
            hql = "from Students where sname like" + "'%" + sname + "%'";
        } else {
            hql = "from Students";
        }
        Query query = sessionFactory
                .getCurrentSession().createQuery(hql);
        list = query.list();
        return list;
    }

}
