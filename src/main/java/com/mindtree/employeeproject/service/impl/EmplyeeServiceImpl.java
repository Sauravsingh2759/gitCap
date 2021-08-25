package com.mindtree.employeeproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.employeeproject.dao.Employeedao;
import com.mindtree.employeeproject.entity.Employe;
import com.mindtree.employeeproject.exception.EmployeeIdNotFoundException;
import com.mindtree.employeeproject.exception.EmployeeInputMismatchException;
import com.mindtree.employeeproject.exception.EmployyeeProjectApplicationServiceException;
import com.mindtree.employeeproject.service.EmployeeService;

@Service
public class EmplyeeServiceImpl implements EmployeeService {

	@Autowired
	private Employeedao employeeDao;

	@Override
	public Employe addEmployee(Employe employee) {

		employeeDao.save(employee);
		return employee;
	}

	@Override
	public Optional<Employe> getEmployeeById(int employeeId) throws EmployyeeProjectApplicationServiceException {

		if (employeeId <= 0) {
			throw new EmployeeInputMismatchException("ID Cannotbe negative");
		}
		Optional<Employe> emp  = Optional.of(employeeDao.findById(employeeId).orElseThrow(()-> new EmployeeIdNotFoundException("Employee id not present")));
		
		
//		if (!emp.isPresent()) {
//			throw new EmployeeIdNotFoundException("Employee id not present");
//		}

		return emp;
		// return emp;
	}

	@Override
	public List<Employe> getAllEmployee() {
		return employeeDao.findAll();
	}

	@Override
	public Employe updateEmployeeSalary(int id, long salary) {
		Employe emp = employeeDao.findById(id).get();
		emp.setSalary(salary);
		return employeeDao.save(emp);
	}

	@Override
	public String deleteEmployeeById(int employeeId) throws EmployyeeProjectApplicationServiceException {
		if (employeeId <= 0) {
			throw new EmployeeInputMismatchException("ID Cannotbe negative");
		}
		Optional<Employe> emp  = Optional.of(employeeDao.findById(employeeId).orElseThrow(()-> new EmployeeIdNotFoundException("Employee id not present")));
//		if (!emp.isPresent()) {
//			throw new EmployeeIdNotFoundException("Employee id not present");
//		}
		employeeDao.deleteById(employeeId);
		return "Deleted";
	}

	@Override
	public List<Employe> getAllEmployeeSortedBySalary(long salary) {
		return employeeDao.findBySalarySorted(salary);
	}

}
