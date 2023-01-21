package com.crudapp.motuma.app.service;

import com.crudapp.motuma.app.model.Employee;

import java.util.List;
import java.util.Locale;
public interface EmployeeService {
    Employee saveEmployee (Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(long id);
    Employee updateEmployee (Employee employee, long id);

    public void deleteEmployeeById(long id);
}
