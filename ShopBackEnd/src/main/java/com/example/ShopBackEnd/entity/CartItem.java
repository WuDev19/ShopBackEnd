package com.example.ShopBackEnd.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "CartItem")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartItemId")
    private Integer cartItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maGioHang", referencedColumnName = "maGioHang")
    @JsonBackReference
    private GioHang ci_gh;

    @ManyToOne
    @JoinColumn(name = "maSanPhamDetail", referencedColumnName = "maSanPhamDetail")
    @JsonManagedReference
    private SanPhamChiTiet ci_spct;

    @NotNull
    @Min(1)
    @Column(name = "soluong")
    private Integer soLuong;

    @Column(name = "giamGia")
    private Integer giamGia;

    public CartItem() {
    }

    public CartItem(Integer cartItemId, GioHang ci_gh, SanPhamChiTiet ci_spct, Integer soLuong, Integer giamGia) {
        this.cartItemId = cartItemId;
        this.ci_gh = ci_gh;
        this.ci_spct = ci_spct;
        this.soLuong = soLuong;
        this.giamGia = giamGia;
    }

    public Integer getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }

    public GioHang getCi_gh() {
        return ci_gh;
    }

    public void setCi_gh(GioHang ci_gh) {
        this.ci_gh = ci_gh;
    }

    public SanPhamChiTiet getCi_spct() {
        return ci_spct;
    }

    public void setCi_spct(SanPhamChiTiet ci_spct) {
        this.ci_spct = ci_spct;
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
