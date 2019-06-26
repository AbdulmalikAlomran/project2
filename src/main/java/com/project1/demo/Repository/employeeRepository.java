package com.project1.demo.Repository;

import com.project1.demo.entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface employeeRepository extends JpaRepository<employee, Integer> {

    @Query(value = "select * from employee e where e.id <= 1 ;" , nativeQuery = true)
    public List<employee> findE();
}
