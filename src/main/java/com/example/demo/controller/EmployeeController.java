package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.IEmployeeService;

@RestController
@RequestMapping("/employe")
public class EmployeeController {

	@Autowired
	private IEmployeeService serviceImpal;

	@PostMapping("/save")
	public String saveEmployee(Employee employee) {
		Employee saveEmployee = serviceImpal.saveEmployee(employee);
		return "I AM SAVING THE EMPLOYEE" + " " + saveEmployee;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployess() {
		return ResponseEntity.ok(serviceImpal.getAllEmployess());
	}

	@GetMapping("/one/{id}")
	public Employee getOneEmployee(@PathVariable Integer Id) {
		return serviceImpal.getOneEmployee(Id);
	}

	@PutMapping("/modifiy/{id}")
	public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
		Employee updateEmployee = serviceImpal.updateEmployee(id, employee);
		return updateEmployee;

	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		serviceImpal.deleteEmployee(id);
		return "DATA IS DELETED SUCESSFULLY By This id::" + id;

	}
}
