package com.stu.luanvan.service;

import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.Map;

public interface BaseIntefaces<M,R> {
    Map<String,Object> findByAll(int page, int sort, String nameSort);
    Collection<M> findByAll();
    M findById(Integer id);
    M save(R r);
    void delete(R r);
}
