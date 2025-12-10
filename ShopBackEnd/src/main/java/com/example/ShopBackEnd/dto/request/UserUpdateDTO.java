package com.example.ShopBackEnd.dto.request;

import com.example.ShopBackEnd.dto.UserBaseDTO;

public class UserUpdateDTO extends UserBaseDTO {

    private String gioitinh;

    public UserUpdateDTO(String maND, String ten, String email, String sdt, String anhdaidien, String gioitinh) {
        super(maND, ten, email, sdt, anhdaidien);
        this.gioitinh = gioitinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

}
