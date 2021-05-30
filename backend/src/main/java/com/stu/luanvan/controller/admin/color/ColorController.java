package com.stu.luanvan.controller.admin.color;

import com.stu.luanvan.request.ColorRequest;
import com.stu.luanvan.service.color.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/admin/color") //Cho truy cập vào API từ các Trang web khác, Bảo Mật CRSF
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
    public ResponseEntity<?> postSave(ColorRequest colorRequest) throws Exception {
        return new ResponseEntity<>(colorService.saveNew(colorRequest),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> putSave(ColorRequest colorRequest, int id) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(int id) throws Exception {
        return null;
    }
}
