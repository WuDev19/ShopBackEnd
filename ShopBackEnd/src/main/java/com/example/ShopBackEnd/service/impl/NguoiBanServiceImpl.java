package com.example.ShopBackEnd.service.impl;

import com.example.ShopBackEnd.constants.StringConst;
import com.example.ShopBackEnd.dto.get.DiaChiDTO;
import com.example.ShopBackEnd.dto.get.NguoiBanDTO;
import com.example.ShopBackEnd.dto.get.sanpham.SanPhamDTO;
import com.example.ShopBackEnd.entity.DiaChi;
import com.example.ShopBackEnd.entity.Nguoiban;
import com.example.ShopBackEnd.entity.Nguoidung;
import com.example.ShopBackEnd.repository.NguoiBanRepository;
import com.example.ShopBackEnd.repository.NguoiDungRepository;
import com.example.ShopBackEnd.service.inter.NguoiBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NguoiBanServiceImpl implements NguoiBanService {

    @Autowired
    private NguoiBanRepository nguoiBanRepository;

    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    public NguoiBanDTO findById(Integer id) {
        Optional<Nguoiban> opt = nguoiBanRepository.findById(id);
        if (opt.isEmpty()) {
            return null;
        }
        Nguoiban nb = opt.get();
        DiaChi dc = nb.getDiaChi();
        NguoiBanDTO nguoiBanDTO = new NguoiBanDTO();
        nguoiBanDTO.setMaNguoiBan(nb.getMaNguoiBan());
        nguoiBanDTO.setTenShop(nb.getTenShop());
        nguoiBanDTO.setSdtNguoiBan(nb.getSdtNguoiBan());
        nguoiBanDTO.setAvtShop(nb.getAvtShop());
        nguoiBanDTO.setDiaChi(diaChiMapToDiaChiDTO(dc));
        nguoiBanDTO.setSanphams(nb.getSanphams().stream().map(sanpham ->
                        new SanPhamDTO(sanpham.getMaSp(),
                                sanpham.getNguoiban().getTenShop(),
                                sanpham.getGiaSp(),
                                sanpham.getMotaSp(),
                                sanpham.getThumbnail(),
                                sanpham.getGiamgia(),
                                sanpham.getNumberBought(),
                                sanpham.getNguoiban().getMaNguoiBan()))
                .collect(Collectors.toSet()));
        return nguoiBanDTO;
    }

    public Nguoiban taoNguoiBan(Nguoiban nguoiban, String idNguoiDung) {
        Nguoidung nguoidung = nguoiDungRepository.findById(idNguoiDung).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ko tim thay"));
        nguoidung.registerSeller(nguoiban);
        return nguoiBanRepository.save(nguoiban);
    }

    public Map<String, Object> getNguoiBan(int pageNumber) {
        Page<Nguoiban> page = nguoiBanRepository.getNguoiBan(PageRequest.of(pageNumber, 6));
        Map<String, Object> response = new HashMap<>();
        List<NguoiBanDTO> nguoiBanDTOList = page.getContent().stream().map(nguoiban -> new NguoiBanDTO(
                nguoiban.getMaNguoiBan(),
                nguoiban.getTenShop(),
                nguoiban.getSdtNguoiBan(),
                nguoiban.getAvtShop(),
                diaChiMapToDiaChiDTO(nguoiban.getDiaChi()),
                nguoiban.getSanphams().stream().map(sanpham ->
                                new SanPhamDTO(sanpham.getMaSp(),
                                        sanpham.getNguoiban().getTenShop(),
                                        sanpham.getGiaSp(), sanpham.getMotaSp(),
                                        sanpham.getThumbnail(),
                                        sanpham.getGiamgia(),
                                        sanpham.getNumberBought(),
                                        sanpham.getNguoiban().getMaNguoiBan()))
                        .collect(Collectors.toSet()))).toList();

        response.put(StringConst.PAGE_NUMBER, page.getNumber());
        response.put(StringConst.PAGE_SIZE, page.getNumberOfElements());
        response.put(StringConst.CONTENTS, nguoiBanDTOList);
        return response;
    }

    private DiaChiDTO diaChiMapToDiaChiDTO(DiaChi diaChi) {
        return new DiaChiDTO(diaChi.getMaDiaChi(),
                diaChi.getTenCuThe(),
                diaChi.getTenXa(),
                diaChi.getTenHuyen(),
                diaChi.getTenThanhPho(),
                diaChi.getQuocGia());
    }

}
