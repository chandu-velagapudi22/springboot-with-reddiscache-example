package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public interface IEmployeeService {

	public Employee saveEmployee(Employee employee);

	public Employee updateEmployee(Integer id, Employee employee);

	public void deleteEmployee(Integer id);

	public Employee getOneEmployee(Integer id);

	public List<Employee> getAllEmployess();
}
