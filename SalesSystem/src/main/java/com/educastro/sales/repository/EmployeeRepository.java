package com.educastro.sales.repository;

import com.educastro.sales.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jesus Castro
 */
public interface EmployeeRepository extends JpaRepository<Employee,String>{
    
}
