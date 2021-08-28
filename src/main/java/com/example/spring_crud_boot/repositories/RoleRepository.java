package com.example.spring_crud_boot.repositories;

import com.example.spring_crud_boot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role getRoleByName(String name);
}
