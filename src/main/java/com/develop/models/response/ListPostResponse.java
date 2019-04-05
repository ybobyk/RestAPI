package com.develop.models.response;

import com.develop.models.Post;

import java.util.List;

public class ListPostResponse {

    private String message;
    private List<Post> postList;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public String getMessage() {
        return message;
    }

    public List<Post> getPostList() {
        return postList;
    }
}
