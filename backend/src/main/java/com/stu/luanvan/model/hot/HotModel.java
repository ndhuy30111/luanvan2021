package com.stu.luanvan.model.hot;

import com.stu.luanvan.model.product.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="hot")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String date;
    @ManyToOne
    private ProductModel product;
    private Integer amount;
}
