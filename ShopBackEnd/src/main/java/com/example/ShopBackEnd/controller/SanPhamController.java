package com.example.ShopBackEnd.controller;

import com.example.ShopBackEnd.dto.get.sanpham.SanPhamInDetailDTO;
import com.example.ShopBackEnd.entity.Sanpham;
import com.example.ShopBackEnd.service.inter.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*tách luồng xử lý rất hay, nếu ko có exception thì chạy vào rest controller,
    nếu có exception thì sẽ chạy vào controller nhưng mà là rest controller advice
*/
@RestController
@RequestMapping("/api/sanpham")
public class SanPhamController {

    private final SanPhamService sanPhamService;

    public SanPhamController(SanPhamService sanPhamService) {
        this.sanPhamService = sanPhamService;
    }

    @PostMapping("/create")
    public ResponseEntity<Sanpham> taoSanPham(@Valid @RequestBody Sanpham sanpham, @RequestParam Integer maNguoiBan) {
        return ResponseEntity.ok(sanPhamService.taoSanPham(sanpham, maNguoiBan));
    }

    @GetMapping("/get")
    public ResponseEntity<?> getSanPhamTheoTrang(@RequestParam int pageNumber) {
        return ResponseEntity.ok(sanPhamService.getSanPhamTheoTrang(pageNumber));
    }

    @GetMapping("/get/{theLoai}")
    public ResponseEntity<?> phanTrangSanPhamTheoTheLoai(@RequestParam int pageNumber, @PathVariable String theLoai) {
        return ResponseEntity.ok(sanPhamService.phanTrangSanPhamTheoTheLoai(pageNumber, theLoai));
    }

    @GetMapping("/search/{text}")
    public ResponseEntity<?> timKiemSanPhamPhanTrang(@RequestParam int pageNumber, @PathVariable String text) {
        return ResponseEntity.ok(sanPhamService.timKiemSanPhamTheoTrang(text, pageNumber));
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<SanPhamInDetailDTO> getSanPhamDetail(@PathVariable Integer id) {
        return ResponseEntity.ok(sanPhamService.findSanPham(id));
    }

    @GetMapping("/get/shop/{id}")
    public ResponseEntity<?> findSanPhamByIdShop(@RequestParam int pageNumber, @PathVariable Integer id) {
        return ResponseEntity.ok(sanPhamService.findSanPhamByIdShop(id, pageNumber));
    }

    @GetMapping("/get/related/{id}")
    public ResponseEntity<?> getSanPhamRelated(@RequestParam int pageNumber, @PathVariable Integer id) {
        return ResponseEntity.ok(sanPhamService.getSanPhamRelated(id, pageNumber));
    }

    @GetMapping("/get/spct/{id}")
    public ResponseEntity<?> getSanPhamChiTiet(@PathVariable Integer id) {
        return ResponseEntity.ok(sanPhamService.getSanPhamChiTiet(id));
    }

    @GetMapping("/searchShop/{id}")
    public ResponseEntity<?> timKiemSanPhamCuaShop(@PathVariable Integer id, @RequestParam String text, @RequestParam int pageNumber) {
        return ResponseEntity.ok(sanPhamService.timKiemSanPhamCuaShop(id, text, pageNumber));
    }

    @GetMapping("/bestSeller/{id}")
    public ResponseEntity<?> getBestSellerProductByShop(@PathVariable Integer id, @RequestParam int pageNumber) {
        return ResponseEntity.ok(sanPhamService.getBestSellerProductByShop(id, pageNumber));
    }

    @GetMapping("/categoryProduct/{id}")
    public ResponseEntity<?> getCategoryAndProductByShop(@PathVariable Integer id, @RequestParam String tenDanhMuc, @RequestParam int pageNumber) {
        return ResponseEntity.ok(sanPhamService.getCategoryAndProductByShop(id, tenDanhMuc, pageNumber));
    }

}
