package com.project1.demo.controllers;


import com.project1.demo.Repository.employeeRepository;
import com.project1.demo.entity.employee;
import com.project1.demo.service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class employeeController {



    @Autowired
   private employeeService employeeService;




    @GetMapping("/employees")
    public Page<employee> getAllEmployees(Pageable pageable){
        return employeeService.getAllEmployees(pageable);
    }

    @PostMapping("/employees")
    public employee createEmployee(@Valid @RequestBody employee employee){
        return employeeService.createEmployee(employee);
    }
    @GetMapping("/findEmployeeWithIDGreaterThan1")
    public List<employee> getEmployees(){
        return employeeService.getEmployees();
    }


}
