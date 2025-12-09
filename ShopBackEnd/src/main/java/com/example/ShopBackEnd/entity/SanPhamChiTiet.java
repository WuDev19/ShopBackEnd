package com.example.ShopBackEnd.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "SanPhamChiTiet")
public class SanPhamChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maSanPhamDetail")
    private Integer maSanPhamDeTail;

    @Size(max = 50, message = "Khong duoc vuot qua 50")
    @Column(name = "tenDetail", length = 50)
    private String tenDetail;

    @NotNull(message = "Nhap so luong ban dau")
    @Min(1)
    @Column(name = "inStock", nullable = false)
    private Integer inStock;

    @NotNull
    @Size(max = 100)
    @Column(name = "anhDetail", length = 100, nullable = false)
    private String anhDetail;

    @NotNull
    @Min(1)
    @Column(name = "unitPrice", nullable = false)
    private Integer unitPrice;

    @Size(max = 25)
    @Column(name = "color", length = 25)
    private String color;

    @Size(max = 25)
    @Column(name = "kichco", length = 25)
    private String kichco;

    @ManyToOne(fetch = FetchType.LAZY) //khi nao bam vao thi moi query masp
    @JoinColumn(name = "maSp", referencedColumnName = "maSp")
    @JsonBackReference("sanpham_chitiet")
    private Sanpham sanpham;

    @OneToMany(mappedBy = "spDH", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonBackReference("spct_dh")
    private Set<DonHang> donHangs;

    @OneToMany(mappedBy = "ci_spct", cascade = {CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<CartItem> cartItems;

    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(Integer maSanPhamDeTail, String tenDetail, Integer inStock, String anhDetail, Integer unitPrice, String color, String kichco, Sanpham sanpham, Set<DonHang> donHangs, Set<CartItem> cartItems) {
        this.maSanPhamDeTail = maSanPhamDeTail;
        this.tenDetail = tenDetail;
        this.inStock = inStock;
        this.anhDetail = anhDetail;
        this.unitPrice = unitPrice;
        this.color = color;
        this.kichco = kichco;
        this.sanpham = sanpham;
        this.donHangs = donHangs;
        this.cartItems = cartItems;
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

    public Sanpham getSanpham() {
        return sanpham;
    }

    public void setSanpham(Sanpham sanpham) {
        this.sanpham = sanpham;
    }

    public Set<DonHang> getDonHangs() {
        return donHangs;
    }

    public void setDonHangs(Set<DonHang> donHangs) {
        this.donHangs = donHangs;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void addCartItem(CartItem cartItem){
        cartItem.setCi_spct(this);
        cartItems.add(cartItem);
    }

}
