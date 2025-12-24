package com.example.ShopBackEnd.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Diachi")
public class DiaChi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maDiaChi")
    private Integer maDiaChi;

    @Size(max = 100, message = "Không được vượt quá 100 kí tụ")
    @Column(name = "tenCuThe", length = 100)
    private String tenCuThe;

    @Size(max = 50)
    @Column(name = "tenXa", length = 50)
    private String tenXa;

    @Size(max = 50)
    @Column(name = "tenHuyen", length = 50)
    private String tenHuyen;

    @Size(max = 50)
    @Column(name = "tenThanhPho", length = 50)
    private String tenThanhPho;

    @Size(max = 50)
    @Column(name = "quocGia", length = 50)
    private String quocGia;

    @OneToOne(mappedBy = "diaChi", fetch = FetchType.LAZY)
    @JsonBackReference("nguoiban-diachi")
    private Nguoiban nguoiban;

    @ManyToMany(mappedBy = "listDiaChi", fetch = FetchType.LAZY)
    @JsonBackReference("nguoidung-diachi")
    private Set<Nguoidung> listNguoiDung = new HashSet<>();

    public DiaChi(String tenCuThe, String tenXa, String tenHuyen, String tenThanhPho, String quocGia) {
        this.tenCuThe = tenCuThe;
        this.tenXa = tenXa;
        this.tenHuyen = tenHuyen;
        this.tenThanhPho = tenThanhPho;
        this.quocGia = quocGia;
    }

    public DiaChi() {
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

    public Nguoiban getNguoiban() {
        return nguoiban;
    }

    public void setNguoiban(Nguoiban nguoiban) {
        this.nguoiban = nguoiban;
    }

    public Set<Nguoidung> getListNguoiDung() {
        return listNguoiDung;
    }

    public void setListNguoiDung(Set<Nguoidung> listNguoiDung) {
        this.listNguoiDung = listNguoiDung;
    }

}
