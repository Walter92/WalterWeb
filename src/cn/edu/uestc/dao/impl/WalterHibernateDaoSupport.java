package cn.edu.uestc.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.sql.SQLException;
import java.util.*;

/**
 * Created by walter on 15-12-25.
 */
public class WalterHibernateDaoSupport extends HibernateDaoSupport {
    public List findByPage(final String sql, final int offset, final int pageSize){
        List list=getHibernateTemplate().execute(new HibernateCallback<List>() {
            @Override
            public List doInHibernate(Session session) throws HibernateException, SQLException {
                List result  = session.createQuery(sql).setFirstResult(offset).setMaxResults(pageSize).list();
                return result;

            }
        });
        return list;
    }

    public List findByPage(final String sql,final Object[] values, final int offset, final int pageSize){
        List list=getHibernateTemplate().execute(new HibernateCallback<List>() {
            @Override
            public List doInHibernate(Session session) throws HibernateException, SQLException {
                Query query  = session.createQuery(sql);

                for(int i=0;i<values.length;i++){
                    query.setParameter(i,values[i]);
                }

                List result = query.setFirstResult(offset).setMaxResults(pageSize).list();
                return result;
            }
        });
        return list;
    }
}
