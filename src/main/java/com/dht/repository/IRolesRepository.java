package com.dht.repository;

import com.dht.pojo.Role;

import java.util.List;

public interface IRolesRepository {
    List<Role> getAllRole();
    Role getRoleById(String id);
    boolean deleteRole(String roleId);
    boolean addRole(Role role);
    boolean updateRole(Role role);
}
