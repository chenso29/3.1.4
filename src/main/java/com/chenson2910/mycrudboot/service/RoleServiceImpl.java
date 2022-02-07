package com.chenson2910.mycrudboot.service;

import com.chenson2910.mycrudboot.model.Role;
import com.chenson2910.mycrudboot.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.getRoleByName(name);
    }

    @Override
    public Iterable<Role> findAllRoles() {
        return roleRepository.findAll();
    }
}
