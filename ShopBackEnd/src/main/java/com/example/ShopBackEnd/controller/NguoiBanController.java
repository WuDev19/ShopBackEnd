package com.example.ShopBackEnd.controller;

import com.example.ShopBackEnd.dto.get.NguoiBanDTO;
import com.example.ShopBackEnd.entity.Nguoiban;
import com.example.ShopBackEnd.service.NguoiBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/seller")
public class NguoiBanController {

    @Autowired
    private NguoiBanService nguoiBanService;

    @GetMapping("/{id}")
    private ResponseEntity<NguoiBanDTO> findById(@PathVariable("id") Integer id){
        NguoiBanDTO nguoiBanDTO = nguoiBanService.findById(id);
        if(nguoiBanDTO == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(nguoiBanDTO);
    }

    @PostMapping("/create")
    private ResponseEntity<Nguoiban> dangKiNguoiBan(@Valid @RequestBody Nguoiban nguoiban, @RequestParam String idNguoidung){
        Nguoiban nb = nguoiBanService.taoNguoiBan(nguoiban, idNguoidung);
        return ResponseEntity.ok(nb);
    }

    @GetMapping("/get")
    private ResponseEntity<Map<String, Object>> getNguoiBan(@RequestParam int pageNumber){
        Map<String, Object> response = nguoiBanService.getNguoiBan(pageNumber);
        return ResponseEntity.ok(response);
    }

}
