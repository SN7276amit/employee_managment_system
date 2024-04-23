package com.qsp.employee_managment_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qsp.employee_managment_system.dto.Employee;
import com.qsp.employee_managment_system.repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	@Autowired
	private EmployeeRepo repo;

	public Employee save(Employee employee) {
		return repo.save(employee);
	}

	public List<Employee> saveMultiEmployees(List<Employee> list) {
		return repo.saveAll(list);
	}

	public Employee findById(int id) {
		Optional<Employee> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public List<Employee> findAllEmployees() {
		return repo.findAll();
	}

	public Employee findByPhone(long phone) {

		return repo.findByEmployeePhone(phone);
	}

	public Employee findByEmail(String email) {
		return repo.findByEmployeeEmail(email);
	}

	public List<Employee> findByName(String name) {
		return repo.findByEmployeeName(name);
	}

	public List<Employee> findByAddress(String address) {
		return repo.findByEmployeeAddress(address);
	}

	public List<Employee> findByDesignation(String designation) {
		return repo.findByEmployeeDesignation(designation);
	}

	public List<Employee> findBySalary(double salary) {
		return repo.findByEmployeeSalary(salary);
	}

	public Employee deleteEmployee(Employee employee) {
		repo.delete(employee);
		return employee;
	}

	public List<Employee> findByGrade(char grade) {
		return repo.findByEmployeeGrade(grade);
	}

	public List<Employee> findLessSalary(double salary) {
		return repo.findByEmployeeSalaryLessThan(salary);
	}

	public List<Employee> findGreaterSalary(double salary) {
		return repo.findByEmployeeSalaryGreaterThan(salary);
	}

	public List<Employee> findBetweenSalary(double salary1, double salary2) {
		return repo.employeeBySalaryBetween(salary1, salary2);
	}


}
