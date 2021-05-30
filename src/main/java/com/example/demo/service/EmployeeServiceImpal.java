package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpal implements IEmployeeService {
	@Autowired
	private EmployeeRepository repo;

	@Override
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
	}

	@Override
	@CachePut(value = "updating data by id", key = "employee")
	public Employee updateEmployee(Integer id, Employee employee) {
		// TODO Auto-generated method stub

		Employee employee2 = repo.findById(id).get();
		if (employee2 != null) {
			employee2.setEmpId(employee2.getEmpId());
			employee2.setEmpNmae(employee2.getEmpNmae());
			employee2.setEmpsal(employee2.getEmpsal());
			Employee save = repo.save(employee2);
			return save;
		} else {
			throw new RuntimeException("I cant update the data through this id");
		}

	}

	@Override
	@CacheEvict(value = "updating data by id", allEntries = true)
	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub

		if (id != null) {
			repo.deleteById(id);

		} else {
			throw new RuntimeException("No object s their to delete");
		}

	}

	@Override
	@Cacheable(value = "finding data by id", key = "id")
	public Employee getOneEmployee(Integer id) {
		// TODO Auto-generated method stub
		Optional<Employee> findById = repo.findById(id);
		Employee employee2 = findById.get();
		return employee2;
	}

	@Override
	public List<Employee> getAllEmployess() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
