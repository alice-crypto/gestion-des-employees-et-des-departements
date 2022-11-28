package com.project.gestionemploidepartment.services;

import com.project.gestionemploidepartment.entities.Employee;

import java.util.List;

public interface EmployeeService {
    void createEmployee(Employee e);
    List<Employee> getEmployee();
    Employee getOneEmployee(long id);
}
