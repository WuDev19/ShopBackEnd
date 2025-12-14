package com.example.ShopBackEnd.service.impl;

import com.example.ShopBackEnd.constants.StringConst;
import com.example.ShopBackEnd.dto.get.CartDTO;
import com.example.ShopBackEnd.dto.request.CartAndCartItemRequest;
import com.example.ShopBackEnd.dto.request.CartItemRequest;
import com.example.ShopBackEnd.dto.request.CartRequest;
import com.example.ShopBackEnd.entity.*;
import com.example.ShopBackEnd.repository.*;
import com.example.ShopBackEnd.service.inter.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private NguoiBanRepository nguoiBanRepository;

    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    @Autowired
    private SanPhamChiTietRepository sanPhamChiTietRepository;

    public List<CartDTO> getAll() {
        return cartRepository.findAll().stream().map(gioHang ->
                        new CartDTO(gioHang.getMaGioHang(),
                                gioHang.getNd_gh().getMaND(),
                                gioHang.getNd_gh().getTen(),
                                gioHang.getNb_gh().getMaNguoiBan(),
                                gioHang.getNb_gh().getTenShop(),
                                gioHang.getUpdateTime().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()))
                .toList();
    }

    public CartDTO findById(Integer id) {
        Optional<GioHang> gioHang = cartRepository.findById(id);
        return gioHang.map(gioHang1 ->
                        new CartDTO(
                                gioHang1.getMaGioHang(),
                                gioHang1.getNd_gh().getMaND(),
                                gioHang1.getNd_gh().getTen(),
                                gioHang1.getNb_gh().getMaNguoiBan(),
                                gioHang1.getNb_gh().getTenShop(),
                                gioHang1.getUpdateTime().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()))
                .orElse(null);
    }

    @Transactional
    public Map<String, Object> createCart(CartAndCartItemRequest cartAndCartItemRequest) {

        CartRequest cartRequest = cartAndCartItemRequest.getCartRequest();
        CartItemRequest cartItemRequest = cartAndCartItemRequest.getCartItemRequest();

        Integer maNB = cartRequest.getMaNguoiBan();
        String maND = cartRequest.getMaND();

        GioHang gioHang = getExistGioHang(cartRequest);

        Map<String, Object> response = new HashMap<>();
        Optional<SanPhamChiTiet> sanPhamChiTiet = sanPhamChiTietRepository.findById(cartItemRequest.getMaSanPhamDetail());

        if (gioHang == null) { //chua co gio hang
            Optional<Nguoiban> nguoiban = nguoiBanRepository.findById(maNB);
            Optional<Nguoidung> nguoidung = nguoiDungRepository.findById(maND);
            if (nguoiban.isPresent() && nguoidung.isPresent() && sanPhamChiTiet.isPresent()) {

                gioHang = new GioHang();
                nguoidung.get().addGioHang(gioHang);
                nguoiban.get().addGioHang(gioHang);

                CartItem cartItem = new CartItem();
                cartItem.setGiamGia(cartItemRequest.getGiamGia());
                cartItem.setSoLuong(cartItemRequest.getSoluong());

                sanPhamChiTiet.get().addCartItem(cartItem);

                gioHang.addCartItem(cartItem);

                GioHang giaHangResult = cartRepository.save(gioHang);
                response.put("message", "create success");
                response.put("gioHang", giaHangResult.getUpdateTime());

            }
        } else { //da co gia hang
            CartItem cartItem = getExistCartItem(gioHang.getMaGioHang(), cartItemRequest.getMaSanPhamDetail());
            if (cartItem == null) { //chua co cart thi tao moi
                if (sanPhamChiTiet.isPresent()) {

                    gioHang.setUpdateTime(LocalDateTime.now());

                    cartItem = new CartItem();
                    cartItem.setGiamGia(cartItemRequest.getGiamGia());
                    cartItem.setSoLuong(cartItemRequest.getSoluong());
                    gioHang.addCartItem(cartItem);

                    sanPhamChiTiet.get().addCartItem(cartItem);

                    GioHang gioHangResult = cartRepository.save(gioHang);
                    response.put("message", "create success");
                    response.put("gioHang", gioHangResult.getUpdateTime());

                }
            } else { //da co cart thi cap nhat time cua gio hang va so luong + giam gia cua cart item
                gioHang.setUpdateTime(LocalDateTime.now());
                cartItem.setGiamGia(cartItemRequest.getGiamGia());
                cartItem.setSoLuong(cartItem.getSoLuong() + cartItemRequest.getSoluong());
                GioHang gioHangResult = cartRepository.save(gioHang);
                response.put("message", "create success");
                response.put("gioHang", gioHangResult.getUpdateTime());
            }
        }
        return response;
    }

    private GioHang getExistGioHang(CartRequest cartRequest) {
        Integer maNB = cartRequest.getMaNguoiBan();
        String maND = cartRequest.getMaND();
        Optional<GioHang> gioHang = cartRepository.findByMaNBAndMaND(maND, maNB);
        return gioHang.orElse(null);
    }

    private CartItem getExistCartItem(Integer maGioHang, Integer maSanPhamDetail) {
        Optional<CartItem> cartItem = cartItemRepository.getExistCart(maGioHang, maSanPhamDetail);
        return cartItem.orElse(null);
    }

    public Map<String, Object> getGioHangNguoiDung(String maND, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 6);
        Page<GioHang> gioHangPage = cartRepository.getGioHangNguoiDung(maND, pageable);
        List<CartDTO> cartDTOList = gioHangPage.getContent().stream().map(gioHang ->
                        new CartDTO(gioHang.getMaGioHang(),
                                gioHang.getNd_gh().getMaND(),
                                gioHang.getNd_gh().getTen(),
                                gioHang.getNb_gh().getMaNguoiBan(),
                                gioHang.getNb_gh().getTenShop(),
                                gioHang.getUpdateTime().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()))
                .toList();
        Map<String, Object> response = new HashMap<>();
        response.put(StringConst.PAGE_NUMBER, gioHangPage.getNumber());
        response.put(StringConst.PAGE_SIZE, gioHangPage.getNumberOfElements());
        response.put(StringConst.CONTENTS, cartDTOList);
        return response;
    }

}
