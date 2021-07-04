package com.stu.luanvan.controller.admin.report;

import com.stu.luanvan.controller.URlController;
import com.stu.luanvan.request.report.DateRequest;
import com.stu.luanvan.service.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(URlController.REPORT_ADMIN)
public class ReponrtController {
    @Autowired
    ReportService reportService;
    @GetMapping("/invoice")
    public ResponseEntity<?> getReportInvoice(){

        return new ResponseEntity<>(reportService.getInvoice(),HttpStatus.OK);
    }
    @GetMapping("/invoice/date")
    public ResponseEntity<?> getReportInvoiceDate(@RequestBody DateRequest dateRequest){
        if(dateRequest==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reportService.getInvoiceDate(dateRequest),HttpStatus.OK);
    }

}
