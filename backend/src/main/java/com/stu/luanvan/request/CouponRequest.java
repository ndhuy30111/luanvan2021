package com.stu.luanvan.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponRequest {
    private Integer id;
    private Integer amount;
    private String message;
}
