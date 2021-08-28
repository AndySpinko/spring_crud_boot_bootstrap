package com.example.spring_crud_boot.service;


import com.example.spring_crud_boot.model.Role;

import java.util.List;

public interface RoleService {

    Role getRoleByName(String name);

    Role getRoleById(Long id);

    List<Role> allRoles();
}
