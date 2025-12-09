package com.example.ShopBackEnd.dto.get;

import com.example.ShopBackEnd.dto.get.sanpham.SanPhamChiTietDTO;

public class CartItemDTO {
    private Integer cartItemId;
    private Integer maGioHang;
    private SanPhamChiTietDTO detailProduct;
    private Integer soLuong;
    private Integer giamGia;

    public CartItemDTO() {
    }

    public CartItemDTO(Integer cartItemId, Integer maGioHang, SanPhamChiTietDTO detailProduct, Integer soLuong, Integer giamGia) {
        this.cartItemId = cartItemId;
        this.maGioHang = maGioHang;
        this.detailProduct = detailProduct;
        this.soLuong = soLuong;
        this.giamGia = giamGia;
    }

    public Integer getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Integer getMaGioHang() {
        return maGioHang;
    }

    public void setMaGioHang(Integer maGioHang) {
        this.maGioHang = maGioHang;
    }

    public SanPhamChiTietDTO getDetailProduct() {
        return detailProduct;
    }

    public void setDetailProduct(SanPhamChiTietDTO detailProduct) {
        this.detailProduct = detailProduct;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(Integer giamGia) {
        this.giamGia = giamGia;
    }

}
