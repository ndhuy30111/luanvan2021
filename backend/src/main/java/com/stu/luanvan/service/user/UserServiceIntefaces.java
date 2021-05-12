package com.stu.luanvan.service.user;

import com.stu.luanvan.enums.SaveEnum;
import com.stu.luanvan.model.UserModel;
import com.stu.luanvan.request.UserRequest;
import com.stu.luanvan.service.ServiceIntefaces;

public interface UserServiceIntefaces extends ServiceIntefaces<UserModel, UserRequest> {
    /*
    *  @param
    *  @return User
    *
    */
    UserModel save(UserRequest userRequest, SaveEnum userEnum);
}
