package com.project1.demo.service;

import com.project1.demo.Repository.employeeRepository;
import com.project1.demo.Repository.taskRepository;
import com.project1.demo.entity.employee;
import com.project1.demo.entity.task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import javax.validation.Valid;
import java.util.Optional;

@Service
public class taskService {


    @Autowired
    private taskRepository taskRepository;

    @Autowired
    private employeeRepository employeeRepository;

    public Page<task> getAllTaskByEmployee(int employeeID, Pageable pageable){

        return taskRepository.findByEmployeeId(employeeID,pageable);
    }

    public task createTask( int employeeID, task task) {

        Optional<employee> emp = employeeRepository.findById(employeeID);
        emp.ifPresent(employee->{task.setEmployee(employee);});
        return taskRepository.save(task);
        /*return employeeRepository.findById(employeeID).map(employee -> {
            task.setEmployee(employee);
            task.setDescription(task.getDescription());
            task.setEnd_date(task.getEnd_date());
            return taskRepository.save(task);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + employeeID + " not found"));*/
    }
}
