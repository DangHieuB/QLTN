package com.example.asm.service.impl;

import com.example.asm.entities.Role;
import com.example.asm.repository.IRoleRepository;
import com.example.asm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("RoleService")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    IRoleRepository repository;

    @Override
    public Role getById(Integer id) {
        return repository.getById(id);
    }
}
