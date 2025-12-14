package com.example.ShopBackEnd.service.inter;

import java.util.Map;

public interface CartItemService {
    Map<String, Object> getCartItemCuaGioHang(Integer maGioHang, int pageNumber);
}
