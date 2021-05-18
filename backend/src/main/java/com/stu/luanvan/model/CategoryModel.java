package com.stu.luanvan.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.stu.luanvan.model.json.Views;
import com.stu.luanvan.request.CategoryRequest;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "category")
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryModel extends BaseModel{
    @Column(columnDefinition = "VARCHAR(40) NOT NULL COMMENT 'Tên danh mục' ")
    @JsonView(Views.Public.class)
    private String name;
    @JsonManagedReference
    @JsonView(Views.Public.class)
    private Integer sort;

    @ManyToOne
    @JoinColumn(name = "category_id",columnDefinition = "INT(11) NULL COMMENT 'Danh mục cha'")
    @JsonView(Views.Public.class)
    private CategoryModel category;

    @JsonView(Views.Public.class)
    private String url;

    @OneToMany(mappedBy = "category")
    @JsonView(Views.Public.class)
    @JsonManagedReference
    private Collection<ProductModel> product;

    public CategoryModel(CategoryRequest cr,CategoryModel category) {
        this.name = cr.getName();
        this.sort = cr.getSort();
        this.category = category;
    }

    public void edit (CategoryRequest cr,CategoryModel category){
        this.name = cr.getName();
        this.sort = cr.getSort();
        this.category = category;
    }
}
