package com.example.ShopBackEnd.service.impl;

import com.example.ShopBackEnd.constants.StringConst;
import com.example.ShopBackEnd.dto.get.CartItemDTO;
import com.example.ShopBackEnd.dto.get.sanpham.SanPhamChiTietDTO;
import com.example.ShopBackEnd.entity.CartItem;
import com.example.ShopBackEnd.entity.SanPhamChiTiet;
import com.example.ShopBackEnd.repository.CartItemRepository;
import com.example.ShopBackEnd.service.inter.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public Map<String, Object> getCartItemCuaGioHang(Integer maGioHang, int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber, 6);
        Page<CartItem> cartItemPage = cartItemRepository.getCartItemCuaGioHang(maGioHang, pageable);
        List<CartItemDTO> cartItemDTOList = cartItemPage.getContent().stream().map(cartItem ->
                new CartItemDTO(
                        cartItem.getCartItemId(),
                        cartItem.getCi_gh().getMaGioHang(),
                        mapToSanPhamChiTietDTO(cartItem.getCi_spct()),
                        cartItem.getSoLuong(),
                        cartItem.getGiamGia()))
                .toList();
        Map<String, Object> response = new HashMap<>();
        response.put(StringConst.PAGE_NUMBER, cartItemPage.getNumber());
        response.put(StringConst.PAGE_SIZE, cartItemPage.getNumberOfElements());
        response.put(StringConst.CONTENTS, cartItemDTOList);
        return response;
    }

    private SanPhamChiTietDTO mapToSanPhamChiTietDTO(SanPhamChiTiet sanPhamChiTiet){
        return new SanPhamChiTietDTO(
                sanPhamChiTiet.getMaSanPhamDeTail(),
                sanPhamChiTiet.getTenDetail(),
                sanPhamChiTiet.getInStock(),
                sanPhamChiTiet.getAnhDetail(),
                sanPhamChiTiet.getUnitPrice(),
                sanPhamChiTiet.getColor(),
                sanPhamChiTiet.getKichco(),
                sanPhamChiTiet.getSanpham().getMaSp());
    }
}
