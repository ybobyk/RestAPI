package com.develop.DAO.impl;

import com.develop.DAO.ValidTokenDAO;
import com.develop.models.ValidToken;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ValidTokenDAOImpl implements ValidTokenDAO {

    @Autowired
    public SessionFactory sessionFactory;

    @Override
    @Transactional
    public ValidToken saveValidToken(ValidToken token) {
        sessionFactory.getCurrentSession().save(token);
        return token;
    }

    @Override
    public ValidToken getValidToken(String token) {
        Criteria criteria = sessionFactory.getCurrentSession()
                .createCriteria(ValidToken.class)
                .add(Restrictions.eq("token", token));
        ValidToken validToken = (ValidToken) criteria.uniqueResult();
        return validToken;
    }
}
