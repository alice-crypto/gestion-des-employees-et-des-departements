package com.project.gestionemploidepartment.services;

import com.project.gestionemploidepartment.entities.Department;

import java.util.List;

public interface DepartmentService {

    void createDepartment(Department d);
    List<Department> findDepartments();
    Department findOneDepartment (long id);


}
