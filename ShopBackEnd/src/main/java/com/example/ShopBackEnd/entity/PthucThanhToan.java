package com.example.ShopBackEnd.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "PthucThanhToan")
public class PthucThanhToan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maPttt")
    private Integer maPttt;

    @NotNull
    @Size(max = 50)
    @Column(name = "tenPttt", length = 50, nullable = false, unique = true)
    private String tenPttt;

    @OneToMany(mappedBy = "pthucThanhToan", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<ChitietDonhang> chitietDonhangs;

    public PthucThanhToan(Integer maPttt, String tenPttt, Set<ChitietDonhang> chitietDonhangs) {
        this.maPttt = maPttt;
        this.tenPttt = tenPttt;
        this.chitietDonhangs = chitietDonhangs;
    }

    public PthucThanhToan() {
    }

    public Integer getMaPttt() {
        return maPttt;
    }

    public void setMaPttt(Integer maPttt) {
        this.maPttt = maPttt;
    }

    public String getTenPttt() {
        return tenPttt;
    }

    public void setTenPttt(String tenPttt) {
        this.tenPttt = tenPttt;
    }

    public Set<ChitietDonhang> getChitietDonhangs() {
        return chitietDonhangs;
    }

    public void setChitietDonhangs(Set<ChitietDonhang> chitietDonhangs) {
        this.chitietDonhangs = chitietDonhangs;
    }
}
