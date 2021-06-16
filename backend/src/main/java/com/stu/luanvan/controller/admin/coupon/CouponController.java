package com.stu.luanvan.controller.admin.coupon;

import com.stu.luanvan.controller.URlController;
import com.stu.luanvan.request.CouponRequest;
import com.stu.luanvan.service.coupon.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(URlController.COUPON_ADMIN)
@CrossOrigin //Cho truy cập vào API từ các Trang web khác, Bảo Mật CRSF
@EnableTransactionManagement
public class CouponController implements CouponInterfaceController{
    @Autowired
    private CouponService couponService;
    @Override
    public ResponseEntity<?> getFindAll() {
        return null;
    }

    @Override
    public ResponseEntity<?> getFindById(int id) {
        return null;
    }

    @Override
    @PostMapping
    public ResponseEntity<?> postSave(CouponRequest couponRequest) throws Exception {

            return new ResponseEntity<>(couponService.saveNew(couponRequest), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> putSave(CouponRequest couponRequest, int id) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(int id) throws Exception {
        return null;
    }
}
