package com.example.ShopBackEnd.controller;

import com.example.ShopBackEnd.dto.get.NguoiDungDTO;
import com.example.ShopBackEnd.dto.request.UserCreateDTO;
import com.example.ShopBackEnd.dto.request.UserUpdateDTO;
import com.example.ShopBackEnd.entity.Nguoidung;
import com.example.ShopBackEnd.service.inter.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class NguoiDungController {

    @Autowired
    private NguoiDungService nguoiDungService;

    @PostMapping("/create")
    public ResponseEntity<?> taoNguoiDung(@RequestBody UserCreateDTO userCreateDTO) {
        Nguoidung nguoidung = new Nguoidung();
        nguoidung.setMaND(userCreateDTO.getMaND());
        nguoidung.setTen(userCreateDTO.getTen());
        nguoidung.setEmail(userCreateDTO.getEmail());
        nguoidung.setSdt(userCreateDTO.getSdt());
        nguoidung.setAnhdaidien(userCreateDTO.getAnhdaidien());
        Nguoidung nguoiDungResponse = nguoiDungService.taoNguoiDung(nguoidung);
        if (nguoiDungResponse == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can not create user");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(nguoiDungResponse);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<NguoiDungDTO> getNguoiDungTheoId(@PathVariable("id") String id) {
        return nguoiDungService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/update/name/gender")
    public ResponseEntity<?> updateNameGender(@RequestBody UserUpdateDTO userUpdateDTO){
        return ResponseEntity.ok(nguoiDungService.updateNameGender(userUpdateDTO));
    }

    @PatchMapping("update/phone/{id}")
    public ResponseEntity<?> updatePhone(@PathVariable String id, @RequestParam String phone){
        return ResponseEntity.ok(nguoiDungService.updatePhone(id, phone));
    }

    @PatchMapping("update/email/{id}")
    public ResponseEntity<?> updateEmail(@PathVariable String id, @RequestParam String email){
        return ResponseEntity.ok(nguoiDungService.updateEmail(id, email));
    }

}
