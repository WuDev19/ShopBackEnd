package com.example.ShopBackEnd.repository;

import com.example.ShopBackEnd.dto.projection.DanhMucProjection;
import com.example.ShopBackEnd.entity.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DanhMucRepository extends JpaRepository<DanhMuc, Integer> {

    @Query(value = """
            SELECT dm.tenDanhMuc, COUNT(dm.maDanhMuc) AS sl
            from DanhMuc dm
            join Danhmuc_Sanpham dm_sp on dm.maDanhMuc = dm_sp.maDanhMuc
            join Sanpham sp on sp.maSp = dm_sp.maSp
            where sp.maNguoiBan = :id
            group by dm.tenDanhMuc
            """,
            nativeQuery = true)
    List<DanhMucProjection> getTenDanhMucVaSoLuong(@Param("id") Integer id);

}
