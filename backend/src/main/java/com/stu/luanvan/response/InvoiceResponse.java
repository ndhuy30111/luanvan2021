package com.stu.luanvan.response;

import com.stu.luanvan.model.file.FileModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceResponse {
    private Integer productId;
    private String name;
    private Long price;
    private Integer amount;
    private String address;
    private String numberPhone;
    private Integer status;
    private Date createDate;
    private String billCode;
    private String image;
}
