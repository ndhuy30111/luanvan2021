package com.stu.luanvan.repository;

import com.stu.luanvan.model.cart.CartItemsModel;
import com.stu.luanvan.model.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItemsModel, Integer> {
    List<CartItemsModel> findByUser(UserModel user);
//    List<CartItemsModel> findByUser(Integer id);
//    @Query(value ="SELECT p.id,p.name,p.price,f.url,ci.quantity,ci.color,ci.size FROM `cart_items` ci " +
//            "JOIN `product` p ON p.id = ci.product_id " +
//            "JOIN `details_product` dp ON dp.product_id = p.id " +
//            "JOIN `file` f ON f.id = dp.image_id " +
//            "JOIN `color` c ON dp.color_id = c.id " +
//            "WHERE  ci.user_id= :id AND ci.color=c.name",nativeQuery = true)
//    Collection<CartItemsResponse> findByUserAndColorName(@Param("id") Integer id);
}
