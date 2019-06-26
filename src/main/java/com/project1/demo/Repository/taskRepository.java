package com.project1.demo.Repository;

import com.project1.demo.entity.task;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface taskRepository extends JpaRepository<task, Integer> {
    Page<task> findByEmployeeId(int employeeId, Pageable pageable);
    Optional<task> findByIdAndEmployeeId(int id, int employeeId);



}
