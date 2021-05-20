package com.stu.luanvan.repository;

import com.stu.luanvan.model.review.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewModel,Integer> {
}
