package com.stu.luanvan.controller.user.invoice;

import com.stu.luanvan.request.InvoiceRequest;
import com.stu.luanvan.service.invoice.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin //Cho truy cập vào API từ các Trang web khác, Bảo Mật CRSF
@RequestMapping("/api")
@EnableTransactionManagement
public class InvoicesController {
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/invoice")
    public ResponseEntity<?> postSave(@Valid @RequestBody InvoiceRequest invoiceRequest) throws Exception {
        var invoice  =  invoiceService.saveNew(invoiceRequest);
        return new ResponseEntity<>(invoice, HttpStatus.CREATED);
    }
}