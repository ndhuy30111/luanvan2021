package com.stu.luanvan.service.cart;

import com.stu.luanvan.exception.BadRequestEx;
import com.stu.luanvan.locales.ExceptionLocales;
import com.stu.luanvan.model.cart.CartItemsModel;
import com.stu.luanvan.model.user.UserModel;
import com.stu.luanvan.repository.CartItemsRepository;
import com.stu.luanvan.repository.ProductRepository;
import com.stu.luanvan.request.CartRequest;
import com.stu.luanvan.request.UserRequest;
import com.stu.luanvan.response.CartItemsResponse;
import com.stu.luanvan.response.CartResponse;
import com.stu.luanvan.security.MyUserDetails;
import com.stu.luanvan.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class CartService implements CartServiceInterfaces{
    @Autowired
    private CartItemsRepository cartItemsRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    public Collection<CartResponse> listCartItems(UserModel user) {
        var cart = cartItemsRepository.findByUser(user);

        Collection<CartResponse> listCart = new ArrayList<>();
        cart.forEach(el->{
            var cartRepository = new CartResponse();
            cartRepository.setId(el.getProduct().getId());
            cartRepository.setColor(el.getColor());
            cartRepository.setSize(el.getSize());
            cartRepository.setName(el.getProduct().getName());
            cartRepository.setPrice(el.getProduct().getPrice());
            cartRepository.setQuantity(el.getQuantity());
            el.getProduct().getDetailsProduct().forEach(elm->{
                if(elm.getColor().getName().equals(cartRepository.getColor())){
                    cartRepository.setImage(elm.getImage().getUrl());
                }
            });
            listCart.add(cartRepository);

        });
        return listCart;
    }

    @Override
    public CartItemsModel saveNew(CartRequest cartRequest) throws Exception {
        var find = productService.findById(cartRequest.getProductID());
        var user = ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserModel();
        if(find == null){
            throw new BadRequestEx(ExceptionLocales.NOT_FOUND_PRODUCT);
        }
        try{
            CartItemsModel cart = new CartItemsModel(cartRequest,find, user);
            return cartItemsRepository.save(cart);
        }catch (Exception ex){
            throw new Exception(ExceptionLocales.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public Map<String, Object> findByAll(Integer page, Integer size, String nameSort) {
        return null;
    }

    @Override
    public Collection<CartItemsModel> findByAll() {
        return null;
    }

    @Override
    public CartItemsModel findById(Integer id) {
        return null;
    }

    @Override
    public CartItemsModel saveNew(Integer integer) throws Exception {
        return null;
    }

    @Override
    public CartItemsModel saveEdit(Integer integer, int id) throws Exception {
        return null;
    }

    @Override
    public void delete(Integer id) throws Exception {

    }
}
