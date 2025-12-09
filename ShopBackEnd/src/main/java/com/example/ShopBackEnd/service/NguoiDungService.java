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

    public NguoiDungDTO findById(String id) {

        Optional<Nguoidung> opt = repository.findById(id);
        if (opt.isEmpty()) {
            return null;
        }

        Nguoidung nd = opt.get();

        NguoiDungDTO nguoiDungDTO = new NguoiDungDTO();
        nguoiDungDTO.setMaND(nd.getMaND());
        nguoiDungDTO.setTen(nd.getTen());
        nguoiDungDTO.setEmail(nd.getEmail());
        nguoiDungDTO.setSdt(nd.getSdt());
        nguoiDungDTO.setGioitinh(nd.getGioitinh());
        nguoiDungDTO.setAnhdaidien(nd.getAnhdaidien());
        nguoiDungDTO.setListDiaChi(nd.getListDiaChi().stream().map(diaChi ->
                new DiaChiDTO(diaChi.getMaDiaChi(),
                        diaChi.getTenCuThe(),
                        diaChi.getTenXa(),
                        diaChi.getTenHuyen(),
                        diaChi.getTenThanhPho(),
                        diaChi.getQuocGia()))
                .collect(Collectors.toSet()));

        return nguoiDungDTO;
    }

}
