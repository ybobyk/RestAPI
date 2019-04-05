package com.develop.services.impl;

import com.develop.DAO.PostDAO;
import com.develop.DAO.UserDAO;
import com.develop.models.Post;
import com.develop.models.User;
import com.develop.models.response.ListPostResponse;
import com.develop.models.response.PostResponse;
import com.develop.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    public PostDAO postDAO;

    @Autowired
    public UserDAO userDAO;

    @Override
    public PostResponse addPost(String token, Post post) {
        PostResponse postResponse = new PostResponse();

        User user = getUserByToken(token);
        if (user != null) {
            post.setUserId(user.getId());
            postDAO.savePost(post);
            postResponse.setMessage("Post has been created successful");
            postResponse.setPost(post);
        } else {
            postResponse.setMessage("Invalid token");
        }

        return postResponse;
    }

    @Override
    public ListPostResponse getPosts(String token) {
        ListPostResponse listPostResponse = new ListPostResponse();

        User user = getUserByToken(token);
        if (user != null) {
            List<Post> allPosts = postDAO.getPosts();
            listPostResponse.setMessage("Successful");
            listPostResponse.setPostList(allPosts);
        } else {
            listPostResponse.setMessage("Invalid token");
        }

        return listPostResponse;
    }

    private User getUserByToken(String token) {
        return userDAO.getUserByToken(token);
    }
}
