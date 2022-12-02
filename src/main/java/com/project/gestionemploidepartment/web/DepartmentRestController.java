package com.project.gestionemploidepartment.web;

import com.project.gestionemploidepartment.entities.Department;
import com.project.gestionemploidepartment.models.DepartmentModel;
import com.project.gestionemploidepartment.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class DepartmentRestController {
    @Autowired
    DepartmentService departmentService;
    @PostMapping("/departments")
    @CrossOrigin
    void createDepartment(@RequestBody DepartmentModel model){
        Department department = new Department();
        department.setDepartmentName(model.getDepartmentName());
        this.departmentService.createDepartment(department);
    }
    @GetMapping("/departments")
    @CrossOrigin
    List<Department> Department(){
        return  this.departmentService.findDepartments();
    }
    @GetMapping("/departments/{id}")
    @CrossOrigin
    Department getOneDepartment(@PathVariable long id){
        return this.departmentService.findOneDepartment(id);
    }
}
