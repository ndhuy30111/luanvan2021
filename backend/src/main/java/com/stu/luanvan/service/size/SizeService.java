package com.stu.luanvan.service.size;

import com.stu.luanvan.model.size.SizeModel;
import com.stu.luanvan.request.SizeRequest;

import java.util.Collection;
import java.util.Map;

public class SizeService implements SizeServiceInterfaces {
    @Override
    public Map<String, Object> findByAll(Integer page, Integer size, String nameSort) {
        return null;
    }

    @Override
    public Collection<SizeModel> findByAll() {
        return null;
    }

    @Override
    public SizeModel findById(Integer id) {
        return null;
    }

    @Override
    public SizeModel saveNew(SizeRequest sizeRequest) throws Exception {
        return null;
    }

    @Override
    public SizeModel saveEdit(SizeRequest sizeRequest,int id) throws Exception {
        return null;
    }

    @Override
    public void delete(Integer id) throws Exception {

    }
}
