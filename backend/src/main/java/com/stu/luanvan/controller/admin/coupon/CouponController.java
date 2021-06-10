package com.stu.luanvan.controller.admin.coupon;

import com.stu.luanvan.request.CouponRequest;
import org.springframework.http.ResponseEntity;

public class CouponController implements CouponInterfaceController{
    @Override
    public ResponseEntity<?> getFindAll() {
        return null;
    }

    @Override
    public ResponseEntity<?> getFindById(int id) {
        return null;
    }

    @Override
    public ResponseEntity<?> postSave(CouponRequest couponRequest) throws Exception {
        return null;
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
