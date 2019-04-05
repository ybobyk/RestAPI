package com.develop.services;

import com.develop.models.Post;
import com.develop.models.response.ListPostResponse;
import com.develop.models.response.PostResponse;

public interface PostService {
    PostResponse addPost(String token, Post post);
    ListPostResponse getPosts(String token);
}
