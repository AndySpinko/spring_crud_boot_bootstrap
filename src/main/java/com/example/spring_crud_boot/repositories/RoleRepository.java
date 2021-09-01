package com.example.spring_crud_boot.repositories;

import com.example.spring_crud_boot.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {
}

