package com.stu.luanvan.service.user;

import com.stu.luanvan.enums.SaveEnum;
import com.stu.luanvan.model.UserModel;
import com.stu.luanvan.request.UserRequest;
import com.stu.luanvan.service.BaseIntefaces;

public interface UserServiceIntefaces extends BaseIntefaces<UserModel, UserRequest> {
    public UserModel save(UserRequest userRequest, SaveEnum userEnum);
}
