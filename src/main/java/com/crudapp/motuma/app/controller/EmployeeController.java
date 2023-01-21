package com.crudapp.motuma.app.controller;

import com.crudapp.motuma.app.exception.ResourceNotFoundException;
import com.crudapp.motuma.app.model.Employee;
import com.crudapp.motuma.app.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("motuma/coop")
public class EmployeeController {
    //Inject it first
    public EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    //Build Post mapping to create the employee
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }
    //Get all employee api
    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }
    //Build the api to get employee only their id.
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeId) {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeId), HttpStatus.OK);
    }
    //Now create Update api
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id
                                                   ,@RequestBody Employee employee){
        return  new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK);
    }
    //delete api
//    @DeleteMapping("{id}")
//    public void  deleteEmployee(@PathVariable("id") long id){
//     employeeService.deleteEmployeeById(id);
//    }
    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteEmployeeById(@PathVariable("id") long id){
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<String>("Employee Deleted Succesfully",HttpStatus.OK);
    }
}
