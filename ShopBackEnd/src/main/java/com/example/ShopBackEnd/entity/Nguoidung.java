package com.example.ShopBackEnd.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "Nguoidung")
public class Nguoidung {

    @Id
    @Column(name = "maND", length = 30)
    private String maND;

    @NotNull(message = "Tên không được để trống")
    @Size(max = 25, message = "Tên không được vượt quá 25 ký tự")
    @Column(name = "ten", length = 25, nullable = false)
    private String ten;

    @Email(message = "Email không hợp lệ")
    @NotNull(message = "Email không được để trống")
    @Size(max = 50, message = "Email không được vượt quá 50 ký tự")
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "sdt", length = 10)
    @Size(min = 10, max = 10, message = "Sdt phải có 10 chữ số")
    private String sdt;

    @Column(name = "gioitinh", length = 6, insertable = false)
    @Pattern(regexp = "^(Male|Female|ND)$", message = "Chỉ có thể là male hoặc female")
    @Size(max = 6, message = "Giới tính không được vượt quá 6 ký tự")
    private String gioitinh;

    @Column(name = "anhdaidien", length = 100)
    @Size(max = 100, message = "Ảnh đại diện không được vượt quá 100 ký tự")
    private String anhdaidien;

    @OneToOne(mappedBy = "nguoidung", cascade = CascadeType.ALL)
    @JsonManagedReference("nb-nd")
    private Nguoiban nguoiban;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Nguoidung_Diachi",
            joinColumns = @JoinColumn(name = "maND"),
            inverseJoinColumns = @JoinColumn(name = "maDiaChi"))
    @JsonManagedReference("nguoidung-diachi")
    private Set<DiaChi> listDiaChi;

    @OneToMany(mappedBy = "ndDh", fetch = FetchType.LAZY) //ko co cascade vi neu da len don hang xac nhan roi thi neu co xoa nguoi dung thi don hang van se giao
    @JsonBackReference("nd_dh")
    private Set<DonHang> donHangs;

    @OneToMany(mappedBy = "nd_gh", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<GioHang> gioHangs;

    public Nguoidung() {
    }

    public Nguoidung(String maND, String ten, String email, String sdt, String gioitinh, String anhdaidien) {
        this.maND = maND;
        this.ten = ten;
        this.email = email;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
        this.anhdaidien = anhdaidien;
    }

    public String getMaND() {
        return maND;
    }

    public void setMaND(String maND) {
        this.maND = maND;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getAnhdaidien() {
        return anhdaidien;
    }

    public void setAnhdaidien(String anhdaidien) {
        this.anhdaidien = anhdaidien;
    }

    public Nguoiban getNguoiban() {
        return nguoiban;
    }

    public void setNguoiban(Nguoiban nguoiban) {
        this.nguoiban = nguoiban;
    }

    public Set<DiaChi> getListDiaChi() {
        return listDiaChi;
    }

    public void setListDiaChi(Set<DiaChi> listDiaChi) {
        this.listDiaChi = listDiaChi;
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

    public void registerSeller(Nguoiban nguoiban) {
        this.nguoiban = nguoiban;
        nguoiban.setNguoidung(this);
    }

    public void unregisterSeller(Nguoiban nguoiban) {
        this.nguoiban = null;
        nguoiban.setNguoidung(null);
    }

    public void addGioHang(GioHang gioHang){
        gioHang.setNd_gh(this);
        gioHangs.add(gioHang);
    }

}
