package com.stu.luanvan.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartResponse {
    private Integer id;
    private String name;
    private Long price;
    private String image;
    private Integer quantity;
    private String color;
    private String size;

}
