package com.stu.luanvan.request;

import com.stu.luanvan.locales.MessageLocales;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceRequest {
    private String numberPhone;
    private String address;
    private String note;
    private String payment;
    private Collection<InvoiceDetailsRequest> invoiceDetailsRequests;
}
