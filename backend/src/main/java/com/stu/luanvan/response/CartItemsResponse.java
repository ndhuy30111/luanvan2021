package com.stu.luanvan.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemsResponse {
    private String name;
    private Integer price;
    private String url;
    private Integer quantity;
    private String color;
    private String size;
}
