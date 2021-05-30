package com.stu.luanvan.config;

import com.stu.luanvan.filter.JwtRequestFilter;
import com.stu.luanvan.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private JwtRequestFilter jwtRequestFilter;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        hasRole("ADMIN")
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/api/admin/category").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/admin/category/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/admin/user").hasAnyRole("ADMIN","EDIT")
                .antMatchers(HttpMethod.POST,"/api/admin/category").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/admin/category").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/admin/category").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/user").authenticated()
                .antMatchers(HttpMethod.POST,"/api/register").permitAll()
                .antMatchers(HttpMethod.POST,"/api/login").permitAll()
                .antMatchers(HttpMethod.POST,"/api/admin/login").permitAll()
                .anyRequest().permitAll()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
