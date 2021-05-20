package com.stu.luanvan.model.color;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.stu.luanvan.model.BaseModel;
import com.stu.luanvan.model.file.FileModel;
import com.stu.luanvan.model.size.SizeModel;
import com.stu.luanvan.model.product.ProductModel;
import com.stu.luanvan.request.ColorRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Collection;

@Entity
@Table(name="color")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "name")
public class ColorModel extends BaseModel {

    @Column(columnDefinition = "VARCHAR(15) NOT NULL COMMENT 'Tên màu'")
    @Pattern(regexp = "^[\\p{L} . '-]+$", message = "Tên không hợp lệ")
    private String name;


    @OneToOne
    @JoinColumn
    private FileModel image;

    @ManyToOne
    @JoinColumn(name="product_id")
    private ProductModel product;

    @OneToMany(mappedBy = "color")
    private Collection<SizeModel> size;


    public ColorModel(String name, FileModel image, ProductModel product) {
        this.name = name;
        this.image = image;
        this.product = product;
    }
}
