package com.example.asm.service.impl;

import com.example.asm.entities.Role;
import com.example.asm.entities.User;
import com.example.asm.repository.IUserReposioty;
import com.example.asm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserReposioty reposioty;

    @Override
    public User getById(Integer id) {
        return reposioty.getById(id);
    }

    @Override
    public void addUser(User u) {
        reposioty.save(u);
    }

    @Override
    public void updateUser(User u) {
        reposioty.save(u);
    }

    @Override
    public User getByEmail(String email) {
        return reposioty.getByEmail(email);
    }
}
