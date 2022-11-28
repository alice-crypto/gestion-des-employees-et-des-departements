package com.project.gestionemploidepartment.repositories;

import com.project.gestionemploidepartment.entities.Department;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
