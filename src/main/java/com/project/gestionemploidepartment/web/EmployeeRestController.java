package com.project.gestionemploidepartment.web;

import com.project.gestionemploidepartment.entities.Employee;
import com.project.gestionemploidepartment.models.EmployeeModel;
import com.project.gestionemploidepartment.services.DepartmentService;
import com.project.gestionemploidepartment.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;
    @PostMapping("/employees")
    void createEmployee(@RequestBody EmployeeModel e){
        Employee employee =new Employee();
        employee.setEmployeeLastname((e.getEmployeeLastname()));
        employee.setEmployeePhone(e.getEmployeePhoneNumber());
        employee.setEmployeeFirstname((e.getEmployeeFirstName()));
        employee.setDepartment(this.departmentService.findOneDepartment(e.getDepartmentId()));

        this.employeeService.createEmployee(employee);
    }
    @GetMapping("/employees")
    List<Employee> findAllEmployees(){
        return this.employeeService.getEmployee();
    }
    @GetMapping("/employees/{id}")
    Employee getOneEmployee(@PathVariable long id){
        return  this.employeeService.getOneEmployee(id);
    }
}
