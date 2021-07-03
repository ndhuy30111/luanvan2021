package com.stu.luanvan.service.report;

import com.stu.luanvan.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ReportService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public Map<String, Object> getInvoice(){
        var invoice = new LinkedHashMap<String,Object>();
        invoice.put("not",invoiceRepository.findByStatus(InvoiceStatus.NOT_INVOICED).size());
        invoice.put("accuracy",invoiceRepository.findByStatus(InvoiceStatus.ACCURACY_INVOICED).size());
        invoice.put("transaction",invoiceRepository.findByStatus(InvoiceStatus.TRANSACTION_INVOICED).size());
        invoice.put("complete",invoiceRepository.findByStatus(InvoiceStatus.COMPLETE_INVOICED).size());
        invoice.put("cancel",invoiceRepository.findByStatus(InvoiceStatus.CANCEL_INVOICED).size());
        return invoice;
    }
}
