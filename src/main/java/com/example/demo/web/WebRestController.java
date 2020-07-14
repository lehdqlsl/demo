package com.example.demo.web;

import com.example.demo.domain.posts.PostsRepository;
import com.example.demo.dto.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


//@AllArgsConstructor
@RestController
public class WebRestController {

    @Autowired
    private PostsRepository postsRepository;

    @PostMapping("/posts")
    public ResponseEntity<?> savePosts(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save(dto.toEntity());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
