package com.org;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeService extends Employee{

		List<Employee> employees = new ArrayList<Employee>();
		
	
	public Employee addEmployee(Employee emp) {
		Employee employee = new Employee();
		employees.add(emp);
		return employee;
		
	}
	
	public List<Employee> fetchEmployeeList() {
		List<Employee> empList = new ArrayList<Employee>();
		for(Employee employee : employees) {
			empList.add(employee);
			//System.out.println(employee);
		}
		return empList;
	}
	
	public String findById(int id) {
		
		String fName = "Not Found";
		for(Employee emp : employees)
		{
			if (emp.getId() == id)
			{
				fName = emp.getName();
			}
		}
		return fName;
	}

	public List<Employee> sortById() {
		List<Employee> empList = new ArrayList<Employee>();
		for(Employee emp : employees)
		{
			empList.add(emp);
		}
		Collections.sort(empList, new Comparator<Employee>() {

			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getId() - e2.getId();
			}
		});
		
		return empList;
	}
	
	public List<Employee> sortByDob() {
		List<Employee> empList = new ArrayList<Employee>();
		for(Employee emp : employees)
		{
			empList.add(emp);
		}
		Collections.sort(empList, new Comparator<Employee>() {

			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getDob().compareTo(e2.getDob());
			}
		});
		return empList;
	}
	
	public List<Employee> sortBySalary() {
		List<Employee> empList = new ArrayList<Employee>();
		for(Employee emp : employees)
		{
			empList.add(emp);
		}
		Collections.sort(empList, new Comparator<Employee>() {

			@Override
			public int compare(Employee e1, Employee e2) {
				return Double.compare(e1.getSalary(), e2.getSalary());
			}
		});
		return empList;
	}
	
	public List<Employee> sortByName() {
		List<Employee> empList = new ArrayList<Employee>();
		for(Employee emp : employees)
		{
			empList.add(emp);
		}
		Collections.sort(empList, new Comparator<Employee>() {

			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getName().compareTo(e2.getName());
			}
		});
		return empList;
	}

}
