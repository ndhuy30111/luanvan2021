package com.stu.luanvan.security;

import com.stu.luanvan.model.UserModel;
import com.stu.luanvan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    /**
     * Xác thực người dùng theo username
     * @param username
     * @return UserDetails
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userRepository.findByUserName(username);
        if(userModel==null){
             throw new UsernameNotFoundException(username);
        }
        return new MyUserDetails(userModel);

    }
}
