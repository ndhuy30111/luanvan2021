package com.stu.luanvan.service.cart;

import com.stu.luanvan.model.cart.CartItemsModel;
import com.stu.luanvan.model.user.UserModel;
import com.stu.luanvan.repository.CartItemsRepository;
import com.stu.luanvan.response.CartItemsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartItemsRepository cartRepo;

    public Collection<CartItemsResponse> listCartItems(UserModel user) {
        return cartRepo.findByUserAndColorName(user.getId());
    }
}
