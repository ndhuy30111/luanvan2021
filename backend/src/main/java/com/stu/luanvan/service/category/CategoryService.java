package com.stu.luanvan.service.category;

import com.stu.luanvan.exception.NotFoundEx;
import com.stu.luanvan.model.CategoryModel;
import com.stu.luanvan.repository.CategoryRepository;
import com.stu.luanvan.request.CategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Service
public class CategoryService implements CategoryServiceInterface{
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Map<String, Object> findByAll(int page, int size, String nameSort) {
        Pageable pageable;
        if(nameSort != null){
            //Sắp xếp theo tên column
            pageable = PageRequest.of(page,size, Sort.by(nameSort).descending());
        }else{
            pageable = PageRequest.of(page,size);
        }
        //danh sách được lấy qua Pageable
        var list = categoryRepository.findAll(pageable);
        Map<String,Object> map = new HashMap<>();
        map.put("size",list.getSize());
        map.put("total",list.getTotalElements());
        map.put("sumPage",list.getTotalPages());
        map.put("date",list.getContent());
        return map;
    }

    @Override
    public Collection<CategoryModel> findByAll() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryModel findById(Integer id)
    {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public CategoryModel saveNew(CategoryRequest categoryRequest) throws Exception {
        try{
            CategoryModel category ;
            CategoryModel categoryFind;
            if(categoryRequest.getCategory_id()!=null){
                categoryFind = categoryRepository.findById(categoryRequest.getCategory_id().getId()).orElse(null);
                category = new CategoryModel(categoryRequest,categoryFind);
            }else{
                category = new CategoryModel(categoryRequest,null);
            }

            return categoryRepository.save(category);
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }

    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public CategoryModel saveEdit(CategoryRequest categoryRequest) throws Exception {
        try{
            var category = categoryRepository.
                    findById(categoryRequest.getId()).
                    orElse(null);
            if(category ==null){
                throw new NotFoundEx("Không tìm thấy");
            }
            var categoryFind = findById(categoryRequest.getCategory_id().getId());
            category.edit(categoryRequest,categoryFind);
            return categoryRepository.save(category);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }

    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void delete(CategoryRequest categoryRequest) throws Exception {
        try{
            var category = categoryRepository.
                    findById(categoryRequest.getId()).
                    orElse(null);
            if(category ==null){
                throw new NotFoundEx("Không tìm thấy");
            }
            categoryRepository.delete(category);
        }catch (Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
}
