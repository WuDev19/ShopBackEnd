package com.example.ShopBackEnd.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "Nguoiban")
public class Nguoiban {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maNguoiBan")
    private Integer maNguoiBan;

    @Size(max = 50, message = "Không được vượt quá 50 kí tự")
    @NotNull
    @Column(name = "tenShop", length = 50, nullable = false)
    private String tenShop;

    @NotNull(message = "Số điện thoại không được để trống")
    @Size(min = 10, max = 10, message = "Số điện thoại phải đúng 10 kí tự")
    @Column(name = "sdtNguoiBan", length = 10, nullable = false)
    private String sdtNguoiBan;

    @Size(max = 100)
    @Column(name = "avtShop", length = 100)
    private String avtShop;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maND", referencedColumnName = "maND")
    @JsonBackReference("nb-nd")
    private Nguoidung nguoidung;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference("nguoiban-diachi")
    @JoinColumn(name = "maDiaChi", referencedColumnName = "maDiaChi")
    private DiaChi diaChi;

    @OneToMany(mappedBy = "nguoiban", cascade = CascadeType.ALL)
    @JsonManagedReference("nb-sp")
    private Set<Sanpham> sanphams;

    @OneToMany(mappedBy = "nbDh", fetch = FetchType.LAZY)
    @JsonBackReference("nb_dh")
    private Set<DonHang> donHangs;

    @OneToMany(mappedBy = "nb_gh", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<GioHang> gioHangs;

    public Nguoiban(Integer maNguoiBan, String tenShop, String sdtNguoiBan, String avtShop, Nguoidung nguoidung, DiaChi diaChi, Set<Sanpham> sanphams, Set<DonHang> donHangs, Set<GioHang> gioHangs) {
        this.maNguoiBan = maNguoiBan;
        this.tenShop = tenShop;
        this.sdtNguoiBan = sdtNguoiBan;
        this.avtShop = avtShop;
        this.nguoidung = nguoidung;
        this.diaChi = diaChi;
        this.sanphams = sanphams;
        this.donHangs = donHangs;
        this.gioHangs = gioHangs;
    }

    public Nguoiban() {
    }

    public Nguoidung getNguoidung() {
        return nguoidung;
    }

    public void setNguoidung(Nguoidung nguoidung) {
        this.nguoidung = nguoidung;
    }

    public String getTenShop() {
        return tenShop;
    }

    public void setTenShop(String tenShop) {
        this.tenShop = tenShop;
    }

    public Set<Sanpham> getSanphams() {
        return sanphams;
    }

    public void setSanphams(Set<Sanpham> sanphams) {
        this.sanphams = sanphams;
    }

    public Integer getMaNguoiBan() {
        return maNguoiBan;
    }

    public void setMaNguoiBan(Integer maNguoiBan) {
        this.maNguoiBan = maNguoiBan;
    }

    public String getSdtNguoiBan() {
        return sdtNguoiBan;
    }

    public void setSdtNguoiBan(String sdtNguoiBan) {
        this.sdtNguoiBan = sdtNguoiBan;
    }

    public DiaChi getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(DiaChi diaChi) {
        this.diaChi = diaChi;
    }

    public String getAvtShop() {
        return avtShop;
    }

    public void setAvtShop(String avtShop) {
        this.avtShop = avtShop;
    }

    public Set<DonHang> getDonHangs() {
        return donHangs;
    }

    public void setDonHangs(Set<DonHang> donHangs) {
        this.donHangs = donHangs;
    }

    public Set<GioHang> getGioHangs() {
        return gioHangs;
    }

    public void setGioHangs(Set<GioHang> gioHangs) {
        this.gioHangs = gioHangs;
    }

    public void addSanPham(Sanpham sanpham){
        sanphams.add(sanpham);
        sanpham.setNguoiban(this);
    }

    public void removeEmployee(Sanpham sanpham) {
        sanphams.remove(sanpham);
        sanpham.setNguoiban(null);
    }

    public void addGioHang(GioHang gioHang){
        gioHang.setNb_gh(this);
        gioHangs.add(gioHang);
    }

}
