package com.qsp.employee_managment_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.employee_managment_system.dao.EmployeeDao;
import com.qsp.employee_managment_system.dto.Employee;
import com.qsp.employee_managment_system.exception.DataNotFoundException;
import com.qsp.employee_managment_system.exception.EmailNotFoundException;
import com.qsp.employee_managment_system.exception.IdNotFoundException;
import com.qsp.employee_managment_system.exception.IncorrectPasswordException;
import com.qsp.employee_managment_system.exception.PhoneNotFoundException;
import com.qsp.employee_managment_system.util.RespoonceStructure;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao dao;

	public ResponseEntity<RespoonceStructure<Employee>> save(Employee employee) {
		double salary = employee.getEmployeeSalary();
		if (salary <= 10000) {
			employee.setEmployeeGrade('D');
		} else if (salary > 10000 && salary <= 20000) {
			employee.setEmployeeGrade('C');
		} else if (salary > 20000 && salary <= 40000) {
			employee.setEmployeeGrade('B');
		} else {
			employee.setEmployeeGrade('A');
		}
		RespoonceStructure<Employee> structure = new RespoonceStructure<Employee>();
		structure.setMessage("Signup Success");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.save(employee));
		return new ResponseEntity<RespoonceStructure<Employee>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<RespoonceStructure<List<Employee>>> saveMultiEmployees(List<Employee> list) {
		for (Employee employee : list) {
			double salary = employee.getEmployeeSalary();
			if (salary <= 10000) {
				employee.setEmployeeGrade('D');
			} else if (salary > 10000 && salary <= 20000) {
				employee.setEmployeeGrade('C');
			} else if (salary > 20000 && salary <= 40000) {
				employee.setEmployeeGrade('B');
			} else {
				employee.setEmployeeGrade('A');
			}
		}
		RespoonceStructure<List<Employee>> structure = new RespoonceStructure<>();
		structure.setMessage("all Signup Success");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveMultiEmployees(list));
		return new ResponseEntity<RespoonceStructure<List<Employee>>>(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<RespoonceStructure<Employee>> findById(int id) {
		Employee employee = dao.findById(id);
		RespoonceStructure<Employee> structure = new RespoonceStructure<Employee>();
		if (employee != null) {
			structure.setMessage("found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(employee);
			return new ResponseEntity<RespoonceStructure<Employee>>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("given Employee id not Found");
		}
	}

	public ResponseEntity<RespoonceStructure<List<Employee>>> findAllEmployees() {

		List<Employee> list = dao.findAllEmployees();
		RespoonceStructure<List<Employee>> structure = new RespoonceStructure<List<Employee>>();
		if (list != null) {
			structure.setMessage("found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<RespoonceStructure<List<Employee>>>(structure, HttpStatus.FOUND);
		} else {
			throw new DataNotFoundException("data not found");
		}

	}

	public ResponseEntity<RespoonceStructure<Employee>> findByPhone(long phone) {
		Employee employee = dao.findByPhone(phone);
		RespoonceStructure<Employee> structure = new RespoonceStructure<Employee>();
		if (employee != null) {
			structure.setMessage("found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(employee);
			return new ResponseEntity<RespoonceStructure<Employee>>(structure, HttpStatus.FOUND);
		} else {
			throw new PhoneNotFoundException("given Employee phone number not Found");
		}
	}

	public ResponseEntity<RespoonceStructure<Employee>> findByEmail(String email) {
		Employee employee = dao.findByEmail(email);
		RespoonceStructure<Employee> structure = new RespoonceStructure<Employee>();
		if (employee != null) {
			structure.setMessage("found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(employee);
			return new ResponseEntity<RespoonceStructure<Employee>>(structure, HttpStatus.FOUND);
		} else {
			throw new EmailNotFoundException("given Employee email not Found");
		}
	}

	public ResponseEntity<RespoonceStructure<Employee>> login(String email, String password) {
		Employee employee = dao.findByEmail(email);
		RespoonceStructure<Employee> structure = new RespoonceStructure<Employee>();
		if (employee != null) {
			if (password.equals(employee.getEmployeePassword())) {
				structure.setMessage("Login Successfully");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(employee);
				return new ResponseEntity<RespoonceStructure<Employee>>(structure, HttpStatus.OK);
			} else {
				throw new IncorrectPasswordException("incorrect password");
			}
		} else {
			throw new EmailNotFoundException("given email is incorrect");
		}
	}

	public ResponseEntity<RespoonceStructure<List<Employee>>> findByName(String name) {
		List<Employee> list = dao.findByName(name);
		RespoonceStructure<List<Employee>> structure = new RespoonceStructure<List<Employee>>();
		if (list != null) {
			structure.setMessage("found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<RespoonceStructure<List<Employee>>>(structure, HttpStatus.FOUND);
		} else {
			throw new DataNotFoundException("data not found");
		}
	}

	public ResponseEntity<RespoonceStructure<List<Employee>>> findByAddress(String address) {
		List<Employee> list = dao.findByAddress(address);
		RespoonceStructure<List<Employee>> structure = new RespoonceStructure<List<Employee>>();
		if (list != null) {
			structure.setMessage("found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<RespoonceStructure<List<Employee>>>(structure, HttpStatus.FOUND);
		} else {
			throw new DataNotFoundException("data not found");
		}
	}

	public ResponseEntity<RespoonceStructure<List<Employee>>> findByDesignation(String designation) {
		List<Employee> list = dao.findByDesignation(designation);
		RespoonceStructure<List<Employee>> structure = new RespoonceStructure<List<Employee>>();
		if (list != null) {
			structure.setMessage("found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<RespoonceStructure<List<Employee>>>(structure, HttpStatus.FOUND);
		} else {
			throw new DataNotFoundException("data not found");
		}
	}

	public ResponseEntity<RespoonceStructure<List<Employee>>> findBySalary(double salary) {
		List<Employee> list = dao.findBySalary(salary);
		RespoonceStructure<List<Employee>> structure = new RespoonceStructure<List<Employee>>();
		if (list != null) {
			structure.setMessage("found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<RespoonceStructure<List<Employee>>>(structure, HttpStatus.FOUND);
		} else {
			throw new DataNotFoundException("data not found");
		}
	}

	public ResponseEntity<RespoonceStructure<Employee>> deleteById(int id) {
		Employee employee = dao.findById(id);
		RespoonceStructure<Employee> structure = new RespoonceStructure<Employee>();
		if (employee != null) {
			structure.setMessage("delete successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteEmployee(employee));
			return new ResponseEntity<RespoonceStructure<Employee>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("given Employee id not Found");
		}
	}

	public ResponseEntity<RespoonceStructure<Employee>> deleteByPhone(long phone) {
		Employee employee = dao.findByPhone(phone);
		RespoonceStructure<Employee> structure = new RespoonceStructure<Employee>();
		if (employee != null) {
			structure.setMessage("delete successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteEmployee(employee));
			return new ResponseEntity<RespoonceStructure<Employee>>(structure, HttpStatus.OK);
		} else {
			throw new PhoneNotFoundException("given Employee phone number not Found");
		}
	}

	public ResponseEntity<RespoonceStructure<Employee>> deleteByEmail(String email) {
		Employee employee = dao.findByEmail(email);
		RespoonceStructure<Employee> structure = new RespoonceStructure<Employee>();
		if (employee != null) {
			structure.setMessage("delete successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteEmployee(employee));
			return new ResponseEntity<RespoonceStructure<Employee>>(structure, HttpStatus.OK);
		} else {
			throw new EmailNotFoundException("given Employee email not Found");
		}
	}

	public ResponseEntity<RespoonceStructure<Employee>> updateEmployee(int id, Employee employee) {
		RespoonceStructure<Employee> structure = new RespoonceStructure<Employee>();
		Employee dbemployee = dao.findById(id);
		if (dbemployee != null) {
			employee.setEmployeeId(id);
			double salary = employee.getEmployeeSalary();
			if (salary <= 10000) {
				employee.setEmployeeGrade('D');
			} else if (salary > 10000 && salary <= 20000) {
				employee.setEmployeeGrade('C');
			} else if (salary > 20000 && salary <= 40000) {
				employee.setEmployeeGrade('B');
			} else {
				employee.setEmployeeGrade('A');
			}
			structure.setMessage("update Success");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.save(employee));
			return new ResponseEntity<RespoonceStructure<Employee>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("given Employee id not Found");
		}
	}

	public ResponseEntity<RespoonceStructure<Employee>> updateSalary(int id, double salary) {
		Employee employee = dao.findById(id);
		RespoonceStructure<Employee> structure = new RespoonceStructure<Employee>();
		if (employee != null) {
			employee.setEmployeeSalary(salary);
			double salary2 = employee.getEmployeeSalary();
			if (salary2 <= 10000) {
				employee.setEmployeeGrade('D');
			} else if (salary2 > 10000 && salary2 <= 20000) {
				employee.setEmployeeGrade('C');
			} else if (salary2 > 20000 && salary2 <= 40000) {
				employee.setEmployeeGrade('B');
			} else {
				employee.setEmployeeGrade('A');
			}
			structure.setMessage("update Success");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.save(employee));
			return new ResponseEntity<RespoonceStructure<Employee>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("given Employee id not Found");
		}
	}

	public ResponseEntity<RespoonceStructure<Employee>> updateDesignation(int id, String designation) {
		RespoonceStructure<Employee> structure = new RespoonceStructure<Employee>();
		Employee employee = dao.findById(id);
		if (employee != null) {
			employee.setEmployeeDesignation(designation);
			structure.setMessage("update Success");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.save(employee));
			return new ResponseEntity<RespoonceStructure<Employee>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("given Employee id not Found");
		}
	}

	public ResponseEntity<RespoonceStructure<Employee>> updatePhone(int id, long phone) {
		Employee employee = dao.findById(id);
		RespoonceStructure<Employee> structure = new RespoonceStructure<Employee>();
		if (employee != null) {
			employee.setEmployeePhone(phone);
			structure.setMessage("update Success");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.save(employee));
			return new ResponseEntity<RespoonceStructure<Employee>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("given Employee id not Found");
		}
	}

	public ResponseEntity<RespoonceStructure<Employee>> updateEmail(int id, String email) {
		Employee employee = dao.findById(id);
		RespoonceStructure<Employee> structure = new RespoonceStructure<Employee>();
		if (employee != null) {
			employee.setEmployeeEmail(email);
			structure.setMessage("update Success");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.save(employee));
			return new ResponseEntity<RespoonceStructure<Employee>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("given Employee id not Found");
		}
	}

	public ResponseEntity<RespoonceStructure<Employee>> updateAddress(int id, String address) {
		Employee employee = dao.findById(id);
		RespoonceStructure<Employee> structure = new RespoonceStructure<Employee>();
		if (employee != null) {
			employee.setEmployeeAddress(address);
			structure.setMessage("update Success");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.save(employee));
			return new ResponseEntity<RespoonceStructure<Employee>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("given Employee id not Found");
		}
	}

	public ResponseEntity<RespoonceStructure<Employee>> updateName(int id, String name) {
		Employee employee = dao.findById(id);
		RespoonceStructure<Employee> structure = new RespoonceStructure<Employee>();
		if (employee != null) {
			employee.setEmployeeName(name);
			structure.setMessage("update Success");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.save(employee));
			return new ResponseEntity<RespoonceStructure<Employee>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("given Employee id not Found");
		}
	}

	public ResponseEntity<RespoonceStructure<Employee>> updatePassword(int id, String password) {
		Employee employee = dao.findById(id);
		RespoonceStructure<Employee> structure = new RespoonceStructure<Employee>();
		if (employee != null) {
			employee.setEmployeePassword(password);
			structure.setMessage("update Success");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.save(employee));
			return new ResponseEntity<RespoonceStructure<Employee>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("given Employee id not Found");
		}
	}

	public ResponseEntity<RespoonceStructure<List<Employee>>> findByGrade(char grade) {
		 List<Employee>list=dao.findByGrade(grade);
		 RespoonceStructure<List<Employee>> structure = new RespoonceStructure<List<Employee>>();
			if (list != null) {
				structure.setMessage("found");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(list);
				return new ResponseEntity<RespoonceStructure<List<Employee>>>(structure, HttpStatus.FOUND);
			} else {
				throw new DataNotFoundException("data not found");
			}
	}

	public ResponseEntity<RespoonceStructure<List<Employee>>> findLessSalary(double salary) {
		List< Employee>list=dao.findLessSalary(salary);
		RespoonceStructure<List<Employee>> structure = new RespoonceStructure<List<Employee>>();
		if (list != null) {
			structure.setMessage("found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<RespoonceStructure<List<Employee>>>(structure, HttpStatus.FOUND);
		} else {
			throw new DataNotFoundException("data not found");
		}
	}

	public ResponseEntity<RespoonceStructure<List<Employee>>> findGreaterSalary(double salary) {
	List<Employee >list=dao.findGreaterSalary(salary);
	RespoonceStructure<List<Employee>> structure = new RespoonceStructure<List<Employee>>();
	if (list != null) {
		structure.setMessage("found");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(list);
		return new ResponseEntity<RespoonceStructure<List<Employee>>>(structure, HttpStatus.FOUND);
	} else {
		throw new DataNotFoundException("data not found");
	}
	}

	public ResponseEntity<RespoonceStructure<List<Employee>>> findBetweenSalary(double salary1, double salary2) {
		List<Employee>list=dao.findBetweenSalary(salary1, salary2);
		RespoonceStructure<List<Employee>> structure = new RespoonceStructure<List<Employee>>();
		if (list != null) {
			structure.setMessage("found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<RespoonceStructure<List<Employee>>>(structure, HttpStatus.FOUND);
		} else {
			throw new DataNotFoundException("data not found");
		}
	}

}
