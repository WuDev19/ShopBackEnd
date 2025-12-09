package com.example.ShopBackEnd.dto.get;

import com.example.ShopBackEnd.dto.get.sanpham.SanPhamDTO;

import java.util.Set;

public class NguoiBanDTO {
    private Integer maNguoiBan;
    private String tenShop;
    private String sdtNguoiBan;
    private String avtShop;
    private DiaChiDTO diaChi;
    private Set<SanPhamDTO> sanphams;

    public NguoiBanDTO() {
    }

    public NguoiBanDTO(Integer maNguoiBan, String tenShop, String sdtNguoiBan, String avtShop, DiaChiDTO diaChi, Set<SanPhamDTO> sanphams) {
        this.maNguoiBan = maNguoiBan;
        this.tenShop = tenShop;
        this.sdtNguoiBan = sdtNguoiBan;
        this.avtShop = avtShop;
        this.diaChi = diaChi;
        this.sanphams = sanphams;
    }

    public Integer getMaNguoiBan() {
        return maNguoiBan;
    }

    public void setMaNguoiBan(Integer maNguoiBan) {
        this.maNguoiBan = maNguoiBan;
    }

    public String getTenShop() {
        return tenShop;
    }

    public void setTenShop(String tenShop) {
        this.tenShop = tenShop;
    }

    public String getSdtNguoiBan() {
        return sdtNguoiBan;
    }

    public void setSdtNguoiBan(String sdtNguoiBan) {
        this.sdtNguoiBan = sdtNguoiBan;
    }

    public DiaChiDTO getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(DiaChiDTO diaChi) {
        this.diaChi = diaChi;
    }

    public Set<SanPhamDTO> getSanphams() {
        return sanphams;
    }

    public void setSanphams(Set<SanPhamDTO> sanphams) {
        this.sanphams = sanphams;
    }

    public String getAvtShop() {
        return avtShop;
    }

    public void setAvtShop(String avtShop) {
        this.avtShop = avtShop;
    }

}
