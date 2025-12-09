package com.example.ShopBackEnd.repository;

import com.example.ShopBackEnd.entity.Nguoiban;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NguoiBanRepository extends JpaRepository<Nguoiban, Integer> {

    @Query(value = "SELECT * FROM NGUOIBAN",
            countQuery = "SELECT COUNT(*) FROM NGUOIBAN",
            nativeQuery = true)
    Page<Nguoiban> getNguoiBan (Pageable pageable);

}
