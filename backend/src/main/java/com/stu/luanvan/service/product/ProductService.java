package com.stu.luanvan.service.product;

import com.stu.luanvan.exception.NotFoundEx;
import com.stu.luanvan.model.detailsproduct.DetailsProductModel;
import com.stu.luanvan.model.file.FileModel;
import com.stu.luanvan.model.product.ProductModel;
import com.stu.luanvan.model.size.SizeModel;
import com.stu.luanvan.repository.*;
import com.stu.luanvan.request.ProductRequest;
import com.stu.luanvan.service.ObjectMapDto;
import com.stu.luanvan.service.category.CategoryService;
import com.stu.luanvan.service.cloudinary.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Map;

@Service
public class ProductService implements ProductServiceInterface{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CloudinaryService cloudinaryService;
    @Autowired
    private ColorReponsitory colorRepository;
    @Autowired
    private SizeRepository sizeRepository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private DetailsProductReponsitory detailsProductReponsitory;
    @Override
    public Map<String, Object> findByAll(Integer page, Integer size, String nameSort) {
        Pageable pageable;
        if(nameSort != null){
            //Sắp xếp theo tên column
            pageable = PageRequest.of(page,size, Sort.by(nameSort).descending());
        }else{
            pageable = PageRequest.of(page,size);
        }
        return ObjectMapDto.objectMap(productRepository.findAll(pageable));
    }

    @Override
    public Collection<ProductModel> findByAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductModel findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public ProductModel saveNew(ProductRequest productRequest) throws Exception {
        try{
            FileModel file;
            if(productRequest.getFile()==null){
                file = cloudinaryService.uploadFile(productRequest.getImage(),productRequest.getName());
            }else{
                file = fileRepository.findByName(productRequest.getFile().getPublicId());
            }

            var product = new ProductModel(productRequest.getName(),productRequest.getPrice(),productRequest.getInfo(),productRequest.getInfo_small(),file);
            var category = categoryService.findById(productRequest.getCategory());
            if(category!=null){
                product.setCategory(category);
            }
            productRepository.save(product);
            productRequest.getDetailsProduct().forEach(c->{
                FileModel filecolor;

                var color = colorRepository.findById(c.getColor()).get();
                if(c.getFile()==null){
                     filecolor = cloudinaryService.uploadFile(c.getImage(),product.getName()+" "+color.getName());
                }else{
                    filecolor = fileRepository.findByName(c.getFile().getPublicId());
                }
                var detailsProduct = new DetailsProductModel(color,filecolor, product);
                detailsProductReponsitory.save(detailsProduct);
                c.getSize().forEach(s->{
                    var size = new SizeModel(s.getName(),s.getAmount(),detailsProduct);
                    sizeRepository.save(size);
                });
            });
            return product;
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public ProductModel saveEdit(ProductRequest productRequest,int id) throws Exception {
        try{
            var product = findById(id);
            if(product!=null){
                product.edit(productRequest);
                if(productRequest.getCategory()!=null){
                    var category = categoryService.findById(productRequest.getId());
                    product.setCategory(category);
                }
                productRepository.save(product);
                return product;
            }
            throw new NotFoundEx("Không tìm thấy sản phẩm");
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        try{
            var product = findById(id);
            if(product!=null){
                productRepository.delete(product);
            }
            throw new NotFoundEx("Không tìm thấy sản phẩm");
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
