package com.example.ShopBackEnd.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "DanhMuc")
public class DanhMuc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maDanhMuc")
    private Integer maDanhMuc;

    @NotNull
    @Size(max = 50)
    @Column(name = "tenDanhMuc", length = 50, nullable = false, unique = true)
    private String tenDanhMuc;

    @ManyToMany(mappedBy = "danhMucSanPham") //call co san pham luon
    @JsonManagedReference
    private Set<Sanpham> sanphams;

    public DanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public DanhMuc() {
    }

    public Integer getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(Integer maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public Set<Sanpham> getSanphams() {
        return sanphams;
    }

    public void setSanphams(Set<Sanpham> sanphams) {
        this.sanphams = sanphams;
    }
}
