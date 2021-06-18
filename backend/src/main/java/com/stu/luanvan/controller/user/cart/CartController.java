package com.stu.luanvan.controller.user.cart;

import com.fasterxml.jackson.annotation.JsonView;
import com.stu.luanvan.model.BaseViews;
import com.stu.luanvan.model.cart.CartItemsModel;
import com.stu.luanvan.security.MyUserDetails;
import com.stu.luanvan.service.cart.CartService;
import com.stu.luanvan.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/api")
@EnableTransactionManagement
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @GetMapping("/cart")
    public ResponseEntity<?> showCart(){
        var user = ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserModel();
        var cartItems = cartService.listCartItems(user);
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }
}
