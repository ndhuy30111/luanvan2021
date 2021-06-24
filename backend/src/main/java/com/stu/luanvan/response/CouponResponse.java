package com.stu.luanvan.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stu.luanvan.locales.FormatLocales;
import com.stu.luanvan.model.coupon.CouponModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CouponResponse {
    private Integer id;
    private String name;
    private Integer amount;
    private String createBy;
    private  String lastModifiedBy;
    @JsonFormat(pattern= FormatLocales.DATE_FORMAT)
    private Date createDate;
    @JsonFormat(pattern= FormatLocales.DATE_FORMAT)
    private Date lastModifiedDate;

    public CouponResponse(CouponModel couponModel){
       this.id = couponModel.getId();
       this.name = couponModel.getSize().getDetailsProductModel().getProduct().getName()+" "+ couponModel.getSize().getDetailsProductModel().getColor().getName() +" "+ couponModel.getSize().getName();
       this.amount = couponModel.getAmount();
       this.createBy = couponModel.getCreateBy().getEmail();
       this.createDate = couponModel.getCreateDate();
       this.lastModifiedBy = couponModel.getLastModifiedBy().getEmail();
       this.lastModifiedDate = couponModel.getLastModifiedDate();
    }
}
