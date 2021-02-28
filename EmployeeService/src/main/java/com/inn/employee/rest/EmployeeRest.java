package com.inn.employee.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inn.employee.dao.EmployeeDao;
import com.inn.employee.model.Employee;

@Controller
@RequestMapping(path = "EmployeeRest")
public class EmployeeRest {

	@Autowired
	EmployeeDao employeeDao;

	@GetMapping(path = "getAppEmployee")
	public @ResponseBody ResponseEntity<List<Employee>> getAppEmployee() {
		return ResponseEntity.ok(employeeDao.findAll());

	}

	@GetMapping(path = "getAppEmployeeByID/{id}")
	public @ResponseBody ResponseEntity<Employee> getAppEmployeeByID(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(employeeDao.findById(id).get());

	}

	@PostMapping(path = "addEmployeeDetails")
	public ResponseEntity<String> addEmployeeDetails(@RequestBody Employee employee) {
		employeeDao.save(employee);
		return ResponseEntity.ok("Employee Details added ...");

	}

	@PatchMapping(path = "updateEmployeeDetails/{id}")
	public ResponseEntity<String> updateEmployeeDetails(@RequestBody Employee employee,
			@PathVariable("id") Integer id) {
		Optional<Employee> emplayeeupdate = employeeDao.findById(id);
		if (!emplayeeupdate.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Employee patch = emplayeeupdate.get();
		if (patch.getName() != null) {
			patch.setName(employee.getName());
		}
		if (patch.getSalary() != null) {
			patch.setSalary(employee.getSalary());
		}
		employeeDao.save(patch);
		return ResponseEntity.ok("Employee Details updated");

	}

	@DeleteMapping(path = "deleteEmployeeDetails/{id}")
	public ResponseEntity<String> deleteEmployeeDetails(@PathVariable("id") Integer id) {
		System.out.println("Going to delete id" + id);
		employeeDao.deleteById(id);
		return ResponseEntity.ok("Employee Details deleted ..");

	}

}
