package com.org;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	public void store() {
		System.out.println("store() 1inside EmployeeService");
	}
	public void getEmployees(int id,String name)
	{
		System.out.println("getEmployees() inside EmployeeService");
	}
	
	public String addEmployee()
	{
		String s = null;
		System.out.println("addEmployee() Return type string");
		return s;
	}
	
	public void numberOfEmployees(int id) {
		System.out.println("noOfEmployees(int id) Int parameter is passed");
	}
	
	public void getEmployeesData(int id,double salary)
	{
		System.out.println("getEmployeesData() inside EmployeeService int and any parameter is passed");
	}
	
	
}
