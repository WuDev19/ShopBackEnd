package com.example.ShopBackEnd.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "Sanpham")
public class Sanpham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maSp")
    private Integer maSp;

    @NotNull
    @Min(0)
    @Column(name = "giaSp", columnDefinition = "check (giaSp >= 0)")
    private Integer giaSp;

    @NotNull
    @Size(max = 200)
    @Column(name = "motaSp", nullable = false, length = 200)
    private String motaSp;

    @Size(max = 100)
    @Column(name = "thumbnail", length = 100)
    private String thumbnail;

    @Column(name = "giamgia")
    private Integer giamgia;

    @Column(name = "numberBought", insertable = false)
    private Integer numberBought;

    @Column(name = "rating", insertable = false)
    private Integer rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maNguoiBan", referencedColumnName = "maNguoiBan")
    @JsonBackReference("nb-sp")
    private Nguoiban nguoiban;

    @OneToMany(mappedBy = "sanpham", cascade = CascadeType.ALL)
    @JsonManagedReference("sanpham_chitiet")
    private Set<SanPhamChiTiet> sanPhamChiTiets;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "danhmuc_sanpham",
            joinColumns = @JoinColumn(name = "maSp"),
            inverseJoinColumns = @JoinColumn(name = "maDanhMuc"))
    @JsonBackReference
    private Set<DanhMuc> danhMucSanPham;

    @OneToMany(mappedBy = "anhSanPhamMoTa", cascade = CascadeType.ALL)
    @JsonManagedReference("sp_anhmota")
    private Set<AnhMoTaSanPham> images;

    public Sanpham() {
    }

    public Sanpham(Integer giaSp, String motaSp, String thumbnail, Integer giamgia, Integer numberBought, Integer rating) {
        this.giaSp = giaSp;
        this.motaSp = motaSp;
        this.thumbnail = thumbnail;
        this.giamgia = giamgia;
        this.numberBought = numberBought;
        this.rating = rating;
    }

    public Integer getMaSp() {
        return maSp;
    }

    public void setMaSp(Integer maSp) {
        this.maSp = maSp;
    }

    public Integer getGiaSp() {
        return giaSp;
    }

    public void setGiaSp(Integer giaSp) {
        this.giaSp = giaSp;
    }

    public String getMotaSp() {
        return motaSp;
    }

    public void setMotaSp(String motaSp) {
        this.motaSp = motaSp;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getGiamgia() {
        return giamgia;
    }

    public void setGiamgia(Integer giamgia) {
        this.giamgia = giamgia;
    }

    public Nguoiban getNguoiban() {
        return nguoiban;
    }

    public void setNguoiban(Nguoiban nguoiban) {
        this.nguoiban = nguoiban;
    }

    public Integer getNumberBought() {
        return numberBought;
    }

    public void setNumberBought(Integer numberBought) {
        this.numberBought = numberBought;
    }

    public Set<SanPhamChiTiet> getSanPhamChiTiets() {
        return sanPhamChiTiets;
    }

    public void setSanPhamChiTiets(Set<SanPhamChiTiet> sanPhamChiTiets) {
        this.sanPhamChiTiets = sanPhamChiTiets;
    }

    public Set<DanhMuc> getDanhMucSanPham() {
        return danhMucSanPham;
    }

    public void setDanhMucSanPham(Set<DanhMuc> danhMucSanPham) {
        this.danhMucSanPham = danhMucSanPham;
    }

    public Set<AnhMoTaSanPham> getImages() {
        return images;
    }

    public void setImages(Set<AnhMoTaSanPham> images) {
        this.images = images;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
