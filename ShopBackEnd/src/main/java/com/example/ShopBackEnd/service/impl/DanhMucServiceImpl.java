package com.example.ShopBackEnd.service.impl;

import com.example.ShopBackEnd.dto.projection.DanhMucProjection;
import com.example.ShopBackEnd.repository.DanhMucRepository;
import com.example.ShopBackEnd.service.inter.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DanhMucServiceImpl implements DanhMucService {

    @Autowired
    private DanhMucRepository danhMucRepository;

    public List<DanhMucProjection> getTenDanhMucVaSoLuong(Integer id){
        return danhMucRepository.getTenDanhMucVaSoLuong(id);
    }

}
