package com.stu.luanvan.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="color")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ColorModel extends BaseModel{

    @Column(columnDefinition = "VARCHAR(15) NOT NULL COMMENT 'Tên màu'")
    private String name;

    @Column(columnDefinition = "VARCHAR(100) NULL COMMENT 'Đường dẫn hình '")
    private String image;

    @ManyToOne
    @JoinColumn(name="product_id")
    private ProductModel product;

    @OneToMany(mappedBy = "color")
    private Collection<SizeModel> size;
}
