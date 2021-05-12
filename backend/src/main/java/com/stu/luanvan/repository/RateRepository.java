package com.stu.luanvan.repository;

import com.stu.luanvan.model.RateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<RateModel,Integer> {
}
