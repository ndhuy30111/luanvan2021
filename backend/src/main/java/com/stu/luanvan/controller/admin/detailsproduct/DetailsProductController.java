package com.stu.luanvan.controller.admin.detailsproduct;

import com.stu.luanvan.controller.URlController;
import com.stu.luanvan.request.DetailsProductRequest;
import com.stu.luanvan.service.detailsproduct.DetailsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(URlController.DETAILS_PRODUCT_ADMIN)
@CrossOrigin
@EnableTransactionManagement
public class DetailsProductController implements DetailsProductInterfaceController{
    @Autowired
    private DetailsProductService detailsProductService;
    @Override
    @PostMapping
    @ResponseBody
    public ResponseEntity<?> postSave(@RequestBody @Valid DetailsProductRequest detailsProductRequest) throws Exception {
        try {
            return new ResponseEntity<>(detailsProductService.saveNew(detailsProductRequest), HttpStatus.CREATED);
        }catch (Exception ex){
            return  new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
