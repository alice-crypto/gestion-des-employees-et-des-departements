package com.project.gestionemploidepartment.services;

import com.project.gestionemploidepartment.entities.Employee;
import com.project.gestionemploidepartment.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{
    final private EmployeeRepository employeeRepository;
    public  EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
    @Override
    public void createEmployee(Employee e) {
        this.employeeRepository.save(e);
    }

    @Override
    public List<Employee> getEmployee() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getOneEmployee(long id) {
        return this.employeeRepository.findById(id).get();
    }
}
