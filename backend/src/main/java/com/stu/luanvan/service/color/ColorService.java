package com.stu.luanvan.service.color;

import com.stu.luanvan.exception.NotFoundEx;
import com.stu.luanvan.model.color.ColorModel;
import com.stu.luanvan.model.file.FileModel;
import com.stu.luanvan.repository.ColorRepository;
import com.stu.luanvan.repository.FileRepository;
import com.stu.luanvan.request.ColorRequest;
import com.stu.luanvan.service.cloudinary.CloudinaryService;
import com.stu.luanvan.service.product.ProductService;
import com.stu.luanvan.service.size.SizeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Map;

public class ColorService implements ColorSerivceInterface{
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private SizeService sizeService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CloudinaryService cloudinaryService;
    @Autowired
    private FileRepository fileRepository;
    @Override
    public Map<String, Object> findByAll(int page, int size, String nameSort) {
        return null;
    }

    @Override
    public Collection<ColorModel> findByAll() {
        return null;
    }

    @Override
    public ColorModel findById(Integer id) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public ColorModel saveNew(ColorRequest colorRequest) throws Exception {
        try{
            var product = productService.findById(colorRequest.getProductId());
            if(product!=null ){
                FileModel file ;
                if(colorRequest.getFile()==null){
                    file = cloudinaryService.uploadFile(colorRequest.getImage(),product.getName() + " " + colorRequest.getName());
                }else{
                    file =  fileRepository.findByName(colorRequest.getFile().getPublicId());
                }
                ColorModel color = new ColorModel(colorRequest.getName(), file,  product);
                colorRepository.save(color);
            }
            throw new NotFoundEx("Không tìm thấy");
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }

    }
    @Override
    public ColorModel saveEdit(ColorRequest colorRequest,int id) throws Exception {
        if(!StringUtils.isEmpty(colorRequest.getName().trim())){
        }
        return null;
    }

    @Override
    public void delete(int id) throws Exception {

    }
}
