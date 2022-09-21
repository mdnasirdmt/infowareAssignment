package com.infoware.service;

import java.util.List;

import com.infoware.model.Employee;

public interface EmployeeService {

	public Employee saveEmplyee(Employee employee);

	public List<Employee> getEmployee();

	public Employee getEmployeeId(long id);

	public Employee updateEmployee(Employee employee, long id);

	public void deleteEmployee(long id);

}
