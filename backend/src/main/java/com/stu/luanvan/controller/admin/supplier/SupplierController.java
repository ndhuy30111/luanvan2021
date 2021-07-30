package com.stu.luanvan.controller.admin.supplier;

import com.stu.luanvan.controller.URlController;
import com.stu.luanvan.request.SupplierRequest;
import com.stu.luanvan.service.supplier.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(URlController.SUPPLIER_ADMIN)
@CrossOrigin
@EnableTransactionManagement
public class SupplierController implements SupplierInterfaceController{

    private SupplierService supplierService;

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getFindById(@PathVariable int id) {
        return new ResponseEntity<>(supplierService.findById(id), HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<?> postSave(SupplierRequest supplierRequest) throws Exception {
        return new ResponseEntity<>(supplierService.saveNew(supplierRequest), HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<?> putSave(SupplierRequest supplierRequest, int id) throws Exception {
        return new ResponseEntity<>(supplierService.saveEdit(supplierRequest,id), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(int id) throws Exception {
        supplierService.delete(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
