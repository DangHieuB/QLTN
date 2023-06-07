package com.example.asm.repository;

import com.example.asm.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
    Role getById(Integer id);
}
