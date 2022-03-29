package com.tech.employeesApi.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.employeesApi.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}