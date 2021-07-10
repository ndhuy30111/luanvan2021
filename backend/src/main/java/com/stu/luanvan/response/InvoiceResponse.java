package com.stu.luanvan.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceResponse {
    private Integer id;
    private String address;
    private String numberPhone;
    private Integer status;
    private Date createDate;
    private String billCode;
    private String payment;
    private List<InvoiceDetailsResponse> invoiceDetails;
}