package com.example.ShopBackEnd.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "ChitietDonhang")
public class ChitietDonhang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maChitietDh")
    private Integer maChitietDh;

    @ManyToOne
    @JoinColumn(name = "statusId", referencedColumnName = "statusId")
    @JsonManagedReference
    private StatusOrder statusOrder;

    @ManyToOne
    @JoinColumn(name = "maPttt", referencedColumnName = "maPttt")
    @JsonManagedReference
    private PthucThanhToan pthucThanhToan;

    @NotNull
    @Column(name = "ngayDat", nullable = false, insertable = false)
    private LocalDateTime ngayDat;

    @NotNull
    @Column(name = "ngayDuKienToi", nullable = false)
    private LocalDate ngayDuKienToi;

    @OneToOne(mappedBy = "chitietDonhang", fetch = FetchType.LAZY)
    @JsonBackReference("dh_ctdh")
    private DonHang donHang;

    public ChitietDonhang() {
    }

    public ChitietDonhang(Integer maChitietDh, StatusOrder statusOrder, PthucThanhToan pthucThanhToan, LocalDateTime ngayDat, LocalDate ngayDuKienToi, DonHang donHang) {
        this.maChitietDh = maChitietDh;
        this.statusOrder = statusOrder;
        this.pthucThanhToan = pthucThanhToan;
        this.ngayDat = ngayDat;
        this.ngayDuKienToi = ngayDuKienToi;
        this.donHang = donHang;
    }

    public Integer getMaChitietDh() {
        return maChitietDh;
    }

    public void setMaChitietDh(Integer maChitietDh) {
        this.maChitietDh = maChitietDh;
    }

    public StatusOrder getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(StatusOrder statusOrder) {
        this.statusOrder = statusOrder;
    }

    public PthucThanhToan getPthucThanhToan() {
        return pthucThanhToan;
    }

    public void setPthucThanhToan(PthucThanhToan pthucThanhToan) {
        this.pthucThanhToan = pthucThanhToan;
    }

    public LocalDateTime getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(LocalDateTime ngayDat) {
        this.ngayDat = ngayDat;
    }

    public LocalDate getNgayDuKienToi() {
        return ngayDuKienToi;
    }

    public void setNgayDuKienToi(LocalDate ngayDuKienToi) {
        this.ngayDuKienToi = ngayDuKienToi;
    }

    public DonHang getDonHang() {
        return donHang;
    }

    public void setDonHang(DonHang donHang) {
        this.donHang = donHang;
    }
}
