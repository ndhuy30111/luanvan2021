package com.stu.luanvan.service.coupon;

import com.stu.luanvan.model.coupon.CouponModel;
import com.stu.luanvan.repository.CouponRepository;
import com.stu.luanvan.request.CouponRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
@Service
public class CouponService implements CouponSerivceInterface{
    @Autowired
    private CouponRepository couponRepository;
    @Override
    public Map<String, Object> findByAll(Integer page, Integer size, String nameSort) {
        return null;
    }

    @Override
    public Collection<CouponModel> findByAll() {
        return couponRepository.findAll();
    }

    @Override
    public CouponModel findById(Integer id) {
        return null;
    }

    @Override
    public CouponModel saveNew(CouponRequest couponRequest) throws Exception {
        return null;
    }

    @Override
    public CouponModel saveEdit(CouponRequest couponRequest, int id) throws Exception {
        return null;
    }

    @Override
    public void delete(Integer id) throws Exception {

    }
}
