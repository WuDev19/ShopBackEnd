package com.example.ShopBackEnd.repository;

import com.example.ShopBackEnd.entity.GioHang;
import com.example.ShopBackEnd.entity.Sanpham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CartRepository extends JpaRepository<GioHang, Integer> {

    @Query(value = """
            SELECT *
            FROM GioHang
            WHERE maND = :maND
            AND maNguoiBan = :maNB
            """,
            nativeQuery = true)
    Optional<GioHang> findByMaNBAndMaND(@Param("maND") String maND, @Param("maNB") Integer maNB);

    @Query(value = """
            SELECT *
            FROM GioHang
            WHERE maND = :maND
            ORDER BY updateTime DESC
            """,
            countQuery = """
                    SELECT COUNT(*)
                    FROM GioHang
                    WHERE maND = :maND
                    """,
            nativeQuery = true)
    Page<GioHang> getGioHangNguoiDung(@Param("maND") String maND, Pageable pageable);

}
