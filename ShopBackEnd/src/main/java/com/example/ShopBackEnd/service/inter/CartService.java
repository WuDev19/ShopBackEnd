package com.example.ShopBackEnd.service.inter;

import com.example.ShopBackEnd.dto.get.CartDTO;
import com.example.ShopBackEnd.dto.request.CartAndCartItemRequest;

import java.util.List;
import java.util.Map;

public interface CartService {

    List<CartDTO> getAll();
    CartDTO findById(Integer id);
    Map<String, Object> createCart(CartAndCartItemRequest cartAndCartItemRequest);
    Map<String, Object> getGioHangNguoiDung(String maND, int pageNumber);

}
