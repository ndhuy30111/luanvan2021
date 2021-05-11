package com.stu.luanvan.repository;

import com.stu.luanvan.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel,Integer> {
    UserModel findByUserName(String username);
}
