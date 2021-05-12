package com.stu.luanvan.repository;

import com.stu.luanvan.model.ColorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<ColorModel,Integer> {
}