package com.stu.luanvan.model.coupon;

import com.stu.luanvan.model.BaseModel;
import com.stu.luanvan.model.size.SizeModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "coupon")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CouponModel extends BaseModel {
    @ManyToOne
    @JoinTable(name="size_id")
    private SizeModel size;
    private Integer amount;
}