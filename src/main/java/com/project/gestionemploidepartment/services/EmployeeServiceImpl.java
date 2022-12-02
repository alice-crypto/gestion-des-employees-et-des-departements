package com.project.gestionemploidepartment.services;

import com.project.gestionemploidepartment.entities.Employee;
import com.project.gestionemploidepartment.repositories.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, Object> findAllEmployees(int page, int size) {
        try{
            List<Employee> employeeList = new ArrayList<>();
            Pageable paging = PageRequest.of(page,size);
            Page<Employee> pageEmployee= this.employeeRepository.findAll(paging);
            employeeList =pageEmployee.getContent();
            Map<String, Object> employees = new HashMap<>();
            employees.put("employees",employeeList);
            employees.put("pageCurrent", pageEmployee.getNumber());
            employees.put("totalsItems", pageEmployee.getTotalElements());
            employees.put("totlaPage",pageEmployee.getTotalPages());
            return employees;
        }catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }
}
