package com.stu.luanvan.service.user;

import com.stu.luanvan.enums.SaveEnum;
import com.stu.luanvan.model.UserModel;
import com.stu.luanvan.request.UserRequest;
import com.stu.luanvan.service.ServiceIntefaces;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserServiceIntefaces extends ServiceIntefaces<UserModel, UserRequest> {
    UserModel findByUserName(String userName);
}
