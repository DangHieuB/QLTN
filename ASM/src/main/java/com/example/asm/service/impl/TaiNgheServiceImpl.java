package com.example.asm.service.impl;

import com.example.asm.entities.TaiNghe;
import com.example.asm.repository.ITaiNgheRepository;
import com.example.asm.service.ITaiNgheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TaiNgheServiceImpl implements ITaiNgheService {

    @Autowired
    ITaiNgheRepository repository;

    @Override
    public Page<TaiNghe> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public TaiNghe getById(Integer id) {
        return repository.getReferenceById(id);
    }

    @Override
    public void addTaiNghe(TaiNghe tn) {
         repository.save(tn);
    }

    @Override
    public void deleteTaiNghe(TaiNghe tn) {
        repository.delete(tn);
    }

    @Override
    public void updateTaiNghe(TaiNghe tn) {
        repository.save(tn);
    }

    @Override
    public Page<TaiNghe> findByPriceBeetween(BigDecimal min, BigDecimal max, Pageable pageable) {
        return repository.findByDonGiaBetween(min, max, pageable);
    }

    @Override
    public Page<TaiNghe> findByTen(String ten, Pageable pageable) {
        return repository.findByTenTaiNgheContains(ten, pageable);
    }

    @Override
    public Page<TaiNghe> findByDonGiaMin(BigDecimal min, Pageable pageable) {
        return repository.findByDonGiaAfter(min, pageable);
    }

    @Override
    public Page<TaiNghe> findByDonGiaMax(BigDecimal max, Pageable pageable) {
        return repository.findByDonGiaBefore(max, pageable);
    }

    @Override
    public Page<TaiNghe> findByPriceAndTen(String ten, BigDecimal min, BigDecimal max, Pageable pageable) {
        return repository.findByTenTaiNgheContainsAndDonGiaBetween(ten, min, max, pageable);
    }

    @Override
    public Page<TaiNghe> findByTenTaiNgheContainsAndDonGiaAfter(String ten, BigDecimal min, Pageable pageable) {
        return repository.findByTenTaiNgheContainsAndDonGiaAfter(ten, min, pageable);
    }

    @Override
    public Page<TaiNghe> findByTenTaiNgheContainsAndDonGiaBefore(String ten, BigDecimal max, Pageable pageable) {
        return repository.findByTenTaiNgheContainsAndDonGiaBefore(ten, max, pageable);
    }

}
