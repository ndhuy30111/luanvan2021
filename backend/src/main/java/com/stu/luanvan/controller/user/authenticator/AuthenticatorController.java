package com.stu.luanvan.controller.user.authenticator;

import com.fasterxml.jackson.annotation.JsonView;
import com.stu.luanvan.exception.NotFoundEx;
import com.stu.luanvan.model.BaseViews;
import com.stu.luanvan.request.auth.LoginRequest;
import com.stu.luanvan.request.UserRequest;
import com.stu.luanvan.request.auth.RegisterRequest;
import com.stu.luanvan.response.JwtResponse;
import com.stu.luanvan.security.MyUserDetails;
import com.stu.luanvan.security.MyUserDetailsService;
import com.stu.luanvan.service.user.UserService;
import com.stu.luanvan.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api")
@EnableTransactionManagement
public class AuthenticatorController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest userRequest) throws Exception {
         var user = userService.saveNew(userRequest);
         return user==null ? new ResponseEntity<>(HttpStatus.NOT_FOUND): new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));

        }catch (BadCredentialsException ex){
            throw new NotFoundEx(ex.getMessage());
        }
        var userDetails = myUserDetailsService.loadUserByUsername(loginRequest.getEmail());
        var jwt =jwtUtil.generateToken(userDetails);
        var date = jwtUtil.extractExpiration(jwt);
        return new ResponseEntity<>(new JwtResponse(jwt,date),HttpStatus.OK);
    }
    @PutMapping("/user")
    public ResponseEntity<?> putSave(@Valid @RequestBody UserRequest userRequest) throws Exception {
        var user = userService.edit(userRequest);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/user")
    @JsonView(BaseViews.Public.class)
    public ResponseEntity<?> profile(){
        var user = ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserModel();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @GetMapping("/user/all")
    public ResponseEntity<?> getAllUser(){
        return new ResponseEntity<>(userService.findByAll(),HttpStatus.OK);
    }

}
