package com.example.ShopBackEnd.controller;

import com.example.ShopBackEnd.dto.get.NguoiDungDTO;
import com.example.ShopBackEnd.dto.request.UserCreateDTO;
import com.example.ShopBackEnd.dto.request.UserUpdateDTO;
import com.example.ShopBackEnd.service.inter.NguoiDungService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class NguoiDungController {

    private final NguoiDungService nguoiDungService;

    public NguoiDungController(NguoiDungService nguoiDungService){
        this.nguoiDungService = nguoiDungService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> taoNguoiDung(@RequestBody UserCreateDTO userCreateDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(nguoiDungService.taoNguoiDung(userCreateDTO));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<NguoiDungDTO> getNguoiDungTheoId(@PathVariable("id") String id) {
        return ResponseEntity.ok(nguoiDungService.findById(id));
    }

    @PatchMapping("/update/name/gender")
    public ResponseEntity<?> updateNameGender(@RequestBody UserUpdateDTO userUpdateDTO){
        return ResponseEntity.ok(nguoiDungService.updateNameGender(userUpdateDTO));
    }

    @PatchMapping("/update/phone/{id}")
    public ResponseEntity<?> updatePhone(@PathVariable String id, @RequestParam String phone){
        return ResponseEntity.ok(nguoiDungService.updatePhone(id, phone));
    }

    @PatchMapping("/update/email/{id}")
    public ResponseEntity<?> updateEmail(@PathVariable String id, @RequestParam String email){
        return ResponseEntity.ok(nguoiDungService.updateEmail(id, email));
    }

    @PatchMapping("/update/avt/{id}")
    public ResponseEntity<?> updateAvatar(@PathVariable String id, @RequestParam String url){
        return ResponseEntity.ok(nguoiDungService.updateAvatar(id, url));
    }

}
