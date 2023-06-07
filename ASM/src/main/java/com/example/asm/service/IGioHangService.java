package com.example.asm.service;

import com.example.asm.entities.GioHang;
import com.example.asm.entities.User;

import java.math.BigDecimal;

public interface IGioHangService {

    GioHang save(GioHang gh);

    GioHang getByUser(User user);

    BigDecimal tongTien(GioHang gh);
}
