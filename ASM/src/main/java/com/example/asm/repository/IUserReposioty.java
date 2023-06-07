package com.example.asm.repository;

import com.example.asm.entities.Role;
import com.example.asm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserReposioty extends JpaRepository<User, Integer> {

    User getById(Integer id);

    User getByEmail(String email);
}
