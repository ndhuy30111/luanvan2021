package com.stu.luanvan.repository;

import com.stu.luanvan.model.SizeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Size extends JpaRepository<SizeModel,Integer> {
}
