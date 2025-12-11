package com.example.ShopBackEnd.controller;

import com.example.ShopBackEnd.dto.get.NguoiDungDTO;
import com.example.ShopBackEnd.dto.request.UserCreateDTO;
import com.example.ShopBackEnd.dto.request.UserUpdateDTO;
import com.example.ShopBackEnd.entity.Nguoidung;
import com.example.ShopBackEnd.service.NguoiDungService;
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
    public ResponseEntity<?> taoNguoiDung(@RequestBody UserCreateDTO userCreateDTO) {
        Nguoidung nguoidung = new Nguoidung();
        nguoidung.setMaND(userCreateDTO.getMaND());
        nguoidung.setTen(userCreateDTO.getTen());
        nguoidung.setEmail(userCreateDTO.getEmail());
        nguoidung.setSdt(userCreateDTO.getSdt());
        nguoidung.setAnhdaidien(userCreateDTO.getAnhdaidien());
        Nguoidung nguoiDungResponse = service.taoNguoiDung(nguoidung);
        if (nguoiDungResponse == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can not create user");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(nguoiDungResponse);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<NguoiDungDTO> getNguoiDungTheoId(@PathVariable("id") String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/update/name")
    public ResponseEntity<?> updateNameGenderUser(@RequestBody UserUpdateDTO userUpdateDTO){
        return ResponseEntity.ok(service.updateNameGenderUser(userUpdateDTO));
    }

}
