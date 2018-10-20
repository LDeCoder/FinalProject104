package com.userPost.finalProject.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.userPost.finalProject.Models.Post;
import com.userPost.finalProject.Repos.PostRepo;



@RestController
public class PostingController {

    @Autowired
    PostRepo dao;

    @GetMapping("/posts")
    public List<Post> getPostedMessages(){
        List<Post> foundPostedMessages = dao.findAll();
        return foundPostedMessages;
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Post> getMessage(@PathVariable(value="id") Integer id){
        Post foundPostedMessage = dao.getOne(id);

        if(foundPostedMessage == null) {
            return ResponseEntity.notFound().header("Post","No post found with that ID").build();
        }
        return ResponseEntity.ok(foundPostedMessage);
    }

    @PostMapping("/post")
    public ResponseEntity<Post> postMessage(@RequestBody Post post){

        // saving to DB using instance of the repo interface
       Post createdPost = dao.save(post);

        // RespEntity crafts response to include correct status codes.
        return ResponseEntity.ok(createdPost);
    }

    @DeleteMapping("/deletePost/{id}")
    public ResponseEntity<Post> deleteMessage(@PathVariable(value="id") Integer id){
        Post foundPostedMessage = dao.getOne(id);

        if(foundPostedMessage == null) {
            return ResponseEntity.notFound().header("Post","No post found with that ID").build();
        }else {
            dao.delete(foundPostedMessage);
        }
        return ResponseEntity.ok().build();
    }
}