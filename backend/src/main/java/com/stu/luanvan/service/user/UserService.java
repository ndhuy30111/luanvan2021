package com.stu.luanvan.service.user;

import com.stu.luanvan.exception.BadRequestEx;
import com.stu.luanvan.model.user.UserModel;
import com.stu.luanvan.repository.UserRepository;
import com.stu.luanvan.request.UserRequest;
import com.stu.luanvan.service.ObjectMapDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class UserService implements UserServiceIntefaces{
    @Autowired
    UserRepository userRepository;
    /**
     * Lấy danh sách theo danh sách chỉ định
     * @param page trang sản phẩm
     * @param size số lượng lây sản phẩm
     * @param nameSort Sắp xếp theo tên column
     * @return Map<String, Object>
     */
    @Override
    public Map<String,Object> findByAll(int page, int size,String nameSort ) {
        Pageable pageable ;
        if(nameSort != null){
            //Sắp xếp theo tên column
            pageable = PageRequest.of(page,size,Sort.by(nameSort).descending());
        }else{
            pageable = PageRequest.of(page,size);
        }
        return ObjectMapDto.objectMap(userRepository.findAll(pageable));
    }

    /**
     * Lấy tất cả user
     * @return Collection<>
     */
    @Override
    public Collection<UserModel> findByAll() {
        return userRepository.findAll();
    }

    /**
     * Tìm user theo id
     * @param id
     * @return UserModel
     */
    @Override
    public UserModel findById(Integer id) {
        return userRepository.findById(id).
                orElse(null);
    }

    /**
     * Lưu tài khoản mới
     * @param userRequest
     * @return UserModel
     * @throws Exception //Nếu lỗi sẽ không lưu dữ liệu xuống database
     */
    @Override
    public UserModel saveNew(UserRequest userRequest) throws Exception {
            var find = findByUserName(userRequest.getUserName());
            if(find != null){
                throw new BadRequestEx("trung userName");
            }
            UserModel user = new UserModel(userRequest);
            return userRepository.save(user);
    }

    @Override
    public UserModel saveEdit(UserRequest userRequest,int id) {
        return null;
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public UserModel findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
