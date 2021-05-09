package com.myduyen.java.controller;

import com.myduyen.java.entity.UserEntity;
import com.myduyen.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity getAll(@RequestParam(name="name",required = false) String name){
        if(name !=null){
            return new ResponseEntity(userService.findByName(name),HttpStatus.OK);
        }
        return new ResponseEntity(userService.getall(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return new ResponseEntity(userService.getOne(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody UserEntity userEntity){
        return new ResponseEntity(userService.save(userEntity),HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity edit(@RequestBody UserEntity userEntity){
        return new ResponseEntity(userService.save(userEntity),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        userService.delete(id);
        return  new ResponseEntity(HttpStatus.OK);
    }


 }
