package com.stu.luanvan.model.coupon;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.stu.luanvan.model.BaseModel;
import com.stu.luanvan.model.size.SizeModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "coupon")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CouponModel extends BaseModel {
    @ManyToOne
    @JoinColumn(name="size_id")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,property="id")
    @JsonIdentityReference(alwaysAsId = true)
    private SizeModel size;
    private Integer amount;


}
