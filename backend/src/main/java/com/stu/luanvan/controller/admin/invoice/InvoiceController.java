package com.stu.luanvan.controller.admin.invoice;

import com.stu.luanvan.controller.URlController;
import com.stu.luanvan.request.CategoryRequest;
import com.stu.luanvan.service.invoice.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(URlController.INVOICE_ADMIN) //Cho truy cập vào API từ các Trang web khác, Bảo Mật CRSF
@EnableTransactionManagement
public class InvoiceController implements InvoiceInterfaceController{
    @Autowired
    private InvoiceService invoiceService;
    @Override
    @GetMapping
    public ResponseEntity<?> getFindAll(int page, int size, String name) {
        if(page!=-1&&size!=-1){
            return new ResponseEntity<>(invoiceService.findByAll(page,size,name), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(invoiceService.findByAll(),HttpStatus.OK);
        }
    }

    @Override
    @GetMapping("/receive")
    public ResponseEntity<?> getFindAllReceive() {
        return new ResponseEntity<>(invoiceService.findAllReceive(),HttpStatus.OK);
    }

    @Override
    @GetMapping("/not_receive")
    public ResponseEntity<?> getFindAllNotReceive() {
        return new ResponseEntity<>(invoiceService.findAllNotReceive(),HttpStatus.OK);
    }

    @Override
    @GetMapping("/cancel_receive")
    public ResponseEntity<?> getFindAllCancelReceive() {
        return new ResponseEntity<>(invoiceService.findAllCancelReceive(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getFindById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<?> postSave(CategoryRequest categoryRequest) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<?> putSave(CategoryRequest categoryRequest, Integer id) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Integer id) throws Exception {
        return null;
    }
}
