package com.example.ShopBackEnd.dto;

public class UserBaseDTO {
    protected String maND;
    protected String ten;
    protected String email;
    protected String sdt;
    protected String anhdaidien;

    public UserBaseDTO(String maND, String ten, String email, String sdt, String anhdaidien) {
        this.maND = maND;
        this.ten = ten;
        this.email = email;
        this.sdt = sdt;
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

    public String getAnhdaidien() {
        return anhdaidien;
    }

    public void setAnhdaidien(String anhdaidien) {
        this.anhdaidien = anhdaidien;
    }
}
