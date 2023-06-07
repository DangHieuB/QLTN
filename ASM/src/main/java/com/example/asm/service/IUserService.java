package com.example.asm.service;

import com.example.asm.entities.User;

public interface IUserService{

    User getById(Integer id);

    void addUser(User u);

    void updateUser(User u);

    User getByEmail(String email);
}
