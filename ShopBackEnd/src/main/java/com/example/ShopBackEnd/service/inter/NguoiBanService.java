package com.example.ShopBackEnd.service.inter;

import com.example.ShopBackEnd.dto.get.NguoiBanDTO;
import com.example.ShopBackEnd.entity.Nguoiban;

import java.util.Map;

public interface NguoiBanService {

    NguoiBanDTO findById(Integer id);
    Nguoiban taoNguoiBan(Nguoiban nguoiban, String idNguoiDung);
    Map<String, Object> getNguoiBan(int pageNumber);

}
