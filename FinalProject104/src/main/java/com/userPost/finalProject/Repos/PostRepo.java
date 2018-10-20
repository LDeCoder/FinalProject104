package com.userPost.finalProject.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userPost.finalProject.Models.Post;

public interface PostRepo extends JpaRepository<Post, Integer>{

}
