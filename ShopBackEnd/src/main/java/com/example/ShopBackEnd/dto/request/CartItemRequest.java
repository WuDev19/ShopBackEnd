package com.example.ShopBackEnd.dto.request;

public class CartItemRequest {
    private Integer maSanPhamDetail;
    private Integer soluong;
    private Integer giamGia;

    public CartItemRequest() {
    }

    public CartItemRequest(Integer maSanPhamDetail, Integer soluong, Integer giamGia) {
        this.maSanPhamDetail = maSanPhamDetail;
        this.soluong = soluong;
        this.giamGia = giamGia;
    }

    public Integer getMaSanPhamDetail() {
        return maSanPhamDetail;
    }

    public void setMaSanPhamDetail(Integer maSanPhamDetail) {
        this.maSanPhamDetail = maSanPhamDetail;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public Integer getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(Integer giamGia) {
        this.giamGia = giamGia;
    }

}
