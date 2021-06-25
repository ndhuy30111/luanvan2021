package com.stu.luanvan.service.invoice;

import com.stu.luanvan.model.invoice.InvoiceModel;
import com.stu.luanvan.request.InvoiceRequest;
import com.stu.luanvan.service.ServiceInterfaces;

import java.util.Collection;

public interface InvoiceServiceInterface extends ServiceInterfaces<InvoiceModel, InvoiceRequest> {
    Collection<InvoiceModel> findAllNotReceive();
    Collection<InvoiceModel> findAllReceive();
    Collection<InvoiceModel> findAllCancelReceive();
}
