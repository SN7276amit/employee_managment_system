package com.qsp.employee_managment_system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.employee_managment_system.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	Employee findByEmployeePhone(long phone); 
	Employee findByEmployeeEmail(String email);
	List<Employee> findByEmployeeName(String name);
	List<Employee> findByEmployeeAddress(String address);
	List<Employee> findByEmployeeDesignation(String designation);
	List<Employee> findByEmployeeSalary(double salary);
	List<Employee> findByEmployeeGrade(char grade);
	@Query("SELECT e FROM Employee e WHERE e.employeeSalary<=?1")
	List<Employee> findByEmployeeSalaryLessThan(double salary);
	@Query("SELECT e FROM Employee e WHERE e.employeeSalary>=?1")
	List<Employee> findByEmployeeSalaryGreaterThan(double salary);
	@Query("SELECT e FROM Employee e WHERE e.employeeSalary BETWEEN ?1 AND ?2") 
	//@Query("SELECT e FROM Employee e WHERE e.employeeSalary>=?1 AND e.employeeSalary<=?2")
	List<Employee> employeeBySalaryBetween(double salary1,double salary2);

}
