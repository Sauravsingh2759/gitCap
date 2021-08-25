package com.mindtree.employeeproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.employeeproject.entity.Employe;
import com.mindtree.employeeproject.exception.EmployeeProjectApplicationException;
import com.mindtree.employeeproject.service.EmployeeService;

@RestController
public class Controller {
	@Autowired
	private  EmployeeService employeeService;
	
	
	@PostMapping("/add-employee")
	public Employe addEmployee(@RequestBody Employe employee) {
		return this.employeeService.addEmployee(employee);
	}
	
	@GetMapping("/employee/{id}")
	public Optional<Employe> getEmployeeById(@PathVariable int id) throws EmployeeProjectApplicationException {
		return this.employeeService.getEmployeeById(id);
	}
//	@GetMapping("/employee/{id}")
//	public ResponseEntity<Employe> getEmployeeById(@PathVariable int id) throws EmployeeProjectApplicationException {
//		if(id<3)
//		{
//			return new ResponseEntity<Employe>(HttpStatus.OK);
//		}
//		else
//		{
//			return new ResponseEntity<Employe>(HttpStatus.BAD_REQUEST);
//		}
	
	
	@GetMapping("/employee")
	public List<Employe> getAllEmployee(){
		return this.employeeService.getAllEmployee();
	}
	
	@PostMapping("/employee/{id}/{salary}")
	public Employe updateEmployeeSalary(@RequestBody @PathVariable int id,@PathVariable long salary) {
		return this.employeeService.updateEmployeeSalary(id,salary);
	}
	
	@GetMapping("/employee/sorted/{salary}")
	public List<Employe> getAllEmployeeSortedBySalary(@PathVariable long salary){
		
		return this.employeeService.getAllEmployeeSortedBySalary(salary);
	}

}
