package com.example.ShopBackEnd.dto.request;

public class DiaChiRequest {

    private String tenCuThe;
    private String tenXa;
    private String tenHuyen;
    private String tenThanhPho;
    private String quocGia;

    public DiaChiRequest() {
    }

    public DiaChiRequest(String tenCuThe, String tenXa, String tenHuyen, String tenThanhPho, String quocGia) {
        this.tenCuThe = tenCuThe;
        this.tenXa = tenXa;
        this.tenHuyen = tenHuyen;
        this.tenThanhPho = tenThanhPho;
        this.quocGia = quocGia;
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
