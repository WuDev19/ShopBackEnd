package com.example.ShopBackEnd.service.inter;

import com.example.ShopBackEnd.dto.get.NguoiDungDTO;
import com.example.ShopBackEnd.dto.request.UserCreateDTO;
import com.example.ShopBackEnd.dto.request.UserUpdateDTO;
import com.example.ShopBackEnd.entity.Nguoidung;

public interface NguoiDungService {

    Nguoidung taoNguoiDung(UserCreateDTO userCreateDTO);

    NguoiDungDTO findById(String id);

    Nguoidung updateNameGender(UserUpdateDTO userUpdateDTO);

    Nguoidung updatePhone(String id, String phone);

    Nguoidung updateEmail(String id, String email);

    Nguoidung updateAvatar(String id, String urlAvatar);
}
