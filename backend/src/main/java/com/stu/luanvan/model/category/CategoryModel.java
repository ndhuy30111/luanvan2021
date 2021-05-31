package com.stu.luanvan.model.category;

import com.fasterxml.jackson.annotation.*;
import com.github.slugify.Slugify;
import com.stu.luanvan.model.BaseModel;
import com.stu.luanvan.model.json.Views;
import com.stu.luanvan.model.product.ProductModel;
import com.stu.luanvan.request.CategoryRequest;
import lombok.*;
import org.apache.commons.lang3.StringUtils;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "category")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryModel extends BaseModel {
    @Column(columnDefinition = "VARCHAR(40) NOT NULL COMMENT 'Tên danh mục' ")
    @JsonView({Views.Public.class,CategoryViews.Select.class})
    @Pattern(regexp = "^[\\p{L} . '-]+$", message = "Tên không hợp lệ")
    private String name;

    @JsonManagedReference
    @JsonView({Views.Public.class,CategoryViews.Select.class})
    private Integer sort;

    @OneToMany
    @JoinColumn(name = "category_id",columnDefinition = "INT(11) NULL COMMENT 'Danh mục cha'")
    @JsonView({Views.Public.class,CategoryViews.Select.class})
    @JsonManagedReference

    private Collection<CategoryModel> children;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonView(Views.Public.class)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "name")
    @JsonIdentityReference(alwaysAsId = true)
    private CategoryModel category;


    @JsonView({Views.Public.class,CategoryViews.Select.class})
    private String url;

    @OneToMany(mappedBy = "category")
    @JsonView({Views.Public.class})
    @JsonManagedReference
    private Collection<ProductModel> product;


    public void setName(String name) {
        this.name = name.trim();
        this.url = new Slugify().slugify(this.name);
    }

    public CategoryModel(CategoryRequest cr, CategoryModel category) {
        setName(cr.getName()) ;
        this.sort = cr.getSort();
        this.category = category;
    }

    public void edit (CategoryRequest cr){
        if(!StringUtils.isEmpty(cr.getName())){
            setName(cr.getName());
        }
        if(cr.getSort()!=null){
            this.sort = cr.getSort();
        }

    }
    public Collection<CategoryModel> categoryChildren(){
        Collection<CategoryModel> childeren = new ArrayList<>();
        return childeren;
    }
}
