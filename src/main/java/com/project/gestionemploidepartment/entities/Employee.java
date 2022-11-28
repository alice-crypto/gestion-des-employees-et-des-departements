package com.project.gestionemploidepartment.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String employeeFirstname;
    private String employeeLastname;
    private String employeePhone;
    @ManyToOne
    Department department;
}
