package com.stu.luanvan.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "category")
@Data
@Setter
@Getter
public class CategoryModel extends BaseModel{
    @Column(columnDefinition = "VARCHAR(40) NOT NULL COMMENT 'Tên danh mục' ")
    private String name;
    private Integer sort;
    @ManyToOne
    @JoinColumn(name = "category_id",columnDefinition = "INT(11) NULL COMMENT 'Danh mục cha'")
    private CategoryModel category;

    @OneToMany(mappedBy = "category")
    private Collection<ProductModel> product;
}
