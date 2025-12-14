package com.example.ShopBackEnd.service.inter;

import com.example.ShopBackEnd.dto.projection.DanhMucProjection;

import java.util.List;

public interface DanhMucService {

    List<DanhMucProjection> getTenDanhMucVaSoLuong(Integer id);

}
