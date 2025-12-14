package com.example.ShopBackEnd.controller;

import com.example.ShopBackEnd.service.impl.CartItemServiceImpl;
import com.example.ShopBackEnd.service.inter.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/cartItem")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @GetMapping("/get/ofCart/{id}")
    public ResponseEntity<?> getCartItemCuaGioHang(@PathVariable Integer id, @RequestParam int pageNumber){
        Map<String, Object> response = cartItemService.getCartItemCuaGioHang(id, pageNumber);
        return ResponseEntity.ok(response);
    }

}
