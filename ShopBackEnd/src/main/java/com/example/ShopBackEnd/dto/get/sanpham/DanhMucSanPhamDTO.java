package com.example.ShopBackEnd.dto.get.sanpham;

public class DanhMucSanPhamDTO {
    private Integer maSp;
    private String tenNguoiBan;
    private Integer giaSp;
    private String motaSp;
    private String thumbnail;
    private Integer giamgia;
    private Integer numberBought;
    private Integer maNguoiBan;
    private String tenDanhMuc;

    public DanhMucSanPhamDTO() {

    }

    public DanhMucSanPhamDTO(Integer maSp, String tenNguoiBan, Integer giaSp, String motaSp, String thumbnail, Integer giamgia, Integer numberBought, Integer maNguoiBan, String tenDanhMuc) {
        this.maSp = maSp;
        this.tenNguoiBan = tenNguoiBan;
        this.giaSp = giaSp;
        this.motaSp = motaSp;
        this.thumbnail = thumbnail;
        this.giamgia = giamgia;
        this.numberBought = numberBought;
        this.maNguoiBan = maNguoiBan;
        this.tenDanhMuc = tenDanhMuc;
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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
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

    public Integer getMaNguoiBan() {
        return maNguoiBan;
    }

    public void setMaNguoiBan(Integer maNguoiBan) {
        this.maNguoiBan = maNguoiBan;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }
}
