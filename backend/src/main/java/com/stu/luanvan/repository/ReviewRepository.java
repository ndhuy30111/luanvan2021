package com.stu.luanvan.repository;

import com.stu.luanvan.model.product.ProductModel;
import com.stu.luanvan.model.review.ReviewModel;
import com.stu.luanvan.model.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewModel,Integer> {
    Collection<ReviewModel> findByStatusFalse();
    Collection<ReviewModel> findByStatusTrueAndProduct(ProductModel product);
    ReviewModel findByProductAndUser(ProductModel product, UserModel user);
    Collection<ReviewModel> findByProduct(ProductModel product);
}
