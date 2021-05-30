package com.stu.luanvan.model.color;

import com.fasterxml.jackson.annotation.JsonView;
import com.stu.luanvan.model.category.CategoryViews;
import com.stu.luanvan.model.json.Views;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="color")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ColorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView({Views.Internal.class, CategoryViews.Select.class})
    private Integer id;
    @Column(columnDefinition = "VARCHAR(15) NOT NULL COMMENT 'Tên màu'")
    @Pattern(regexp = "^[\\p{L} . '-]+$", message = "Tên không hợp lệ")
    private String name;

    @Column(columnDefinition = "VARCHAR(10) NULL COMMENT 'Mã Màu'")
    private String code;

    public  ColorModel(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
