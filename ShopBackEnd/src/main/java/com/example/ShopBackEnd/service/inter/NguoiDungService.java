package com.example.ShopBackEnd.service.inter;

import com.example.ShopBackEnd.dto.get.NguoiDungDTO;
import com.example.ShopBackEnd.dto.request.UserUpdateDTO;
import com.example.ShopBackEnd.entity.Nguoidung;

import java.util.Optional;

public interface NguoiDungService {

    Nguoidung taoNguoiDung(Nguoidung nd);

    Optional<NguoiDungDTO> findById(String id);

    Nguoidung updateNameGender(UserUpdateDTO userUpdateDTO);

    Nguoidung updatePhone(String id, String phone);

    Nguoidung updateEmail(String id, String email);
}
