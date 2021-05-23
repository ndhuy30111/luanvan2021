package com.stu.luanvan.model.category;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.github.slugify.Slugify;
import com.stu.luanvan.model.BaseModel;
import com.stu.luanvan.model.json.Views;
import com.stu.luanvan.model.product.ProductModel;
import com.stu.luanvan.request.CategoryRequest;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Collection;

@Entity
@Table(name = "category")
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryModel extends BaseModel {
    @Column(columnDefinition = "VARCHAR(40) NOT NULL COMMENT 'Tên danh mục' ")
    @JsonView(Views.Public.class)
    @Pattern(regexp = "^[\\p{L} . '-]+$", message = "Tên không hợp lệ")
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

    public void setName(String name) {
        this.name = name.trim();
        this.url = new Slugify().slugify(this.name);
    }

    public CategoryModel(CategoryRequest cr, CategoryModel category) {
        this.name = cr.getName();
        this.sort = cr.getSort();
        this.category = category;
    }

    public void edit (CategoryRequest cr){
        if(StringUtils.isEmpty(category.getName())){
            setName(category.getName());
        }
        this.sort = cr.getSort();
    }
}
