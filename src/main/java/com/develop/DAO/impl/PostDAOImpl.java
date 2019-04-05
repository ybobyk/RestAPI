package com.develop.DAO.impl;

import com.develop.DAO.PostDAO;
import com.develop.models.Post;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
@Transactional
public class PostDAOImpl implements PostDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Post savePost(Post post) {
        sessionFactory.getCurrentSession().save(post);
        return post;
    }

    @Override
    public List<Post> getPosts() {
        CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);
        criteriaQuery.from(Post.class);
        List<Post> postList = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
        return postList;
    }
}
