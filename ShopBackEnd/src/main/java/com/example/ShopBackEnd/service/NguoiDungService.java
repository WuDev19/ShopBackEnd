package com.example.ShopBackEnd.service;

import com.example.ShopBackEnd.dto.get.DiaChiDTO;
import com.example.ShopBackEnd.dto.get.NguoiDungDTO;
import com.example.ShopBackEnd.entity.Nguoidung;
import com.example.ShopBackEnd.repository.NguoiDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NguoiDungService {

    @Autowired
    private NguoiDungRepository repository;

    public Nguoidung taoNguoiDung(Nguoidung nd) {
        return repository.save(nd);
    }

    public Optional<NguoiDungDTO> findById(String id) {
        return repository.findById(id)
                .map(nd -> {
                    NguoiDungDTO dto = new NguoiDungDTO();
                    dto.setMaND(nd.getMaND());
                    dto.setTen(nd.getTen());
                    dto.setEmail(nd.getEmail());
                    dto.setSdt(nd.getSdt());
                    dto.setGioitinh(nd.getGioitinh());
                    dto.setAnhdaidien(nd.getAnhdaidien());
                    dto.setListDiaChi(nd.getListDiaChi().stream()
                            .map(d -> new DiaChiDTO(
                                    d.getMaDiaChi(),
                                    d.getTenCuThe(),
                                    d.getTenXa(),
                                    d.getTenHuyen(),
                                    d.getTenThanhPho(),
                                    d.getQuocGia()))
                            .collect(Collectors.toSet()));
                    return dto;
                });
    }

}
