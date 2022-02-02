package com.chenson2910.mycrudboot.repository;

import com.chenson2910.mycrudboot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role getRoleByName(String name);
}
