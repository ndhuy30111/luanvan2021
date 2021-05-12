package com.stu.luanvan.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name="size")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SizeModel extends BaseModel{

    @Column(columnDefinition = "VARCHAR(3) NOT NULL COMMENT 'Tên kích thước'")
    private String name;

    @Column(columnDefinition = "int(5) default 0 COMMENT 'Số lượng sản phẩm'")
    @Min(value = 0,message = "số lượng không hợp lệ")
    private Integer amount;

    @ManyToOne
    @JoinColumn(name="color_id")
    private ColorModel color;

    public void setAmount(Integer amount) throws Exception {
        this.amount -= amount;
        if(this.amount<0){
            throw new Exception("Lỗi số lượng");
        }
    }
}
