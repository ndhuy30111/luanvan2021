package com.stu.luanvan.security;

import com.stu.luanvan.model.UserModel;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class SecurityAuditorAware implements AuditorAware<UserModel> {

    @Override
    public Optional<UserModel> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        return  Optional.of(((MyUserDetails) authentication.getPrincipal()).getUserModel());
    }
}
