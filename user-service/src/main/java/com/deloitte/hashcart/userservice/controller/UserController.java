package com.deloitte.hashcart.userservice.controller;

import com.deloitte.hashcart.userservice.exception.UserNotFoundException;
import com.deloitte.hashcart.userservice.model.User;
import com.deloitte.hashcart.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping("/addUser")
    public ResponseEntity<User> addNewUser(@RequestBody User user) throws UserNotFoundException {
      log.info("adding new  user "+user.getUsername());
        User user1 = service.saveUser(user);
        return new ResponseEntity<User>(user1,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) throws UserNotFoundException {
        log.info("Inside Get User by Id() ");
        User u=service.getUserById(id);
        return new ResponseEntity<>(u,HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<User>> getAllUser(){
        log.info("Inside Get All User Information ");
        List<User> list=service.getAllUser();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable("id") Integer id) throws UserNotFoundException {
        log.info("Inside Delete User by Id() ");
        User u=service.deleteUserById(id);
        return new ResponseEntity<>(u,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable("id") Integer id,@RequestBody User user) throws UserNotFoundException {
        log.info("Inside Delete User by Id() ");
        User u=service.updateUserById(id,user);
        return new ResponseEntity<>(u,HttpStatus.OK);
    }
}
