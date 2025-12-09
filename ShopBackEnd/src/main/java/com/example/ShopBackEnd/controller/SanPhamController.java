package com.example.ShopBackEnd.controller;

import com.example.ShopBackEnd.dto.get.sanpham.SanPhamInDetailDTO;
import com.example.ShopBackEnd.entity.Sanpham;
import com.example.ShopBackEnd.service.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/sanpham")
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;

    @PostMapping("/create")
    public ResponseEntity<Sanpham> taoSanPham(@Valid @RequestBody Sanpham sanpham, @RequestParam Integer maNguoiBan) {
        Sanpham tmp = sanPhamService.taoSanPham(sanpham, maNguoiBan);
        return ResponseEntity.ok(tmp);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getSanPhamTheoTrang(@RequestParam int pageNumber) {
        Map<String, Object> response = sanPhamService.getSanPhamTheoTrang(pageNumber);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get/{theLoai}")
    public ResponseEntity<?> phanTrangSanPhamTheoTheLoai(@RequestParam int pageNumber, @PathVariable String theLoai){
        Map<String, Object> response = sanPhamService.phanTrangSanPhamTheoTheLoai(pageNumber, theLoai);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search/{text}")
    public ResponseEntity<?> timKiemSanPhamPhanTrang(@RequestParam int pageNumber, @PathVariable String text){
        Map<String, Object> response = sanPhamService.timKiemSanPhamTheoTrang(text, pageNumber);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<SanPhamInDetailDTO> getSanPhamDetail(@PathVariable Integer id){
        try{
            SanPhamInDetailDTO sanPhamInDetailDTO = sanPhamService.findSanPham(id);
            return ResponseEntity.ok(sanPhamInDetailDTO);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

    }

    @GetMapping("/get/shop/{id}")
    public ResponseEntity<?> findSanPhamByIdShop(@RequestParam int pageNumber, @PathVariable Integer id){
        Map<String, Object> response = sanPhamService.findSanPhamByIdShop(id, pageNumber);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get/related/{id}")
    public ResponseEntity<?> getSanPhamRelated(@RequestParam int pageNumber, @PathVariable Integer id){
        Map<String, Object> response = sanPhamService.getSanPhamRelated(id, pageNumber);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get/spct/{id}")
    public ResponseEntity<?> getSanPhamChiTiet(@PathVariable Integer id){
        return ResponseEntity.ok(sanPhamService.getSanPhamChiTiet(id));
    }

    @GetMapping("/searchShop/{id}")
    public ResponseEntity<?> timKiemSanPhamCuaShop(@PathVariable Integer id, @RequestParam String text, @RequestParam int pageNumber){
        Map<String, Object> response = sanPhamService.timKiemSanPhamCuaShop(id, text, pageNumber);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/bestSeller/{id}")
    public ResponseEntity<?> getBestSellerProductByShop(@PathVariable Integer id, @RequestParam int pageNumber){
        Map<String, Object> response = sanPhamService.getBestSellerProductByShop(id, pageNumber);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/categoryProduct/{id}")
    public ResponseEntity<?> getCategoryAndProductByShop(@PathVariable Integer id, @RequestParam String tenDanhMuc, @RequestParam int pageNumber){
        Map<String, Object> response = sanPhamService.getCategoryAndProductByShop(id, tenDanhMuc, pageNumber);
        return ResponseEntity.ok(response);
    }

}
