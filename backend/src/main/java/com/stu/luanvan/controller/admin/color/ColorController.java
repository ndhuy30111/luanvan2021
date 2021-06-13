package com.stu.luanvan.controller.admin.color;

import com.stu.luanvan.controller.URlController;
import com.stu.luanvan.request.ColorRequest;
import com.stu.luanvan.service.color.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(URlController.COLOR_ADMIN) //Cho truy cập vào API từ các Trang web khác, Bảo Mật CRSF
@EnableTransactionManagement
public class ColorController implements ColorInterfaceController{

    @Autowired
    private ColorService colorService;
    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<?> getFindAll() {
        return new ResponseEntity<>(colorService.findByAll(), HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity<?> getFindById(int id) {
        return null;
    }

    @Override
    @PostMapping
    @ResponseBody
    public ResponseEntity<?> postSave(@RequestBody ColorRequest colorRequest) throws Exception {
        return new ResponseEntity<>(colorService.saveNew(colorRequest),HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<?> putSave(@RequestBody ColorRequest colorRequest,@PathVariable int id) throws Exception {
        try{
            return new ResponseEntity<>(colorService.saveEdit(colorRequest,id),HttpStatus.OK);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }

    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) throws Exception {
        try{
            colorService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
