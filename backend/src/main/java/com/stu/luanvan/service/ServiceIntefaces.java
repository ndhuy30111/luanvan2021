package com.stu.luanvan.service;


import java.util.Collection;
import java.util.Map;

public interface ServiceIntefaces<M,R> {


    Map<String,Object> findByAll(int page, int sort, String nameSort);
    Collection<M> findByAll();
    M findById(Integer id);
    M saveNew(R r);
    M saveEdit(R r);
    void delete(R r);
}
