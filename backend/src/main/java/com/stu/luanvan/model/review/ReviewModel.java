package com.stu.luanvan.model.review;

import com.stu.luanvan.model.user.UserModel;
import com.stu.luanvan.model.key.UserProductKey;
import com.stu.luanvan.model.product.ProductModel;

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
    @JoinColumn()
    private UserModel user;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn()
    private ProductModel product;
}
