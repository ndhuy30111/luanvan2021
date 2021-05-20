package com.stu.luanvan.controller.admin.product;

import com.stu.luanvan.exception.NotFoundEx;
import com.stu.luanvan.repository.ProductRepository;
import com.stu.luanvan.request.CategoryRequest;
import com.stu.luanvan.request.ProductRequest;
import com.stu.luanvan.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/admin/product")
@CrossOrigin //Cho truy cập vào API từ các Trang web khác, Bảo Mật CRSF
@EnableTransactionManagement
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getFindAll(@RequestParam(name = "page",required = false,defaultValue = "-1")int page,
                                        @RequestParam(name = "size",required = false,defaultValue = "-1") int size,
                                        @RequestParam(name = "name",required = false,defaultValue = "id") String name) {

        try{
            if(page!=-1&&size!=-1){
                return new ResponseEntity<>(productService.findByAll(page,size,name),HttpStatus.OK);
            }else{
                return new ResponseEntity<>(productService.findByAll(),HttpStatus.OK);
            }
        }catch(Exception ex){
            throw new NotFoundEx("Không có dự liệu");
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getFindById(@PathVariable int id) {
        return new ResponseEntity<>(productService.findById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> postSave(@Valid @RequestBody ProductRequest productRequest) throws Exception {
        try {
            var product  =  productService.saveNew(productRequest);

           return new ResponseEntity<>(product, HttpStatus.CREATED);
        }catch (Exception ex){
            return  new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
