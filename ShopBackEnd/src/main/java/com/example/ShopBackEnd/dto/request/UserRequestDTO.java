package com.example.ShopBackEnd.dto.request;

public class UserRequestDTO {
    private String maND;
    private String ten;
    private String email;
    private String sdt;
    private String anhdaidien;

    public UserRequestDTO() {
    }

    public UserRequestDTO(String maND, String ten, String email, String sdt, String anhdaidien) {
        this.maND = maND;
        this.ten = ten;
        this.email = email;
        this.sdt = sdt;
        this.anhdaidien = anhdaidien;
    }

    public String getAnhdaidien() {
        return anhdaidien;
    }

    public void setAnhdaidien(String anhdaidien) {
        this.anhdaidien = anhdaidien;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMaND() {
        return maND;
    }

    public void setMaND(String maND) {
        this.maND = maND;
    }
}
