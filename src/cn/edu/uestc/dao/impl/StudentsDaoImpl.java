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

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public StudentsDaoImpl(){}

    @Override
    public boolean add(Students stu) {
        sessionFactory.getCurrentSession().save(stu);
        return true;
    }


    @Override
    public boolean delete(Students stu) {
        sessionFactory
                .getCurrentSession()
                .delete(stu);
        return true;
    }

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

    @Override
    public boolean update(Students stu) {
        sessionFactory.getCurrentSession().update(stu);
        return true;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public String getMaxSid() {
        String maxSid = null;
        String hql = "";
        hql = "select max(sid) from Students";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        maxSid = (String) query.uniqueResult();
        return maxSid;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Students query(String sid) {
        Students student = null;
        String hql = "";
        hql = "from Students where sid=?";
        student = (Students) sessionFactory
                .getCurrentSession().get(Students.class, sid);
        return student;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<Students> findBycondition(Students students) {
        String hql = "";
        List<Students> list = null;
        String sid = students.getSid();
        String sname = students.getSname();
        if (sid != null && !sid.trim().equals("")) {
            hql = "from Students where sid='" + sid + "'";
        } else if (sname != null && !sname.trim().equals("")) {
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
