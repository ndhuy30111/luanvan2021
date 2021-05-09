package com.myduyen.java.service;

import com.myduyen.java.entity.UserEntity;
import org.apache.catalina.User;

import java.util.List;

public interface UserServiceInterface {
    List<UserEntity> getall();
    UserEntity getOne(Long id);
    List<UserEntity> findByName(String name);
    UserEntity save(UserEntity userEntity);
    void delete (Long id);

}
