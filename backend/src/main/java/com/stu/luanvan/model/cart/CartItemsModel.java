package com.stu.luanvan.model.cart;

import com.stu.luanvan.model.key.UserProductKey;
import com.stu.luanvan.model.product.ProductModel;
import com.stu.luanvan.model.user.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name ="cart_items")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn()
    private UserModel user;
    @ManyToOne
    @JoinColumn()
    private ProductModel product;

    private int quantity;

    private String color;

    private String size;
}
