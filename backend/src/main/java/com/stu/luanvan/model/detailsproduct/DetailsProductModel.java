package com.stu.luanvan.model.detailsproduct;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.stu.luanvan.model.BaseModel;
import com.stu.luanvan.model.color.ColorModel;
import com.stu.luanvan.model.file.FileModel;
import com.stu.luanvan.model.size.SizeModel;
import com.stu.luanvan.model.product.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Collection;

@Entity
@Table(name="details_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "name")
public class DetailsProductModel extends BaseModel {

    @OneToOne
    @JoinColumn
    private FileModel image;

    @ManyToOne
    @JoinColumn(name="color_id")
    private ColorModel color;
    @ManyToOne
    @JoinColumn(name="product_id")
    private ProductModel product;

    @OneToMany(mappedBy = "color")
    private Collection<SizeModel> size;


    public DetailsProductModel(ColorModel color, FileModel image, ProductModel product) {
        this.color = color;
        this.image = image;
        this.product = product;
    }
}
