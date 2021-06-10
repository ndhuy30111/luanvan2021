package com.stu.luanvan.service.color;

import com.stu.luanvan.exception.NotFoundEx;
import com.stu.luanvan.locales.ExceptionLocales;
import com.stu.luanvan.model.color.ColorModel;
import com.stu.luanvan.repository.ColorReponsitory;
import com.stu.luanvan.request.ColorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Map;
@Service
public class ColorService implements ColorSerivceInterface{

    @Autowired
    private ColorReponsitory colorReponsitory;
    @Override
    public Map<String, Object> findByAll(Integer page, Integer size, String nameSort) {
        return null;
    }

    @Override
    public Collection<ColorModel> findByAll() {
        return colorReponsitory.findAll();
    }

    @Override
    public ColorModel findById(Integer id) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public ColorModel saveNew(ColorRequest colorRequest) throws Exception {
        var color = new ColorModel(colorRequest.getName(),colorRequest.getCode());
        return colorReponsitory.save(color);

    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public ColorModel saveEdit(ColorRequest colorRequest, int id) throws Exception {
        try{
            var color = colorReponsitory.findById(id).orElse(null);
            if(color== null){
                throw new NotFoundEx(ExceptionLocales.NOT_FOUND_PRODUCT);
            }
            if(!color.getDetailsProduct().isEmpty()){
                throw new Exception(ExceptionLocales.CAN_NOT_DELETE_COLOR);
            }
            color.ColorEditModel( colorRequest);
            return colorReponsitory.save(color);
        }catch(Exception ex){
            throw new Exception(ExceptionLocales.CAN_NOT_DELETE_COLOR);
        }

    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void delete(Integer id) throws Exception {
        try{
            var color = colorReponsitory.findById(id).orElse(null);
            if(color== null){
                throw new NotFoundEx(ExceptionLocales.NOT_FOUND_PRODUCT);
            }
            if(!color.getDetailsProduct().isEmpty()){
                throw new Exception(ExceptionLocales.CAN_NOT_DELETE_COLOR);
            }
            colorReponsitory.delete(color);
        }catch(Exception ex){
            throw new Exception(ExceptionLocales.CAN_NOT_DELETE_COLOR);
        }

    }
}
