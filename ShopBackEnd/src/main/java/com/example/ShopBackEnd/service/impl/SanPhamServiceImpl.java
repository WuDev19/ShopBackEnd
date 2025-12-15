package com.example.ShopBackEnd.service.impl;

import com.example.ShopBackEnd.dto.get.PageResponse;
import com.example.ShopBackEnd.dto.get.sanpham.SanPhamChiTietDTO;
import com.example.ShopBackEnd.dto.get.sanpham.SanPhamDTO;
import com.example.ShopBackEnd.dto.get.sanpham.SanPhamInDetailDTO;
import com.example.ShopBackEnd.dto.projection.DanhMucSanPhamProjection;
import com.example.ShopBackEnd.entity.AnhMoTaSanPham;
import com.example.ShopBackEnd.entity.Nguoiban;
import com.example.ShopBackEnd.entity.SanPhamChiTiet;
import com.example.ShopBackEnd.entity.Sanpham;
import com.example.ShopBackEnd.exception.customexception.PageNumberNegativeException;
import com.example.ShopBackEnd.exception.customexception.ResourcesNotFoundException;
import com.example.ShopBackEnd.repository.NguoiBanRepository;
import com.example.ShopBackEnd.repository.NguoiDungRepository;
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

    private final SanPhamRepository sanPhamRepository;

    private final NguoiBanRepository nguoiBanRepository;

    public SanPhamServiceImpl(SanPhamRepository sanPhamRepository, NguoiBanRepository nguoiDungRepository) {
        this.sanPhamRepository = sanPhamRepository;
        this.nguoiBanRepository = nguoiDungRepository;
    }

    @Override
    public Sanpham taoSanPham(Sanpham sanpham, Integer maNguoiBan) {
        Nguoiban nb = nguoiBanRepository.findById(maNguoiBan).orElseThrow(() ->
                new ResourcesNotFoundException("Bạn chưa xác nhận đăng kí là người bán"));
        nb.addSanPham(sanpham);
        return sanPhamRepository.save(sanpham);
    }

    @Override
    public PageResponse<SanPhamDTO> getSanPhamTheoTrang(int pageNumber) {
        if (pageNumber < 0) throw new PageNumberNegativeException("Số trang phải lớn hơn 0");
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
        return new PageResponse<>(
                page.getNumber(),
                page.getNumberOfElements(),
                listSanPham
        );
    }

    @Override
    public PageResponse<SanPhamDTO> phanTrangSanPhamTheoTheLoai(int pageNumber, String theLoai) {
        if (pageNumber < 0) throw new PageNumberNegativeException("Số trang phải lớn hơn 0");
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
        return new PageResponse<>(
                sanphamPage.getNumber(),
                sanphamPage.getNumberOfElements(),
                listSanPham
        );
    }

    @Override
    public PageResponse<SanPhamDTO> timKiemSanPhamTheoTrang(String text, int pageNumber) {
        if (pageNumber < 0) throw new PageNumberNegativeException("Số trang phải lớn hơn 0");
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
        return new PageResponse<>(
                pageable.getNumber(),
                pageable.getNumberOfElements(),
                dtoList
        );
    }

    @Override
    public SanPhamInDetailDTO findSanPham(Integer id) {
        Optional<Sanpham> response = sanPhamRepository.findById(id);
        response.orElseThrow(() -> new ResourcesNotFoundException("Sản phẩm không tồn tại"));
        return response.map(sanpham ->
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
                                sanpham.getRating()))
                .orElseThrow(() -> new ClassCastException("Chuyển đổi không hợp lệ"));
    }

    @Override
    public PageResponse<SanPhamDTO> findSanPhamByIdShop(Integer id, int pageNumber) {
        if (pageNumber < 0) throw new PageNumberNegativeException("Số trang phải lớn hơn 0");
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
        return new PageResponse<>(
                sanphamPage.getNumber(),
                sanphamPage.getNumberOfElements(),
                sanPhamDTOList
        );
    }

    @Override
    public PageResponse<SanPhamDTO> getSanPhamRelated(Integer id, int pageNumber) {
        if (pageNumber < 0) throw new PageNumberNegativeException("Số trang phải lớn hơn 0");
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
        return new PageResponse<>(
                sanphamPage.getNumber(),
                sanphamPage.getNumberOfElements(),
                sanPhamDTOList
        );
    }

    @Override
    public List<SanPhamChiTietDTO> getSanPhamChiTiet(Integer productId) {
        List<SanPhamChiTietDTO> dtoList = sanPhamRepository.getSanPhamChiTiet(productId).stream().map(sanPhamChiTiet ->
                        new SanPhamChiTietDTO(sanPhamChiTiet.getMaSanPhamDeTail(),
                                sanPhamChiTiet.getTenDetail(),
                                sanPhamChiTiet.getInStock(),
                                sanPhamChiTiet.getAnhDetail(),
                                sanPhamChiTiet.getUnitPrice(),
                                sanPhamChiTiet.getColor(),
                                sanPhamChiTiet.getKichco(),
                                sanPhamChiTiet.getSanpham().getMaSp()))
                .toList();
        if (dtoList.isEmpty()){
            throw new ResourcesNotFoundException("Không tồn tại sản phẩm chi tiết của sản phẩm này");
        }
        return dtoList;
    }

    @Override
    public PageResponse<SanPhamDTO> timKiemSanPhamCuaShop(Integer id, String text, int pageNumber) {
        if (pageNumber < 0) throw new PageNumberNegativeException("Số trang phải lớn hơn 0");
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
        return new PageResponse<>(
                sanphamPage.getNumber(),
                sanphamPage.getNumberOfElements(),
                list
        );
    }

    @Override
    public PageResponse<SanPhamDTO> getBestSellerProductByShop(Integer id, int pageNumber) {
        if (pageNumber < 0) throw new PageNumberNegativeException("Số trang phải lớn hơn 0");
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
        return new PageResponse<>(
                sanphamPage.getNumber(),
                sanphamPage.getNumberOfElements(),
                sanPhamDTOList
        );
    }

    @Override
    public PageResponse<DanhMucSanPhamProjection> getCategoryAndProductByShop(Integer id, String tenDanhMuc, int pageNumber) {
        if (pageNumber < 0) throw new PageNumberNegativeException("Số trang phải lớn hơn 0");
        Pageable pageable = PageRequest.of(pageNumber, 6);
        Page<DanhMucSanPhamProjection> sanphamPage = sanPhamRepository.getCategoryAndProductByShop(id, tenDanhMuc, pageable);
        return new PageResponse<>(
                sanphamPage.getNumber(),
                sanphamPage.getNumberOfElements(),
                sanphamPage.getContent()
        );
    }

}
