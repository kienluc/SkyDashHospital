package com.dht.repository;

import com.dht.pojo.Department;

import java.util.List;

public interface IDepartmentsRepository {
    List<Department> getAllDepartments();
    Department getDepartmentById(String id);
    boolean deleteDepartment(String departmentId);
    boolean addDepartment(Department department);
    boolean updateDepartment(Department department);
}
