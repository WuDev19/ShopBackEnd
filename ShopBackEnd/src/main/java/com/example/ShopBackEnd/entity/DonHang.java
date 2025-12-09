package com.example.ShopBackEnd.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "DonHang")
public class DonHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maDonHang")
    private Integer maDonHang;

    @ManyToOne
    @JoinColumn(name = "maSanPhamDetail", referencedColumnName = "maSanPhamDetail")
    @JsonManagedReference("spct_dh")
    private SanPhamChiTiet spDH;

    @ManyToOne
    @JoinColumn(name = "maND", referencedColumnName = "maND")
    @JsonManagedReference("nd_dh")
    private Nguoidung ndDh;

    @ManyToOne
    @JoinColumn(name = "maNguoiBan", referencedColumnName = "maNguoiBan")
    @JsonManagedReference("nb_dh")
    private Nguoiban nbDh;

    @NotNull
    @Size(max = 300)
    @Column(name = "diachi", length = 300, nullable = false)
    private String diachi;

    @NotNull
    @Min(1)
    @Column(name = "tongTien", nullable = false)
    private Integer tongTien;

    @NotNull
    @Min(1)
    @Column(name = "soluong", nullable = false)
    private  Integer soluong;

    @OneToOne
    @JoinColumn(name = "maChitietDh", referencedColumnName = "maChitietDh")
    @JsonManagedReference("dh_ctdh")
    private ChitietDonhang chitietDonhang;

    public DonHang(Integer maDonHang, SanPhamChiTiet spDH, Nguoidung ndDh, Nguoiban nbDh, String diachi, Integer tongTien, Integer soluong, ChitietDonhang chitietDonhang) {
        this.maDonHang = maDonHang;
        this.spDH = spDH;
        this.ndDh = ndDh;
        this.nbDh = nbDh;
        this.diachi = diachi;
        this.tongTien = tongTien;
        this.soluong = soluong;
        this.chitietDonhang = chitietDonhang;
    }

    public Integer getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(Integer maDonHang) {
        this.maDonHang = maDonHang;
    }

    public SanPhamChiTiet getSpDH() {
        return spDH;
    }

    public void setSpDH(SanPhamChiTiet spDH) {
        this.spDH = spDH;
    }

    public Nguoidung getNdDh() {
        return ndDh;
    }

    public void setNdDh(Nguoidung ndDh) {
        this.ndDh = ndDh;
    }

    public Nguoiban getNbDh() {
        return nbDh;
    }

    public void setNbDh(Nguoiban nbDh) {
        this.nbDh = nbDh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Integer getTongTien() {
        return tongTien;
    }

    public void setTongTien(Integer tongTien) {
        this.tongTien = tongTien;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public ChitietDonhang getChitietDonhang() {
        return chitietDonhang;
    }

    public void setChitietDonhang(ChitietDonhang chitietDonhang) {
        this.chitietDonhang = chitietDonhang;
    }
}
