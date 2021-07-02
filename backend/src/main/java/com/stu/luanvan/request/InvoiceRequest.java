package com.stu.luanvan.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceRequest {
    private String customerName;
    private String numberPhone;
    private String address;
    private String billCode;
    private String note;
    private Collection<InvoiceDetailsRequest> invoiceDetailsRequests;
}
