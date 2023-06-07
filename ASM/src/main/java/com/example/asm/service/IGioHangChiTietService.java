package com.example.asm.service;

import com.example.asm.entities.GioHang;
import com.example.asm.entities.GioHangChiTiet;
import com.example.asm.entities.TaiNghe;

import java.math.BigDecimal;
import java.util.List;

public interface IGioHangChiTietService {

    List<GioHangChiTiet> getByGh(GioHang gh);

    GioHangChiTiet getByTaiNgheAndGh(TaiNghe tn, GioHang gh);

    GioHangChiTiet saveGHCT(GioHangChiTiet ghct);

    void deleteGHCT(GioHangChiTiet ghct);

}
