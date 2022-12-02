package com.project.gestionemploidepartment.web;

import com.project.gestionemploidepartment.entities.Employee;
import com.project.gestionemploidepartment.models.EmployeeModel;
import com.project.gestionemploidepartment.services.DepartmentService;
import com.project.gestionemploidepartment.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;
    @PostMapping("/employees")
    @CrossOrigin
    void createEmployee(@RequestBody EmployeeModel e){
        Employee employee =new Employee();
        employee.setEmployeeLastname((e.getEmployeeLastname()));
        employee.setEmployeePhone(e.getEmployeePhoneNumber());
        employee.setEmployeeFirstname(e.getEmployeeFirstName());
        employee.setDepartment(this.departmentService.findOneDepartment(e.getDepartmentId()));

        this.employeeService.createEmployee(employee);
    }
    @GetMapping("/employees")
    @CrossOrigin
    List<Employee> findAllEmployees(){
        return this.employeeService.getEmployee();
    }
    @GetMapping("/employees/{id}")
    @CrossOrigin
    Employee getOneEmployee(@PathVariable long id){
        return  this.employeeService.getOneEmployee(id);
    }
    @GetMapping("/employees/paging")
    @CrossOrigin
    public ResponseEntity<Map<String, Object>> findAllByPaging(@RequestParam(defaultValue="0") int page,@RequestParam(defaultValue ="2")int size){
        return  new ResponseEntity<>(this.employeeService.findAllEmployees(page, size), HttpStatus.OK);
    }
}
