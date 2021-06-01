package com.stu.luanvan.model.size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.stu.luanvan.model.BaseModel;
import com.stu.luanvan.model.detailsproduct.DetailsProductModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="size")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SizeModel extends BaseModel {

    @Column(columnDefinition = "VARCHAR(3) NOT NULL COMMENT 'Tên kích thước'")
    @Pattern(regexp = "^[\\p{L} . '-]+$", message = "Tên không hợp lệ")
    private String name;

    @Column(columnDefinition = "int(5) default 0 COMMENT 'Số lượng sản phẩm'")
    @Min(value = 0,message = "số lượng không hợp lệ")
    private Integer amount;

    @ManyToOne
    @JoinColumn(name="color_id")
    @JsonBackReference
    private DetailsProductModel color;

    public SizeModel(String name, Integer amount) {
        this.name = name;
        this.amount = amount;
    }



    public void setAmount(Integer amount) throws Exception {
        this.amount -= amount;
        if(this.amount<0){
            throw new Exception("Lỗi số lượng");
        }
    }

}
