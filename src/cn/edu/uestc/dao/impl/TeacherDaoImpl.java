package cn.edu.uestc.dao.impl;

import cn.edu.uestc.dao.TeacherDao;
import cn.edu.uestc.entity.Teacher;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by walter on 16-3-3.
 */
@Transactional
@Repository("teacherDaoImpl")
public class TeacherDaoImpl implements TeacherDao {

    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Teacher> queryAll() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Teacher";
        Query query = session.createQuery(hql);
        List<Teacher> teacherArrayList = query.list();
        return teacherArrayList;
    }

    @Override
    public List<Teacher> findByCondition(Teacher teacher) {

        List<Teacher> list;
        Integer tid = teacher.getTid();
        String name = teacher.getName();

        StringBuffer hql = new StringBuffer("from Teacher where 1=1 ");

        if (tid != null) {
            hql.append(" and tid=" + tid);
        }


        if (name != null) {
            hql.append(" and name like '%" + name + "%'");
        }


        Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
//        query.setParameter(0,tid);
//      query.setParameter(1,name);

        list = query.list();

        return list;
    }

    @Override
    public Teacher query(Integer tid) {
        Teacher teacher;
        String hql = "from Teacher where tid=?";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0, tid);
        teacher = (Teacher) query.uniqueResult();
        return teacher;
    }

    @Override
    public boolean add(Teacher teacher) {
        try {
            sessionFactory.getCurrentSession().save(teacher);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Teacher teacher) {
        sessionFactory.getCurrentSession().update(teacher);
        return true;
    }

    @Override
    public boolean delete(Teacher teacher) {
        //String hql = "delete from Teacher where tid=?";
        sessionFactory.getCurrentSession().delete(teacher);
        // query.setParameter(0,tid);

        return true;
    }
}
