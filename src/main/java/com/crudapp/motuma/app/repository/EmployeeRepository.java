package com.crudapp.motuma.app.repository;

import com.crudapp.motuma.app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//This is the repository which used to access of data from entity.
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
