package com.example.ShopBackEnd.controller;

import com.example.ShopBackEnd.dto.get.NguoiDungDTO;
import com.example.ShopBackEnd.dto.request.UserRequestDTO;
import com.example.ShopBackEnd.entity.Nguoidung;
import com.example.ShopBackEnd.service.NguoiDungService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class NguoiDungController {

    @Autowired
    private NguoiDungService service;

    @PostMapping("/create")
    public ResponseEntity<?> taoNguoiDung(@RequestBody UserRequestDTO userRequestDTO) {
        Nguoidung nguoidung = new Nguoidung();
        nguoidung.setMaND(userRequestDTO.getMaND());
        nguoidung.setTen(userRequestDTO.getTen());
        nguoidung.setEmail(userRequestDTO.getEmail());
        nguoidung.setSdt(userRequestDTO.getSdt());
        nguoidung.setAnhdaidien(userRequestDTO.getAnhdaidien());
        Nguoidung nguoiDungResponse = service.taoNguoiDung(nguoidung);
        if(nguoiDungResponse == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can not create user");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(nguoiDungResponse);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<NguoiDungDTO> getNguoiDungTheoId(@PathVariable("id") String id) {
        NguoiDungDTO nguoiDungDTO = service.findById(id);
        if (nguoiDungDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(nguoiDungDTO);
    }

}
