package com.example.ShopBackEnd.service.inter;

import com.example.ShopBackEnd.dto.get.sanpham.SanPhamChiTietDTO;
import com.example.ShopBackEnd.dto.get.sanpham.SanPhamInDetailDTO;
import com.example.ShopBackEnd.entity.Sanpham;

import java.util.List;
import java.util.Map;

public interface SanPhamService {

    Sanpham taoSanPham(Sanpham sanpham, Integer maNguoiBan);

    Map<String, Object> getSanPhamTheoTrang(int pageNumber);

    Map<String, Object> phanTrangSanPhamTheoTheLoai(int pageNumber, String theLoai);

    Map<String, Object> timKiemSanPhamTheoTrang(String text, int pageNumber);

    SanPhamInDetailDTO findSanPham(Integer id);

    Map<String, Object> findSanPhamByIdShop(Integer id, int pageNumber);

    Map<String, Object> getSanPhamRelated(Integer id, int pageNumber);

    List<SanPhamChiTietDTO> getSanPhamChiTiet(Integer id);

    Map<String, Object> timKiemSanPhamCuaShop(Integer id, String text, int pageNumber);

    Map<String, Object> getBestSellerProductByShop(Integer id, int pageNumber);

    Map<String, Object> getCategoryAndProductByShop(Integer id, String tenDanhMuc, int pageNumber);

}
