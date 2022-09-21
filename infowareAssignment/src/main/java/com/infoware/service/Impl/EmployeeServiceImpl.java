package com.infoware.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.infoware.exception.ResourceNotFoundException;
import com.infoware.model.Employee;
import com.infoware.repository.EmployeeRepository;
import com.infoware.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	

	@Override
	public Employee saveEmplyee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	

	@Override
	public List<Employee> getEmployee() {
		
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeId(long id) {
		Optional<Employee> employee= employeeRepository.findById(id);
		
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee", "id", id);
//		}
		return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "id", id));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		//we need check employee is exsisting or not
		Employee exsistingEmployee= employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("EMployee", "Id", id));
		
		exsistingEmployee.setFirstname(employee.getFirstname());
		exsistingEmployee.setLastname(employee.getLastname());
		exsistingEmployee.setEmail(employee.getEmail());

		
		//save the db
		employeeRepository.save(exsistingEmployee);
		return exsistingEmployee;
	}

	
	
	@Override
	public void deleteEmployee(long id) {
		
		employeeRepository.findById(id).orElseThrow(()-> 
							new ResourceNotFoundException("Employee", "Id", id));
		
		employeeRepository.deleteById(id);
		
	}
	
	
	
	

}
