package com.dht.service.Implement;

import com.dht.pojo.Department;
import com.dht.repository.IDepartmentsRepository;
import com.dht.service.IDepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentsServiceImplement implements IDepartmentsService {

    @Autowired
    private IDepartmentsRepository departmentsRepository;

    @Override
    public List<Department> getAllDepartments() {
        return this.departmentsRepository.getAllDepartments();
    }

    @Override
    public Department getDepartmentById(String id) {
        return this.departmentsRepository.getDepartmentById(id);
    }

    @Override
    public boolean deleteDepartment(String departmentId) {
        return this.departmentsRepository.deleteDepartment(departmentId);
    }

    @Override
    public boolean addDepartment(Department department) {
        return this.departmentsRepository.addDepartment(department);
    }

    @Override
    public boolean updateDepartment(Department department) {
        return this.departmentsRepository.updateDepartment(department);
    }
}
