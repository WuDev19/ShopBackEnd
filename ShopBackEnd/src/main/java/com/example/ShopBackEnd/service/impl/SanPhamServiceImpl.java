package com.example.ShopBackEnd.service.impl;

import com.example.ShopBackEnd.dto.get.sanpham.SanPhamChiTietDTO;
import com.example.ShopBackEnd.dto.get.sanpham.SanPhamDTO;
import com.example.ShopBackEnd.dto.get.sanpham.SanPhamInDetailDTO;
import com.example.ShopBackEnd.dto.projection.DanhMucSanPhamProjection;
import com.example.ShopBackEnd.entity.AnhMoTaSanPham;
import com.example.ShopBackEnd.entity.Nguoiban;
import com.example.ShopBackEnd.entity.SanPhamChiTiet;
import com.example.ShopBackEnd.entity.Sanpham;
import com.example.ShopBackEnd.repository.NguoiBanRepository;
import com.example.ShopBackEnd.repository.SanPhamRepository;
import com.example.ShopBackEnd.service.inter.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private NguoiBanRepository nguoiBanRepository;

    public Sanpham taoSanPham(Sanpham sanpham, Integer maNguoiBan) {
        Nguoiban nb = nguoiBanRepository.findById(maNguoiBan).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Khong tim thay nguoi ban"));
        nb.addSanPham(sanpham);
        return sanPhamRepository.save(sanpham);
    }

    public Map<String, Object> getSanPhamTheoTrang(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 6);
        Page<Sanpham> page = sanPhamRepository.getSanPhamTheoTrang(pageable);
        List<SanPhamDTO> listSanPham = page.getContent().stream().map(sanpham ->
                        new SanPhamDTO(sanpham.getMaSp(),
                                sanpham.getNguoiban().getTenShop(),
                                sanpham.getGiaSp(),
                                sanpham.getMotaSp(),
                                sanpham.getThumbnail(),
                                sanpham.getGiamgia(),
                                sanpham.getNumberBought(),
                                sanpham.getNguoiban().getMaNguoiBan()))
                .toList();
        Map<String, Object> response = new HashMap<>();
        response.put("contents", listSanPham);
        response.put("pageNumber", page.getNumber());
        response.put("pageSize", page.getNumberOfElements());
        return response;
    }

    public Map<String, Object> phanTrangSanPhamTheoTheLoai(int pageNumber, String theLoai) {
        Pageable pageable = PageRequest.of(pageNumber, 6);
        Page<Sanpham> sanphamPage = sanPhamRepository.phanTrangSanPhamTheoTheLoai(theLoai, pageable);
        List<SanPhamDTO> listSanPham = sanphamPage.getContent().stream().map(sanpham ->
                        new SanPhamDTO(sanpham.getMaSp(),
                                sanpham.getNguoiban().getTenShop(),
                                sanpham.getGiaSp(), sanpham.getMotaSp(),
                                sanpham.getThumbnail(),
                                sanpham.getGiamgia(),
                                sanpham.getNumberBought(),
                                sanpham.getNguoiban().getMaNguoiBan()))
                .toList();
        Map<String, Object> response = new HashMap<>();
        response.put("contents", listSanPham);
        response.put("pageNumber", sanphamPage.getNumber());
        response.put("pageSize", sanphamPage.getNumberOfElements());
        return response;
    }

    public Map<String, Object> timKiemSanPhamTheoTrang(String text, int pageNumber) {
        Page<Sanpham> pageable = sanPhamRepository.timKiemSanPhamPhanTrang(text, PageRequest.of(pageNumber, 6));
        List<SanPhamDTO> dtoList = pageable.getContent()
                .stream().map(sanpham ->
                        new SanPhamDTO(sanpham.getMaSp(),
                                sanpham.getNguoiban().getTenShop(),
                                sanpham.getGiaSp(),
                                sanpham.getMotaSp(),
                                sanpham.getThumbnail(),
                                sanpham.getGiamgia(),
                                sanpham.getNumberBought(),
                                sanpham.getNguoiban().getMaNguoiBan()))
                .toList();
        Map<String, Object> response = new HashMap<>();
        response.put("pageNumber", pageable.getNumber());
        response.put("pageSize", pageable.getNumberOfElements());
        response.put("contents", dtoList);
        return response;
    }

    public SanPhamInDetailDTO findSanPham(Integer id) {
        Optional<Sanpham> response = sanPhamRepository.findById(id);
        Optional<SanPhamInDetailDTO> sanPhamInDetailDTO = response.map(sanpham ->
                new SanPhamInDetailDTO(sanpham.getMaSp(),
                        sanpham.getNguoiban().getTenShop(),
                        sanpham.getNguoiban().getMaNguoiBan(),
                        sanpham.getNguoiban().getAvtShop(),
                        sanpham.getGiaSp(),
                        sanpham.getMotaSp(),
                        sanpham.getGiamgia(),
                        sanpham.getNumberBought(),
                        sanpham.getImages().stream().map(AnhMoTaSanPham::getUrlAnh).collect(Collectors.toSet()),
                        sanpham.getNguoiban().getSanphams().size(),
                        sanpham.getRating()));
        return sanPhamInDetailDTO.orElseThrow(() -> new ClassCastException("Map Error"));
    }

    public Map<String, Object> findSanPhamByIdShop(Integer id, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 6);
        Page<Sanpham> sanphamPage = sanPhamRepository.getSanPhamTheoIdShop(id, pageable);
        List<SanPhamDTO> sanPhamDTOList = sanphamPage.getContent().stream().map(sanpham ->
                        new SanPhamDTO(sanpham.getMaSp(),
                                sanpham.getNguoiban().getTenShop(),
                                sanpham.getGiaSp(),
                                sanpham.getMotaSp(),
                                sanpham.getThumbnail(),
                                sanpham.getGiamgia(),
                                sanpham.getNumberBought(),
                                sanpham.getNguoiban().getMaNguoiBan()))
                .toList();
        Map<String, Object> response = new HashMap<>();
        response.put("pageNumber", sanphamPage.getNumber());
        response.put("pageSize", sanphamPage.getNumberOfElements());
        response.put("contents", sanPhamDTOList);
        return response;
    }

    public Map<String, Object> getSanPhamRelated(Integer id, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 6);
        Page<Sanpham> sanphamPage = sanPhamRepository.getSanPhamRelated(id, pageable);
        List<SanPhamDTO> sanPhamDTOList = sanphamPage.getContent().stream().map(sanpham ->
                        new SanPhamDTO(sanpham.getMaSp(),
                                sanpham.getNguoiban().getTenShop(),
                                sanpham.getGiaSp(),
                                sanpham.getMotaSp(),
                                sanpham.getThumbnail(),
                                sanpham.getGiamgia(),
                                sanpham.getNumberBought(),
                                sanpham.getNguoiban().getMaNguoiBan()))
                .toList();
        Map<String, Object> response = new HashMap<>();
        response.put("pageNumber", sanphamPage.getNumber());
        response.put("pageSize", sanphamPage.getNumberOfElements());
        response.put("contents", sanPhamDTOList);
        return response;
    }

    public List<SanPhamChiTietDTO> getSanPhamChiTiet(Integer id) {
        List<SanPhamChiTiet> page = sanPhamRepository.getSanPhamChiTiet(id);
        return page.stream().map(sanPhamChiTiet ->
                        new SanPhamChiTietDTO(sanPhamChiTiet.getMaSanPhamDeTail(),
                                sanPhamChiTiet.getTenDetail(),
                                sanPhamChiTiet.getInStock(),
                                sanPhamChiTiet.getAnhDetail(),
                                sanPhamChiTiet.getUnitPrice(),
                                sanPhamChiTiet.getColor(),
                                sanPhamChiTiet.getKichco(),
                                sanPhamChiTiet.getSanpham().getMaSp()))
                .toList();
    }

    public Map<String, Object> timKiemSanPhamCuaShop(Integer id, String text, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 6);
        Page<Sanpham> sanphamPage = sanPhamRepository.timKiemSanPhamCuaShop(id, text, pageable);
        List<SanPhamDTO> list = sanphamPage.getContent().stream().map(sanpham ->
                        new SanPhamDTO(sanpham.getMaSp(),
                                sanpham.getNguoiban().getTenShop(),
                                sanpham.getGiaSp(),
                                sanpham.getMotaSp(),
                                sanpham.getThumbnail(),
                                sanpham.getGiamgia(),
                                sanpham.getNumberBought(),
                                sanpham.getNguoiban().getMaNguoiBan()))
                .toList();
        Map<String, Object> response = new HashMap<>();
        response.put("pageNumber", sanphamPage.getNumber());
        response.put("pageSize", sanphamPage.getNumberOfElements());
        response.put("contents", list);
        return response;
    }

    public Map<String, Object> getBestSellerProductByShop(Integer id, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 6);
        Page<Sanpham> sanphamPage = sanPhamRepository.getBestSellerProductByShop(id, pageable);
        List<SanPhamDTO> sanPhamDTOList = sanphamPage.getContent().stream().map(sanpham ->
                new SanPhamDTO(sanpham.getMaSp(),
                        sanpham.getNguoiban().getTenShop(),
                        sanpham.getGiaSp(),
                        sanpham.getMotaSp(),
                        sanpham.getThumbnail(),
                        sanpham.getGiamgia(),
                        sanpham.getNumberBought(),
                        sanpham.getNguoiban().getMaNguoiBan()
                )
        ).toList();
        Map<String, Object> response = new HashMap<>();
        response.put("pageNumber", sanphamPage.getNumber());
        response.put("pageSize", sanphamPage.getNumberOfElements());
        response.put("contents", sanPhamDTOList);
        return response;
    }

    public Map<String, Object> getCategoryAndProductByShop(Integer id, String tenDanhMuc, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 6);
        Page<DanhMucSanPhamProjection> sanphamPage = sanPhamRepository.getCategoryAndProductByShop(id, tenDanhMuc, pageable);
        Map<String, Object> response = new HashMap<>();
        response.put("pageNumber", sanphamPage.getNumber());
        response.put("pageSize", sanphamPage.getNumberOfElements());
        response.put("contents", sanphamPage.getContent());
        return response;
    }

}
