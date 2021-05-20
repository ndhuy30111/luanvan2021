package com.stu.luanvan.service;


import java.util.Collection;
import java.util.Map;

public interface ServiceIntefaces<M,R> {


    Map<String,Object> findByAll(int page, int size, String nameSort);
    Collection<M> findByAll();
    M findById(Integer id);
    M saveNew(R r) throws Exception;
    M saveEdit(R r,int id) throws Exception;
    void delete(int id) throws Exception;
}
