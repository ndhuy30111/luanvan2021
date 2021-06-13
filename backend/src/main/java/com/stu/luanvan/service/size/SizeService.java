package com.stu.luanvan.service.size;

import com.stu.luanvan.exception.NotFoundEx;
import com.stu.luanvan.locales.ExceptionLocales;
import com.stu.luanvan.model.size.SizeModel;
import com.stu.luanvan.repository.ColorReponsitory;
import com.stu.luanvan.repository.DetailsProductReponsitory;
import com.stu.luanvan.repository.ProductRepository;
import com.stu.luanvan.repository.SizeRepository;
import com.stu.luanvan.request.SizeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
@Service
public class SizeService implements SizeServiceInterfaces {
    @Autowired
    private DetailsProductReponsitory detailsProductReponsitory;
    @Autowired
    private ColorReponsitory colorReponsitory;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SizeRepository sizeRepository;
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
        try{
            var detailsProduct =detailsProductReponsitory.findById(sizeRequest.getDetailsProduct()).orElse(null);
            if( detailsProduct == null){
                throw new NotFoundEx(ExceptionLocales.NOT_FOUND);
            }
            var size = new SizeModel(sizeRequest.getName(),detailsProduct);
            return sizeRepository.save(size);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public SizeModel saveEdit(SizeRequest sizeRequest,int id) throws Exception {
       return null;
    }

    @Override
    public void delete(Integer id) throws Exception {

    }
}
