package com.stu.luanvan.controller.admin.category;

import com.stu.luanvan.exception.NotFoundEx;
import com.stu.luanvan.request.CategoryRequest;
import com.stu.luanvan.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/category")
@CrossOrigin //Cho truy cập vào API từ các Trang web khác, Bảo Mật CRSF
@EnableTransactionManagement
public class CategoryController{
    @Autowired
    private CategoryService categoryService;

    /**
     * Hàm lấy danh sách Danh mục
     * @param page Số Trang muốn lấy
     * @param size Số lượng danh mục muốn lấy
     * @param name Tên danh mục
     * @return HttpStatus.OK
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getFindAll(@RequestParam(value = "page",required = false,defaultValue = "0")int page,
                                        @RequestParam(value = "size",required = false,defaultValue = "0") int size,
                                        @RequestParam(value = "name",required = false,defaultValue = "id") String name) {

        try{
            if(page!=0&&size!=0){
                return new ResponseEntity<>(categoryService.findByAll(page,size,name),HttpStatus.OK);
            }else{
                return new ResponseEntity<>(categoryService.findByAll(),HttpStatus.OK);
            }
        }catch(Exception ex){
            throw new NotFoundEx("Không có dự liệu");
        }
    }

    /**
     * Hàm tìm thông tin category nếu không có trả về null
     * @param id
     * @return HttpStatus.OK
     */

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getFindById(@PathVariable int id) {
        return new ResponseEntity<>(categoryService.findById(id),HttpStatus.OK);
    }

    /**
     * Thêm mới thông tin danh mục
     * @param categoryRequest Request
     * @return HttpStatus.CREATED
     * @throws Exception  //Thông báo lỗi 500 khi sửa thông tin lỗi
     */
    @PostMapping
    public ResponseEntity<?> postSave(@RequestBody CategoryRequest categoryRequest) throws Exception {
       try {
           var category = categoryService.saveNew(categoryRequest);
           return new ResponseEntity<>(category, HttpStatus.CREATED);
       }catch (Exception ex){
           return  new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
       }
    }

    /**
     * Hàm Sửa thông tin danh mục
     * @param categoryRequest Request
     * @return ResponseEntity
     * @throws Exception //Thông báo lỗi 500 khi sửa thông tin lỗi
     */
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> putSave(@RequestBody CategoryRequest categoryRequest) throws Exception {
        try{
            var category = categoryService.saveEdit(categoryRequest);
            return new ResponseEntity<>(category, HttpStatus.OK);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    /**
     * Hàm xoá thông tin category
     * @param categoryRequest Request
     * @return HttpStatus.OK
     * @throws Exception //Lỗi không xoá được và được rollback dữ liệu như cũ
     */
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> delete(@RequestBody CategoryRequest categoryRequest) throws Exception {
        try{
            categoryService.delete(categoryRequest);
            return new ResponseEntity<>( HttpStatus.OK);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}