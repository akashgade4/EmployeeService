package com.inn.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn.employee.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
