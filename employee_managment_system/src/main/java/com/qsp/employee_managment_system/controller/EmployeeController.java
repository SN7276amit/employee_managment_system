package com.qsp.employee_managment_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.qsp.employee_managment_system.dto.Employee;
import com.qsp.employee_managment_system.service.EmployeeService;
import com.qsp.employee_managment_system.util.RespoonceStructure;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/signup")
	public ResponseEntity<RespoonceStructure<Employee>> saveEmployee(@RequestBody Employee employee) {
		return service.save(employee);
	}
    @PostMapping("/save/all")
	public ResponseEntity<RespoonceStructure<List<Employee>>> saveMultiEmployees(@RequestBody List< Employee>list) {
        return service.saveMultiEmployees(list);
	}
    @GetMapping("/find")
    public ResponseEntity<RespoonceStructure<Employee>> findById(@RequestParam int id) {
		return service.findById(id);
	}
    @GetMapping("/find/all")
    public ResponseEntity<RespoonceStructure<List<Employee>>> findAllEmployees() {
		return service.findAllEmployees();
	}
    @GetMapping("/find/phone")
    public ResponseEntity<RespoonceStructure<Employee>> findByPhone(long phone) {
		return service.findByPhone(phone);
	}
    @GetMapping("/find/email")
    public ResponseEntity<RespoonceStructure<Employee>> findByEmail(String email) {
		return service.findByEmail(email);
	}
    @GetMapping("/login")
    public ResponseEntity<RespoonceStructure<Employee>> login(String email,String password) {
		return service.login(email,password);
	}
    @GetMapping("/find/name")
    public ResponseEntity<RespoonceStructure<List<Employee>>> findByName(String name) {
		return service.findByName(name);
	}
    @GetMapping("/find/address")
    public ResponseEntity<RespoonceStructure<List<Employee>>> findByAddress(String address) {
		return service.findByAddress(address);
	}
    @GetMapping("/find/designation")
    public ResponseEntity<RespoonceStructure<List<Employee>>> findByDesignation(String designation) {
		return service.findByDesignation(designation);
	}
    @GetMapping("/find/salary")
    public ResponseEntity<RespoonceStructure<List<Employee>>> findBySalary(double salary) {
		return service.findBySalary(salary);
	}
    @DeleteMapping("/delete/id")
    public ResponseEntity<RespoonceStructure<Employee>> deleteById(int id) {
		return service.deleteById(id);
	}
    @DeleteMapping("/delete/phone")
    public ResponseEntity<RespoonceStructure<Employee>> deleteByPhone(long phone) {
		return service.deleteByPhone(phone);
	}
    @DeleteMapping("/delete/email")
    public ResponseEntity<RespoonceStructure<Employee>> deleteByEmail(String email) {
		return service.deleteByEmail(email);
	}
    @PutMapping("/update")
    public ResponseEntity<RespoonceStructure<Employee>> updateEmployee(@RequestParam int id,@RequestBody Employee employee) {
		return service.updateEmployee(id, employee);
	}
    @PatchMapping("/update/salary")
    public ResponseEntity<RespoonceStructure<Employee>> updateSalary(int id,double salary) {
		return service.updateSalary(id,salary);
	}
    @PatchMapping("/update/designation")
    public ResponseEntity<RespoonceStructure<Employee>> updateDesignation(int id,String designation) {
		return service.updateDesignation(id,designation);
	}
    @PatchMapping("/update/phone")
    public ResponseEntity<RespoonceStructure<Employee>> updatePhone(int id,long phone) {
		return service.updatePhone(id,phone);
	}
    @PatchMapping("/update/email")
    public ResponseEntity<RespoonceStructure<Employee>> updateEmail(int id,String email) {
		return service.updateEmail(id,email);
	}
    @PatchMapping("/update/address")
    public ResponseEntity<RespoonceStructure<Employee>> updateAddress(int id,String address) {
		return service.updateAddress(id,address);
	}
    @PatchMapping("/update/name")
    public ResponseEntity<RespoonceStructure<Employee>> updateName(int id,String name) {
		return service.updateName(id,name);
	}
    @PatchMapping("/update/password")
    public ResponseEntity<RespoonceStructure<Employee>> updatePassword(int id,String password) {
		return service.updatePassword(id,password);
	}
    @GetMapping("/find/grade")
    public ResponseEntity<RespoonceStructure<List<Employee>>> findByGrade(char grade) {
		return service.findByGrade(grade);
	}
    @GetMapping("/find/lesssal")
    public ResponseEntity<RespoonceStructure<List<Employee>>> findLessSalary(double salary) {
		return service.findLessSalary(salary);
	}
    @GetMapping("/find/greatersal")
    public ResponseEntity<RespoonceStructure<List<Employee>>> findGreaterSalary(double salary) {
		return service.findGreaterSalary(salary);
	}
    @GetMapping("/find/between")
    public ResponseEntity<RespoonceStructure<List<Employee>>> findBetweenSalary(double salary1,double salary2) {
		return service.findBetweenSalary(salary1,salary2);
	}
    
    
}
