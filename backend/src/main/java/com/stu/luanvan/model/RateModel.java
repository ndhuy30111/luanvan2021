package com.stu.luanvan.model;

import com.stu.luanvan.model.key.UserProductKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="rate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RateModel {
    @EmbeddedId
    private UserProductKey userProductKey;

    @Column(columnDefinition = "tinyint(1) NOT NULL COMMENT 'Điểm đánh giá sản phẩm'")
    private Integer rate;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name="user_id")
    private UserModel user;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name="product_id")
    private ProductModel product;

}
