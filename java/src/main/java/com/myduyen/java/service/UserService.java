package com.myduyen.java.service;

import com.myduyen.java.entity.PhoneEntity;
import com.myduyen.java.entity.UserEntity;
import com.myduyen.java.repository.PhoneRepotiroty;
import com.myduyen.java.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhoneRepotiroty phoneRepotiroty;

    @Override
    public List<UserEntity> getall() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getOne(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<UserEntity> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        if(userEntity.getId()==null){
            UserEntity userNew = userRepository.saveAndFlush(userEntity);
            userNew.getPhone().forEach(e->{
                e.setUser(userNew);
                phoneRepotiroty.save(e);
            });
            return userNew;
        }

        UserEntity userEdit = userRepository.findById(userEntity.getId()).get();
        if(userEdit!=null){
            userEdit.setName(userEntity.getName());
            userEdit.setAge(userEntity.getAge());
            return userRepository.save(userEntity);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
       userRepository.deleteById(id);
    }
}
