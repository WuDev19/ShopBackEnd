package com.example.ShopBackEnd.dto.get;

import com.example.ShopBackEnd.entity.DiaChi;

import java.util.Set;

public class NguoiDungDTO {
    private String maND;
    private String ten;
    private String email;
    private String sdt;
    private String gioitinh;
    private String anhdaidien;
    private Set<DiaChiDTO> listDiaChi;

    public NguoiDungDTO(String maND, String ten, String email, String sdt, String gioitinh, String anhdaidien, Set<DiaChiDTO> listDiaChi) {
        this.maND = maND;
        this.ten = ten;
        this.email = email;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
        this.anhdaidien = anhdaidien;
        this.listDiaChi = listDiaChi;
    }

    public NguoiDungDTO() {
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

    public Set<DiaChiDTO> getListDiaChi() {
        return listDiaChi;
    }

    public void setListDiaChi(Set<DiaChiDTO> listDiaChi) {
        this.listDiaChi = listDiaChi;
    }
}
