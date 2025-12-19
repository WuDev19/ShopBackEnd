package com.example.ShopBackEnd.repository;

import com.example.ShopBackEnd.entity.CartItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {


    @Query(value = """
            SELECT ci.*
            FROM GioHang gh JOIN CartItem ci
            ON gh.maGioHang = ci.maGioHang
            WHERE ci.maGioHang = :maGioHang AND ci.maSanPhamDetail = :maSanPhamDetail
            """,
            nativeQuery = true)
    Optional<CartItem> getExistCart(@Param("maGioHang") Integer maGioGang, @Param("maSanPhamDetail") Integer maSanPhamDetail);


    @Query(value = """
            SELECT *
            FROM CartItem
            WHERE maGioHang = :maGioHang
            """,
            countQuery = """
                    SELECT COUNT(*)
                    FROM CartItem
                    WHERE maGioHang = :maGioHang
                    """,
            nativeQuery = true)
    Page<CartItem> getCartItemCuaGioHang(@Param("maGioHang") Integer maGioHang, Pageable pageable);

    @Query(value = """
            SELECT COUNT(ci.cartItemId)
            FROM GioHang gh JOIN cartItem ci
            ON gh.maGioHang = ci.maGioHang
            where gh.maND = :maND
            """,
            nativeQuery = true)
    int getNumberCartItem(@Param("maND") String maND);

}
