package com.develop.models.response;

import com.develop.models.Post;

public class PostResponse {

    private String message;
    private Post post;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Post getPost() {
        return post;
    }
}
