package com.stu.luanvan.service.color;

import com.stu.luanvan.model.color.ColorModel;
import com.stu.luanvan.repository.ColorReponsitory;
import com.stu.luanvan.request.ColorRequest;
import com.stu.luanvan.request.DetailsProductRequest;
import org.apache.commons.lang3.StringUtils;
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
    public Map<String, Object> findByAll(int page, int size, String nameSort) {
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
    public ColorModel saveNew(ColorRequest colorRequest) throws Exception {
        var color = new ColorModel(colorRequest.getName(),colorRequest.getCode());
        return colorReponsitory.save(color);

    }

    @Override
    public ColorModel saveEdit(ColorRequest colorRequest, int id) throws Exception {
        return null;
    }

    @Override
    public void delete(int id) throws Exception {

    }
}
