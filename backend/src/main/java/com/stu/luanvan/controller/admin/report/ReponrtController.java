package com.stu.luanvan.controller.admin.report;

import com.stu.luanvan.controller.URlController;
import com.stu.luanvan.service.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
