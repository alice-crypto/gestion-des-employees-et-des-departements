package com.project.gestionemploidepartment.services;

import com.project.gestionemploidepartment.entities.Employee;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface EmployeeService {
    void createEmployee(Employee e);
    List<Employee> getEmployee();
    Employee getOneEmployee(long id);
    Map<String, Object> findAllEmployees(int page, int size);
}
