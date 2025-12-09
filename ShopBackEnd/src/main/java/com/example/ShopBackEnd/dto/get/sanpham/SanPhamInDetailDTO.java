package com.example.ShopBackEnd.dto.get.sanpham;

import java.util.Set;

public class SanPhamInDetailDTO {
    private Integer maSp;
    private String tenNguoiBan;
    private Integer maNguoiBan;
    private String avtShop;
    private Integer giaSp;
    private String motaSp;
    private Integer giamgia;
    private Integer numberBought;
    private Set<String> listAnhMoTa;
    private Integer totalProduct;
    private Integer rating;

    public SanPhamInDetailDTO() {
    }

    public SanPhamInDetailDTO(Integer maSp, String tenNguoiBan, Integer maNguoiBan, String avtShop, Integer giaSp, String motaSp, Integer giamgia, Integer numberBought, Set<String> listAnhMoTa, Integer totalProduct, Integer rating) {
        this.maSp = maSp;
        this.tenNguoiBan = tenNguoiBan;
        this.maNguoiBan = maNguoiBan;
        this.avtShop = avtShop;
        this.giaSp = giaSp;
        this.motaSp = motaSp;
        this.giamgia = giamgia;
        this.numberBought = numberBought;
        this.listAnhMoTa = listAnhMoTa;
        this.totalProduct = totalProduct;
        this.rating = rating;
    }

    public Integer getMaSp() {
        return maSp;
    }

    public void setMaSp(Integer maSp) {
        this.maSp = maSp;
    }

    public String getTenNguoiBan() {
        return tenNguoiBan;
    }

    public void setTenNguoiBan(String tenNguoiBan) {
        this.tenNguoiBan = tenNguoiBan;
    }

    public String getAvtShop() {
        return avtShop;
    }

    public void setAvtShop(String avtShop) {
        this.avtShop = avtShop;
    }

    public Integer getGiaSp() {
        return giaSp;
    }

    public void setGiaSp(Integer giaSp) {
        this.giaSp = giaSp;
    }

    public String getMotaSp() {
        return motaSp;
    }

    public void setMotaSp(String motaSp) {
        this.motaSp = motaSp;
    }

    public Integer getGiamgia() {
        return giamgia;
    }

    public void setGiamgia(Integer giamgia) {
        this.giamgia = giamgia;
    }

    public Integer getNumberBought() {
        return numberBought;
    }

    public void setNumberBought(Integer numberBought) {
        this.numberBought = numberBought;
    }

    public Set<String> getListAnhMoTa() {
        return listAnhMoTa;
    }

    public void setListAnhMoTa(Set<String> listAnhMoTa) {
        this.listAnhMoTa = listAnhMoTa;
    }

    public Integer getTotalProduct() {
        return totalProduct;
    }

    public void setTotalProduct(Integer totalProduct) {
        this.totalProduct = totalProduct;
    }

    public Integer getMaNguoiBan() {
        return maNguoiBan;
    }

    public void setMaNguoiBan(Integer maNguoiBan) {
        this.maNguoiBan = maNguoiBan;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
