package com.userservice.controller;

import com.userservice.persistence.jpa.entity.UserEntity;
import com.userservice.persistence.jpa.repository.UserRepository;
import com.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository repository;

    @PostMapping
    public ResponseEntity<UserEntity> save(@RequestBody UserEntity user){
        return ResponseEntity.ok(userService.save(user));
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(repository.findById(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUser(){
        return ResponseEntity.ok(repository.findAll());
    }
}
