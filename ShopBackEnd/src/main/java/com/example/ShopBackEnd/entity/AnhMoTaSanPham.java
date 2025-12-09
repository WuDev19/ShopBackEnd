package com.example.ShopBackEnd.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "AnhMoTaSanPham")
public class AnhMoTaSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maAnh")
    private Integer maAnh;

    @NotNull
    @Size(max = 100)
    @Column(name = "urlAnh", length = 100, nullable = false)
    private String urlAnh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maSp", referencedColumnName = "maSp")
    @JsonBackReference("sp_anhmota")
    private Sanpham anhSanPhamMoTa;

    public AnhMoTaSanPham() {
    }

    public AnhMoTaSanPham(String urlAnh) {
        this.urlAnh = urlAnh;
    }

    public Integer getMaAnh() {
        return maAnh;
    }

    public void setMaAnh(Integer maAnh) {
        this.maAnh = maAnh;
    }

    public String getUrlAnh() {
        return urlAnh;
    }

    public void setUrlAnh(String urlAnh) {
        this.urlAnh = urlAnh;
    }

    public Sanpham getSanpham() {
        return anhSanPhamMoTa;
    }

    public void setSanpham(Sanpham sanpham) {
        this.anhSanPhamMoTa = sanpham;
    }

}
