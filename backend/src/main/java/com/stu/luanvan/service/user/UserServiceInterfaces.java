package com.stu.luanvan.service.user;

import com.stu.luanvan.model.user.UserModel;
import com.stu.luanvan.request.UserRequest;
import com.stu.luanvan.service.ServiceInterfaces;

public interface UserServiceInterfaces extends ServiceInterfaces<UserModel, UserRequest> {
    UserModel findByUserName(String userName);
}
