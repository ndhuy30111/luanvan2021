package com.stu.luanvan.service.coupon;

import com.stu.luanvan.exception.NotFoundEx;
import com.stu.luanvan.locales.ExceptionLocales;
import com.stu.luanvan.model.coupon.CouponModel;
import com.stu.luanvan.repository.CouponRepository;
import com.stu.luanvan.repository.SizeRepository;
import com.stu.luanvan.request.CouponRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
@Service
public class CouponService implements CouponSerivceInterface{
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private SizeRepository sizeRepository;
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
        try{
            var size = sizeRepository.findById(couponRequest.getId()).orElse(null);
            if(size== null){
                throw new NotFoundEx(ExceptionLocales.NOT_FOUND);
            }
            var coupon = new CouponModel(size,couponRequest.getAmount());
            couponRepository.saveAndFlush(coupon);
            size.themAmount(couponRequest.getAmount());
            sizeRepository.save(size);
            return coupon;
        }catch(Exception ex){
            logger.error("Save Coupon: ",ex);
            throw new Exception(ExceptionLocales.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public CouponModel saveEdit(CouponRequest couponRequest, int id) throws Exception {
        return null;
    }

    @Override
    public void delete(Integer id) throws Exception {

    }
}
