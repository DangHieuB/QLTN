package com.example.asm.repository;

import com.example.asm.entities.TaiNghe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface ITaiNgheRepository extends JpaRepository<TaiNghe, Integer> {
    Page<TaiNghe> findByDonGiaBetween(BigDecimal giaMin, BigDecimal giaMax, Pageable pageable);

    Page<TaiNghe> findByTenTaiNgheContains(String ten, Pageable pageable);

    Page<TaiNghe> findByDonGiaAfter(BigDecimal min, Pageable pageable);

    Page<TaiNghe> findByDonGiaBefore(BigDecimal max, Pageable pageable);

    Page<TaiNghe> findByTenTaiNgheContainsAndDonGiaAfter(String ten, BigDecimal min, Pageable pageable);

    Page<TaiNghe> findByTenTaiNgheContainsAndDonGiaBefore(String ten, BigDecimal max, Pageable pageable);

    Page<TaiNghe> findByTenTaiNgheContainsAndDonGiaBetween(String ten, BigDecimal giaMin, BigDecimal giaMax, Pageable pageable);

}
