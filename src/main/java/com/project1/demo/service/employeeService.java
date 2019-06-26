package com.project1.demo.service;

import com.project1.demo.Repository.employeeRepository;
import com.project1.demo.entity.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Service
public class employeeService {

    @Autowired
    public employeeRepository employeeRepository;

    public Page<employee> getAllEmployees(Pageable pageable){
        return employeeRepository.findAll(pageable);
    }
    public employee createEmployee(@Valid @RequestBody employee employee){
        return employeeRepository.save(employee);
    }
    public List<employee> getEmployees(){
        return employeeRepository.findE();
    }
}
