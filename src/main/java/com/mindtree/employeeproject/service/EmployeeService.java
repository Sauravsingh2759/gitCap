package com.mindtree.employeeproject.service;

import java.util.List;
import java.util.Optional;

import com.mindtree.employeeproject.entity.Employe;
import com.mindtree.employeeproject.exception.EmployyeeProjectApplicationServiceException;

public interface EmployeeService {

	public Employe addEmployee(Employe employee);

	public Optional<Employe> getEmployeeById(int employeeId) throws  EmployyeeProjectApplicationServiceException;

	public List<Employe> getAllEmployee();

	public String deleteEmployeeById(int employeeId) throws EmployyeeProjectApplicationServiceException;

	public Employe updateEmployeeSalary(int id, long salary);

	public List<Employe> getAllEmployeeSortedBySalary(long salary);

}
