package com.project.gestionemploidepartment.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {
    private String employeeFirstName;
    private  String employeeLastname;
    private String employeePhoneNumber;
    private long departmentId;
}
