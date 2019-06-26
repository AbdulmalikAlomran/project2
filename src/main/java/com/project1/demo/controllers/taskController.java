package com.project1.demo.controllers;

import com.project1.demo.Repository.employeeRepository;
import com.project1.demo.Repository.taskRepository;
import com.project1.demo.entity.employee;
import com.project1.demo.entity.task;
import com.project1.demo.service.taskService;
import javafx.concurrent.Task;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class taskController {


@Autowired
   private taskService taskService;

    @GetMapping("/employees/{employeeID}/task")
    public  Page<task> getAllTaskByEmployee(@PathVariable (value="employeeID") int employeeID, Pageable pageable){

        return taskService.getAllTaskByEmployee(employeeID,pageable);
    }
    @PostMapping("/employees/{employeeID}/tasks")
    public task createTask(@PathVariable (value = "employeeID") int employeeID, @Valid @RequestBody task task) {

        return taskService.createTask(employeeID,task);
        /*return employeeRepository.findById(employeeID).map(employee -> {
            task.setEmployee(employee);
            task.setDescription(task.getDescription());
            task.setEnd_date(task.getEnd_date());
            return taskRepository.save(task);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + employeeID + " not found"));*/
    }


}