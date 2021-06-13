package com.stu.luanvan.service.detailsproduct;

import com.stu.luanvan.exception.NotFoundEx;
import com.stu.luanvan.locales.ExceptionLocales;
import com.stu.luanvan.model.detailsproduct.DetailsProductModel;
import com.stu.luanvan.model.size.SizeModel;
import com.stu.luanvan.repository.ColorReponsitory;
import com.stu.luanvan.repository.DetailsProductReponsitory;
import com.stu.luanvan.repository.ProductRepository;
import com.stu.luanvan.repository.SizeRepository;
import com.stu.luanvan.request.DetailsProductRequest;
import com.stu.luanvan.service.cloudinary.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
@Service
public class DetailsProductService implements DetailsProductServiceinterface{
    @Autowired
    private DetailsProductReponsitory detailsProductReponsitory;
    @Autowired
    private ColorReponsitory colorReponsitory;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CloudinaryService cloudinaryService;
    @Autowired
    private SizeRepository sizeRepository;
    @Override
    public Map<String, Object> findByAll(Integer page, Integer size, String nameSort) {

        return null;
    }

    @Override
    public Collection<DetailsProductModel> findByAll() {
        return null;
    }

    @Override
    public DetailsProductModel findById(Integer id) {
        return  detailsProductReponsitory.findById(id).orElse(null);
    }

    @Override
    public DetailsProductModel saveNew(DetailsProductRequest detailsProductRequest) throws Exception {
        try{
            var product = productRepository.findById(detailsProductRequest.getProduct()).orElse(null);
            var color = colorReponsitory.findById(detailsProductRequest.getColor()).orElse(null);
            if(product == null||color ==null){
                throw new NotFoundEx(ExceptionLocales.NOT_FOUND);
            }
            var image = cloudinaryService.uploadFile(detailsProductRequest.getImage(),product.getName() + " " + color.getName());
            var detailsProduct = new DetailsProductModel(color,image , product);
            detailsProductReponsitory.save(detailsProduct);
            detailsProductRequest.getSize().forEach(e->{
                var size = new SizeModel(e.getName(),detailsProduct);
                sizeRepository.save(size);
            });
            return findById(detailsProduct.getId());
        }catch (Exception ex){
             throw  new Exception(ex.getMessage());
        }

    }

    @Override
    public DetailsProductModel saveEdit(DetailsProductRequest detailsProductRequest, int id) throws Exception {
        return null;
    }

    @Override
    public void delete(Integer id) throws Exception {

    }
}
