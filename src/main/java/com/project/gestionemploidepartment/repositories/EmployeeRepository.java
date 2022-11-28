package com.project.gestionemploidepartment.repositories;

import com.project.gestionemploidepartment.entities.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
