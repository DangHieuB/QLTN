package com.example.asm.repository;

import com.example.asm.entities.GioHang;
import com.example.asm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGioHangRepository extends JpaRepository<GioHang, Integer> {
    GioHang getByUser(User user);
}
