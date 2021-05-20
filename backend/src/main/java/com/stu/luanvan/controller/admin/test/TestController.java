package com.stu.luanvan.controller.admin.test;

import com.cloudinary.Cloudinary;
import com.stu.luanvan.exception.NotFoundEx;
import com.stu.luanvan.request.CategoryRequest;
import com.stu.luanvan.request.FileRequest;
import com.stu.luanvan.request.ProductRequest;
import com.stu.luanvan.service.category.CategoryService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/test")
@CrossOrigin //Cho truy cập vào API từ các Trang web khác, Bảo Mật CRSF
@EnableTransactionManagement
public class TestController {
    @Autowired
    private Cloudinary cloudinaryConfig;
    @Autowired
    private CategoryService categoryService;
    @PostMapping
    public ResponseEntity<?> postSave(@Valid @RequestBody FileRequest productRequest) throws Exception {
        try {
            var flap = Base64.isBase64(productRequest.getPublicId());
            return new ResponseEntity<>(flap, HttpStatus.CREATED);
        }catch (Exception ex){
            return  new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getFindAll(@RequestParam(name = "page",required = false,defaultValue = "-1")int page,
                                        @RequestParam(name = "size",required = false,defaultValue = "-1") int size,
                                        @RequestParam(name = "name",required = false,defaultValue = "id") String name) {

        try{
            if(page!=-1&&size!=-1){
                return new ResponseEntity<>(categoryService.findByAll(page,size,name),HttpStatus.OK);
            }else{
                return new ResponseEntity<>(categoryService.findByAll(),HttpStatus.OK);
            }
        }catch(Exception ex){
            throw new NotFoundEx("Không có dự liệu");
        }
    }
}
