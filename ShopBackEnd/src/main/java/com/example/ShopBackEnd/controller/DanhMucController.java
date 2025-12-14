package com.example.ShopBackEnd.controller;

import com.example.ShopBackEnd.service.impl.DanhMucServiceImpl;
import com.example.ShopBackEnd.service.inter.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/danhmuc")
public class DanhMucController {

    @Autowired
    private DanhMucService danhMucService;

    @GetMapping("tenVaSl/{id}")
    public ResponseEntity<?> getTenDanhMucVaSoLuong(@PathVariable Integer id){
        return ResponseEntity.ok(danhMucService.getTenDanhMucVaSoLuong(id));
    }

}
