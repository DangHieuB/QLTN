package com.example.asm.service.impl;

import com.example.asm.entities.GioHang;
import com.example.asm.entities.GioHangChiTiet;
import com.example.asm.entities.User;
import com.example.asm.repository.IGioHangRepository;
import com.example.asm.service.IGioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class GioHangServiceImpl implements IGioHangService {

    @Autowired
    IGioHangRepository repository;

    @Override
    public GioHang save(GioHang gh) {
        return repository.save(gh);
    }

    @Override
    public GioHang getByUser(User user) {
        return repository.getByUser(user);
    }

    @Override
    public BigDecimal tongTien(GioHang gh) {
        double tongTien = 0;
        List<GioHangChiTiet> listGHCT = gh.getListGHCT();
        for(GioHangChiTiet ghct: listGHCT) {
            double thanhTien = ghct.getSoLuong() * Double.parseDouble(String.valueOf(ghct.getTaiNghe().getDonGia()));
            tongTien += thanhTien;
        }
        return BigDecimal.valueOf(tongTien);
    }
}
