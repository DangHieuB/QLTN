package com.example.asm.service;

import com.example.asm.entities.TaiNghe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

public interface ITaiNgheService {

    Page<TaiNghe> getAll(Pageable pageable);

    TaiNghe getById(Integer id);

    void addTaiNghe(TaiNghe tn);

    void deleteTaiNghe(TaiNghe tn);

    void updateTaiNghe(TaiNghe tn);

    Page<TaiNghe> findByPriceBeetween(BigDecimal min, BigDecimal max, Pageable pageable);

    Page<TaiNghe> findByTen(String ten, Pageable pageable);

    Page<TaiNghe> findByDonGiaMin(BigDecimal min, Pageable pageable);

    Page<TaiNghe> findByDonGiaMax(BigDecimal max, Pageable pageable);

    Page<TaiNghe> findByPriceAndTen(String ten, BigDecimal min, BigDecimal max, Pageable pageable);

    Page<TaiNghe> findByTenTaiNgheContainsAndDonGiaAfter(String ten, BigDecimal min, Pageable pageable);

    Page<TaiNghe> findByTenTaiNgheContainsAndDonGiaBefore(String ten, BigDecimal min, Pageable pageable);
}
