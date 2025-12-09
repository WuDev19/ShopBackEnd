package com.example.ShopBackEnd.repository;

import com.example.ShopBackEnd.dto.projection.DanhMucSanPhamProjection;
import com.example.ShopBackEnd.entity.SanPhamChiTiet;
import com.example.ShopBackEnd.entity.Sanpham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SanPhamRepository extends JpaRepository<Sanpham, Integer> {

    @Query(value = "SELECT * FROM SANPHAM",
            countQuery = "SELECT COUNT(*) FROM SANPHAM",
            nativeQuery = true)
    Page<Sanpham> getSanPhamTheoTrang(Pageable pageable);

    @Query(value =
            """
                    SELECT sp.*
                    FROM SANPHAM sp JOIN DANHMUC_SANPHAM dmsp
                    ON sp.maSp = dmsp.maSp
                    JOIN DANHMUC dm
                    ON dm.maDanhMuc = dmsp.maDanhMuc
                    WHERE dm.tenDanhMuc = :theLoai
                    """,
            countQuery =
                    """
                            SELECT COUNT(*)
                            FROM SANPHAM sp JOIN DANHMUC_SANPHAM dmsp
                            ON sp.maSp = dmsp.maSp
                            JOIN DANHMUC dm
                            ON dm.maDanhMuc = dmsp.maDanhMuc
                            WHERE dm.tenDanhMuc = :theLoai
                            """,
            nativeQuery = true
    )
    Page<Sanpham> phanTrangSanPhamTheoTheLoai(@Param("theLoai") String theLoai, Pageable pageable);

    @Query(value = """
            SELECT sp.*
            FROM SANPHAM sp JOIN NGUOIBAN nb
            ON sp.maNguoiBan = nb.maNguoiBan
            WHERE sp.motaSp LIKE %:text%
            OR nb.tenShop LIKE %:text%
            """,
            countQuery = """
                    SELECT COUNT(*)
                    FROM SANPHAM sp JOIN NGUOIBAN nb
                    ON sp.maNguoiBan = nb.maNguoiBan
                    WHERE sp.motaSp LIKE %:text%
                    OR nb.tenShop LIKE %:text%
                    """,
            nativeQuery = true)
    Page<Sanpham> timKiemSanPhamPhanTrang(@Param("text") String text, Pageable pageable);

    @Query(value = """
            SELECT sp.*
            FROM SANPHAM sp JOIN NGUOIBAN nb
            ON sp.maNguoiBan = nb.maNguoiBan
            WHERE nb.maNguoiBan = :id
            """,
            countQuery = """
                    SELECT COUNT(*)
                    FROM SANPHAM sp JOIN NGUOIBAN nb
                    ON sp.maNguoiBan = nb.maNguoiBan
                    WHERE nb.maNguoiBan = :id
                    """,
            nativeQuery = true)
    Page<Sanpham> getSanPhamTheoIdShop(@Param("id") Integer id, Pageable pageable);

    @Query(value = """
            SELECT DISTINCT sp.*
            FROM Sanpham sp
            JOIN Danhmuc_Sanpham dmsp ON sp.maSp = dmsp.maSp
            JOIN Danhmuc_Sanpham dmsp2 ON dmsp.maDanhMuc = dmsp2.maDanhMuc
            WHERE dmsp2.maSp = :id
            ORDER BY sp.maSp
            """,
            countQuery = """
                    SELECT COUNT(DISTINCT sp.maSp)
                    FROM Sanpham sp
                    JOIN Danhmuc_Sanpham dmsp ON sp.maSp = dmsp.maSp
                    JOIN Danhmuc_Sanpham dmsp2 ON dmsp.maDanhMuc = dmsp2.maDanhMuc
                    WHERE dmsp2.maSp = :id
                    """,
            nativeQuery = true)
    Page<Sanpham> getSanPhamRelated(@Param("id") Integer id, Pageable pageable);

    @Query(value = """
            SELECT spct.*
            FROM Sanpham sp
            JOIN SanPhamChiTiet spct
            ON sp.maSp = spct.maSp
            WHERE sp.maSp = :id
            """,
            countQuery = """
                    SELECT COUNT(*)
                    FROM Sanpham sp
                    JOIN SanPhamChiTiet spct
                    ON sp.maSp = spct.maSp
                    WHERE sp.maSp = :id
                    """,
            nativeQuery = true)
    List<SanPhamChiTiet> getSanPhamChiTiet(@Param("id") Integer id);

    @Query(value = """
            SELECT *
            FROM SANPHAM
            WHERE maNguoiBan = :id AND motaSp LIKE %:text%
            """,
            countQuery = """
                    SELECT COUNT(*)
                    FROM SANPHAM
                    WHERE maNguoiBan = :id AND motaSp LIKE %:text%
                    """,
            nativeQuery = true)
    Page<Sanpham> timKiemSanPhamCuaShop(@Param("id") Integer id, @Param("text") String text, Pageable pageable);

    @Query(value = """
            SELECT *
            FROM Sanpham sp
            WHERE sp.maNguoiBan = :id
            AND sp.numberBought >= 50
            """,
            countQuery = """
                    SELECT COUNT(*)
                    FROM Sanpham sp
                    WHERE sp.maNguoiBan = :id
                    AND sp.numberBought >= 50
                    """,
            nativeQuery = true)
    Page<Sanpham> getBestSellerProductByShop(@Param("id") Integer id, Pageable pageable);

    @Query(value = """
            SELECT sp.*, nb.tenShop, dm.tenDanhMuc
            FROM Sanpham sp
            JOIN Nguoiban nb ON sp.maNguoiBan = nb.maNguoiBan
            JOIN Danhmuc_Sanpham dm_sp ON sp.maSp = dm_sp.maSp
            JOIN DanhMuc dm ON dm.maDanhMuc = dm_sp.maDanhMuc
            WHERE sp.maNguoiBan = :id AND dm.tenDanhMuc = :tenDanhMuc
            """,
            countQuery = """
                    SELECT COUNT(*)
                    FROM Sanpham sp
                    JOIN Nguoiban nb ON sp.maNguoiBan = nb.maNguoiBan
                    JOIN Danhmuc_Sanpham dm_sp ON sp.maSp = dm_sp.maSp
                    JOIN DanhMuc dm ON dm.maDanhMuc = dm_sp.maDanhMuc
                    WHERE sp.maNguoiBan = :id AND dm.tenDanhMuc = :tenDanhMuc
                    """,
            nativeQuery = true)
    Page<DanhMucSanPhamProjection> getCategoryAndProductByShop(@Param("id") Integer id, @Param("tenDanhMuc") String tenDanhMuc, Pageable pageable);

}
