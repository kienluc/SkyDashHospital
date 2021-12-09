package com.dht.service.Implement;

import com.dht.pojo.Role;
import com.dht.repository.IRolesRepository;
import com.dht.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImplement implements IRolesService {

    @Autowired
    private IRolesRepository rolesRepository;

    @Override
    public List<Role> getAllRole() {
        return this.rolesRepository.getAllRole();
    }

    @Override
    public Role getRoleById(String id) {
        return this.rolesRepository.getRoleById(id);
    }

    @Override
    public boolean deleteRole(String roleId) {
        return this.rolesRepository.deleteRole(roleId);
    }

    @Override
    public boolean addRole(Role role) {
        return this.rolesRepository.addRole(role);
    }

    @Override
    public boolean updateRole(Role role) {
        return this.rolesRepository.updateRole(role);
    }
}
