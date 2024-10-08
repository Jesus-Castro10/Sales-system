package com.educastro.sales.service;

import com.educastro.sales.model.dto.EmployeeDTO;
import com.educastro.sales.model.entities.Employee;

import java.util.List;

/**
 *
 * @author Jesus Castro
 */
public interface IEmployeeService {
    public List<Employee> toListEmployee();
    public Employee findEmployeeById(String idEmployee);
    public Employee saveEmployee(EmployeeDTO employeeDTO);
    public Employee updateEmployee(String idEmployee,EmployeeDTO employeeDTO);
    public void deleteEmployee(String idEmployee);
}
