package com.example.ShopBackEnd.dto.request;

public class CartRequest {
    private Integer maNguoiBan;
    private String maND;

    public CartRequest() {
    }

    public CartRequest(Integer maNguoiBan, String maND) {
        this.maNguoiBan = maNguoiBan;
        this.maND = maND;
    }

    public Integer getMaNguoiBan() {
        return maNguoiBan;
    }

    public void setMaNguoiBan(Integer maNguoiBan) {
        this.maNguoiBan = maNguoiBan;
    }

    public String getMaND() {
        return maND;
    }

    public void setMaND(String maND) {
        this.maND = maND;
    }
}
