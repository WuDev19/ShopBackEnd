package com.example.ShopBackEnd.controller;

import com.example.ShopBackEnd.dto.get.CartDTO;
import com.example.ShopBackEnd.dto.request.CartAndCartItemRequest;
import com.example.ShopBackEnd.dto.request.CartItemRequest;
import com.example.ShopBackEnd.dto.request.CartRequest;
import com.example.ShopBackEnd.entity.CartItem;
import com.example.ShopBackEnd.entity.GioHang;
import com.example.ShopBackEnd.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/get")
    public ResponseEntity<List<CartDTO>> getAll(){
        return ResponseEntity.ok(cartService.getAll());
    }

    @GetMapping("/getDetail/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return ResponseEntity.ok(cartService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCart(@RequestBody CartAndCartItemRequest cartAndCartItemRequest){
        Map<String, Object> response = cartService.createCart(cartAndCartItemRequest);
        if(response.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getGioHangNguoiDung(@PathVariable String id, @RequestParam int pageNumber){
        Map<String, Object> response = cartService.getGioHangNguoiDung(id, pageNumber);
        return ResponseEntity.ok(response);
    }

}
