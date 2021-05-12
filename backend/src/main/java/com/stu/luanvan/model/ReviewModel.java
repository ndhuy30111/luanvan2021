package com.stu.luanvan.model;

import com.stu.luanvan.model.key.UserProductKey;

import javax.persistence.*;
@Entity
@Table(name="review")

public class ReviewModel {
    @EmbeddedId
    private UserProductKey userProductKey;
    @Column(columnDefinition = "tinyint(1) NOT NULL COMMENT 'Điểm đánh giá sản phẩm'")
    private Integer rate;
    @Column(columnDefinition = "TEXT NULL COMMENT 'Bình luận đánh giá sản phẩm của khách hàng'")
    private String comment;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name="user_id")
    private UserModel user;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name="product_id")
    private ProductModel product;
}
