package com.stu.luanvan.model.category;

import com.fasterxml.jackson.annotation.*;
import com.github.slugify.Slugify;
import com.stu.luanvan.locales.MessageLocales;
import com.stu.luanvan.model.BaseModel;
import com.stu.luanvan.model.BaseViews;
import com.stu.luanvan.model.product.ProductModel;
import com.stu.luanvan.locales.PatternLocales;
import com.stu.luanvan.request.CategoryRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    @JsonView({BaseViews.Public.class,CategoryViews.Select.class})
    @Pattern(regexp = PatternLocales.NAME_PATTERN, message = MessageLocales.NAME_PATTERN)
    private String name;

    @JsonManagedReference
    @JsonView({BaseViews.Public.class,CategoryViews.Select.class})
    private Integer sort;

    @OneToMany
    @JoinColumn(name = "category_id",columnDefinition = "INT(11) NULL COMMENT 'Danh mục cha'")
    @JsonView({BaseViews.Public.class,CategoryViews.Select.class})
    @JsonManagedReference
    private Collection<CategoryModel> children;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonView(BaseViews.Public.class)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "name")
    @JsonIdentityReference(alwaysAsId = true)
    private CategoryModel category;


    @JsonView({BaseViews.Public.class,CategoryViews.Select.class})
    private String url;

    @ManyToMany
    @JoinTable(name="category_product",joinColumns = @JoinColumn(name="category_id"),inverseJoinColumns = @JoinColumn(name="product_id"))
    @JsonView({BaseViews.Public.class})
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
