package com.example.ShopBackEnd.mapper;

import com.example.ShopBackEnd.dto.request.DiaChiRequest;
import com.example.ShopBackEnd.entity.DiaChi;

public class DiaChiMapper {

    private DiaChiMapper() {
    }

    public static DiaChi mapToDiaChi(DiaChiRequest diaChiRequest) {
        return new DiaChi(
                diaChiRequest.getTenCuThe(),
                diaChiRequest.getTenXa(),
                diaChiRequest.getTenHuyen(),
                diaChiRequest.getTenThanhPho(),
                diaChiRequest.getQuocGia()
        );
    }

}
