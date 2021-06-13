package com.stu.luanvan.controller.admin.size;

import com.stu.luanvan.request.SizeRequest;
import com.stu.luanvan.service.size.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/size")
@CrossOrigin
@EnableTransactionManagement
public class SizeController implements SizeInterfacaeController{
    @Autowired
    private SizeService sizeService;

    @Override
    @PostMapping
    public ResponseEntity<?> postSave(@RequestBody SizeRequest sizeRequest) throws Exception {
        return new ResponseEntity<>(sizeService.saveNew(sizeRequest), HttpStatus.CREATED);
    }
}
