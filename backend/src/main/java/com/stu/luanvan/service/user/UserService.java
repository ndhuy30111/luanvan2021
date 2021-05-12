package com.stu.luanvan.service.user;

import com.stu.luanvan.enums.SaveEnum;
import com.stu.luanvan.model.UserModel;
import com.stu.luanvan.repository.UserRepository;
import com.stu.luanvan.request.UserRequest;
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
public class UserService implements UserServiceIntefaces{
    @Autowired
    UserRepository userRepository;
    /*
    *
    * Lấy danh sách theo danh sách chỉ định
    * Return Map<String,Object>
    * */
    @Override
    public Map<String,Object> findByAll(int page, int size,String nameSort ) {
        Pageable pageable = null;
        if(nameSort != null){
            //Sắp xếp theo tên column
            pageable = PageRequest.of(page,size,Sort.by(nameSort).descending());
        }else{
            pageable = PageRequest.of(page,size);
        }
        //danh sách được lấy qua Pageable
        var list = userRepository.findAll(pageable);

        Map<String,Object> map = new HashMap<>();
        map.put("size",list.getSize());
        map.put("total",list.getTotalElements());
        map.put("sumPage",list.getTotalPages());

        return map;
    }

    @Override
    public Collection<UserModel> findByAll() {
        return userRepository.findAll();
    }

    @Override
    public UserModel findById(Integer id) {
        return userRepository.findById(id).
                orElseThrow();
    }

    @Override
    @Transactional
    public UserModel saveNew(UserRequest userRequest) {
        return null;
    }

    @Override
    public UserModel saveEdit(UserRequest userRequest) {
        return null;
    }

    @Override
    public void delete(UserRequest userRequest) {

    }

    @Override
    public UserModel save(UserRequest userRequest, SaveEnum userEnum) {
        var user = new UserModel();
        switch (userEnum){
            case NEW:
                user = saveNew(userRequest);
                break;
            case EDIT:
                user = saveEdit(userRequest);
                break;
            default:{
                return null;
            }
        }
        return user;
    }
}
