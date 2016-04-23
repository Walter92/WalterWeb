package cn.edu.uestc.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.uestc.dao.UserDao;
import cn.edu.uestc.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;


    public UserDaoImpl() {
    }

    @Override
    public void addUser(Users user) {

    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<Users> query(String username) {
        String hql = "";
        List<Users> list = null;

        hql = "from Users where username=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0, username);
        list = query.list();

        return list;
    }
}
