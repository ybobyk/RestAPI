package com.develop.DAO;

import com.develop.models.Post;

import java.util.List;

public interface PostDAO {
    Post savePost(Post post);
    List<Post> getPosts();
}
