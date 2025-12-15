package com.example.ShopBackEnd.service.inter;

import com.example.ShopBackEnd.dto.get.PageResponse;
import com.example.ShopBackEnd.dto.get.sanpham.SanPhamChiTietDTO;
import com.example.ShopBackEnd.dto.get.sanpham.SanPhamDTO;
import com.example.ShopBackEnd.dto.get.sanpham.SanPhamInDetailDTO;
import com.example.ShopBackEnd.dto.projection.DanhMucSanPhamProjection;
import com.example.ShopBackEnd.entity.Sanpham;

import java.util.List;
import java.util.Map;

public interface SanPhamService {

    Sanpham taoSanPham(Sanpham sanpham, Integer maNguoiBan);

    PageResponse<SanPhamDTO> getSanPhamTheoTrang(int pageNumber);

    PageResponse<SanPhamDTO> phanTrangSanPhamTheoTheLoai(int pageNumber, String theLoai);

    PageResponse<SanPhamDTO> timKiemSanPhamTheoTrang(String text, int pageNumber);

    SanPhamInDetailDTO findSanPham(Integer id);

    PageResponse<SanPhamDTO> findSanPhamByIdShop(Integer id, int pageNumber);

    PageResponse<SanPhamDTO> getSanPhamRelated(Integer id, int pageNumber);

    List<SanPhamChiTietDTO> getSanPhamChiTiet(Integer id);

    PageResponse<SanPhamDTO> timKiemSanPhamCuaShop(Integer id, String text, int pageNumber);

    PageResponse<SanPhamDTO> getBestSellerProductByShop(Integer id, int pageNumber);

    PageResponse<DanhMucSanPhamProjection> getCategoryAndProductByShop(Integer id, String tenDanhMuc, int pageNumber);

}
