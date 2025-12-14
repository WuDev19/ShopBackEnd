package com.example.ShopBackEnd.service.impl;

import com.example.ShopBackEnd.dto.get.DiaChiDTO;
import com.example.ShopBackEnd.dto.get.NguoiDungDTO;
import com.example.ShopBackEnd.dto.request.UserUpdateDTO;
import com.example.ShopBackEnd.entity.Nguoidung;
import com.example.ShopBackEnd.repository.NguoiDungRepository;
import com.example.ShopBackEnd.service.inter.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NguoiDungServiceImpl implements NguoiDungService {

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

    public Nguoidung updateNameGender(UserUpdateDTO userUpdateDTO) {
        Nguoidung nguoidung = repository.findById(userUpdateDTO.getMaND()).orElseThrow();
        if (userUpdateDTO.getTen() != null) {
            nguoidung.setTen(userUpdateDTO.getTen());
        }
        if (userUpdateDTO.getAnhdaidien() != null) {
            nguoidung.setAnhdaidien(userUpdateDTO.getAnhdaidien());
        }
        if (userUpdateDTO.getSdt() != null) {
            nguoidung.setSdt(userUpdateDTO.getSdt());
        }
        if (userUpdateDTO.getEmail() != null) {
            nguoidung.setEmail(userUpdateDTO.getEmail());
        }
        if (userUpdateDTO.getGioitinh() != null) {
            nguoidung.setGioitinh(userUpdateDTO.getGioitinh());
        } else {
            if (nguoidung.getGioitinh() == null) {
                nguoidung.setGioitinh("ND");
            }
        }
        return repository.save(nguoidung);
    }

    public Nguoidung updatePhone(String id, String phone) {
        Nguoidung nguoidung = repository.findById(id).orElseThrow();
        if (phone != null) {
            nguoidung.setSdt(phone);
        }
        return repository.save(nguoidung);
    }

    public Nguoidung updateEmail(String id, String email) {
        Nguoidung nguoidung = repository.findById(id).orElseThrow();
        if (email != null) {
            nguoidung.setEmail(email);
        }
        return repository.save(nguoidung);
    }

}
