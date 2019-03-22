package com.develop.DAO.impl;

import com.develop.DAO.UserDAO;
import com.develop.models.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public User save(User user) {
        sessionFactory.getCurrentSession().save(user);
        return user;
    }

    @Override
    public User getUser(String username) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("id", Long.valueOf(username)));
        Object result = criteria.uniqueResult();
        return (User) result;
    }
}
