package com.example.ShopBackEnd.dto.get;

public class DiaChiDTO {
    private Integer maDiaChi;
    private String tenCuThe;
    private String tenXa;
    private String tenHuyen;
    private String tenThanhPho;
    private String quocGia;

    public DiaChiDTO() {
    }

    public DiaChiDTO(Integer maDiaChi, String tenCuThe, String tenXa, String tenHuyen, String tenThanhPho, String quocGia) {
        this.maDiaChi = maDiaChi;
        this.tenCuThe = tenCuThe;
        this.tenXa = tenXa;
        this.tenHuyen = tenHuyen;
        this.tenThanhPho = tenThanhPho;
        this.quocGia = quocGia;
    }

    public Integer getMaDiaChi() {
        return maDiaChi;
    }

    public void setMaDiaChi(Integer maDiaChi) {
        this.maDiaChi = maDiaChi;
    }

    public String getTenCuThe() {
        return tenCuThe;
    }

    public void setTenCuThe(String tenCuThe) {
        this.tenCuThe = tenCuThe;
    }

    public String getTenXa() {
        return tenXa;
    }

    public void setTenXa(String tenXa) {
        this.tenXa = tenXa;
    }

    public String getTenHuyen() {
        return tenHuyen;
    }

    public void setTenHuyen(String tenHuyen) {
        this.tenHuyen = tenHuyen;
    }

    public String getTenThanhPho() {
        return tenThanhPho;
    }

    public void setTenThanhPho(String tenThanhPho) {
        this.tenThanhPho = tenThanhPho;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }
}
