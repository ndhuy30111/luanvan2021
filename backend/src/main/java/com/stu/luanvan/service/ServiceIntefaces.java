package com.stu.luanvan.service;


import com.stu.luanvan.enums.SaveEnum;
import com.stu.luanvan.model.UserModel;
import com.stu.luanvan.request.UserRequest;

import java.util.Collection;
import java.util.Map;

public interface ServiceIntefaces<M,R> {


    Map<String,Object> findByAll(int page, int sort, String nameSort);
    Collection<M> findByAll();
    M findById(Integer id);
    M saveNew(R r) throws Exception;
    M saveEdit(R r) throws Exception;
    void delete(R r) throws Exception;
}
