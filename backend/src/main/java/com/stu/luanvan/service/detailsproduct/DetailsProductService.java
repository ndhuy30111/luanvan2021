package com.stu.luanvan.service.detailsproduct;

import com.stu.luanvan.model.detailsproduct.DetailsProductModel;
import com.stu.luanvan.request.DetailsProductRequest;

import java.util.Collection;
import java.util.Map;

public class DetailsProductService implements DetailsProductServiceinterface{
    @Override
    public Map<String, Object> findByAll(int page, int size, String nameSort) {

        return null;
    }

    @Override
    public Collection<DetailsProductModel> findByAll() {
        return null;
    }

    @Override
    public DetailsProductModel findById(Integer id) {
        return null;
    }

    @Override
    public DetailsProductModel saveNew(DetailsProductRequest detailsProductRequest) throws Exception {
        return null;
    }

    @Override
    public DetailsProductModel saveEdit(DetailsProductRequest detailsProductRequest, int id) throws Exception {
        return null;
    }

    @Override
    public void delete(int id) throws Exception {

    }
}
