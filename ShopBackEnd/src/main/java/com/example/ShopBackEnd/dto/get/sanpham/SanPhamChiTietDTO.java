package com.example.ShopBackEnd.dto.get.sanpham;

public class SanPhamChiTietDTO {
    private Integer maSanPhamDeTail;
    private String tenDetail;
    private Integer inStock;
    private String anhDetail;
    private Integer unitPrice;
    private String color;
    private String kichco;
    private Integer maSp;

    public SanPhamChiTietDTO() {
    }

    public SanPhamChiTietDTO(Integer maSanPhamDeTail, String tenDetail, Integer inStock, String anhDetail, Integer unitPrice, String color, String kichco, Integer maSp) {
        this.maSanPhamDeTail = maSanPhamDeTail;
        this.tenDetail = tenDetail;
        this.inStock = inStock;
        this.anhDetail = anhDetail;
        this.unitPrice = unitPrice;
        this.color = color;
        this.kichco = kichco;
        this.maSp = maSp;
    }

    public Integer getMaSanPhamDeTail() {
        return maSanPhamDeTail;
    }

    public void setMaSanPhamDeTail(Integer maSanPhamDeTail) {
        this.maSanPhamDeTail = maSanPhamDeTail;
    }

    public String getTenDetail() {
        return tenDetail;
    }

    public void setTenDetail(String tenDetail) {
        this.tenDetail = tenDetail;
    }

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }

    public String getAnhDetail() {
        return anhDetail;
    }

    public void setAnhDetail(String anhDetail) {
        this.anhDetail = anhDetail;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getKichco() {
        return kichco;
    }

    public void setKichco(String kichco) {
        this.kichco = kichco;
    }

    public Integer getMaSp() {
        return maSp;
    }

    public void setMaSp(Integer maSp) {
        this.maSp = maSp;
    }
}
