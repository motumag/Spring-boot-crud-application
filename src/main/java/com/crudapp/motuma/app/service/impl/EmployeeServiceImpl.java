package com.crudapp.motuma.app.service.impl;

import com.crudapp.motuma.app.exception.ResourceNotFoundException;
import com.crudapp.motuma.app.model.Employee;
import com.crudapp.motuma.app.repository.EmployeeRepository;
import com.crudapp.motuma.app.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService { //the keyword should be implement not extend.
//we have to inject here before implement. Constructor injection
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
//        Optional<Employee> employee=employeeRepository.findById(id); //not findAllById() method.carefull here
//        if(employee.isPresent()){
//            return employee.get();
//        }
//        else {
//            throw new ResourceNotFoundException("Employee","Id",id);
//        }
        //LET US USE ANAOTHER VERY EFFECTIVE CODE, just one line of code
        return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","Id",id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        //we need to cheek as the employee is available on db or not.
        //employee-> the data come from the client
        //employeeRepository is the DATA which we get from db and also save to db
        Employee existingEmployee=employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","id", id));
        existingEmployee.setFirtName(employee.getFirtName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployeeById(long id) {
        employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
        employeeRepository.deleteById(id);
    }

}
