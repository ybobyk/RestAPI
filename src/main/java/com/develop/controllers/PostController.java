package com.develop.controllers;

import com.develop.models.Post;
import com.develop.models.response.ListPostResponse;
import com.develop.models.response.PostResponse;
import com.develop.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    public PostService postService;

    @PostMapping("/posts/add")
    @ResponseBody
    public PostResponse addPost(@RequestHeader("token") String token,
                                @RequestBody Post post) {
        return postService.addPost(token, post);
    }

    @GetMapping("/posts/get")
    @ResponseBody
    public ListPostResponse getPosts(@RequestHeader("token") String token) {
        return postService.getPosts(token);
    }
}
