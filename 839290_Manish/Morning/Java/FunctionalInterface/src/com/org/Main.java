package com.org;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		EmployeeService e = new EmployeeService();
		
		int flag = 1;
		while (flag!=0)
		{
			      System.out.println("Enter your choice: \n1.addEmployee \n2.findEmployee \n3.getEmployees \n4.EmployeesSortById"
					+ "\n5.EmployeesSortByDOB \n6.EmployeesSortBySalary \n7.EmployeesSortByName \n8.Exit");
			int ch = scan.nextInt();
			switch(ch) {
			
			case 1 : 	System.out.println("Enter Employee ID: ");
						int empId = scan.nextInt();
						System.out.println("Enter Employee Name: ");
						String name = scan.next();
						System.out.println("Enter Date of birth: ");
						String dob = scan.next();
						LocalDate dobf = LocalDate.parse(dob);
						System.out.println("Enter Salary: ");
						double salary = scan.nextDouble();
						
						Employee employee = new Employee(empId,name,dobf,salary);
						e.addEmployee(employee);
						break;
						
			case 2: 	System.out.println("Enter empId to find");
						int findId = scan.nextInt();
						String empName = e.findById(findId);
						System.out.println("Your searching employee Name: "+empName);
						break;
						
			case 3 :  	System.out.println("List of Employees: ");
						List<Employee> empList = e.fetchEmployeeList();
						System.out.println(empList);
						break;
						
			case 4 :    System.out.println("Employee List Sort by Id: ");
						List<Employee> empSortById =e.sortById();
						System.out.println(empSortById);
						break;
			
			case 5 :    System.out.println("Employee List Sort by date of birth: ");
						List<Employee> empSortByDob = e.sortByDob();
						System.out.println(empSortByDob);
						break;
			
			case 6 :    System.out.println("Employee List Sort by salary: ");
						List<Employee> empSortBySalary = e.sortBySalary();
						System.out.println(empSortBySalary);
						break;
			
			case 7 :    System.out.println("Employee List Sort by name: ");
						List<Employee> empSortByName =  e.sortByName();
						System.out.println(empSortByName);
						break;
			
			case 8 :   System.out.println("Exit");
						flag = 0;
						break;
			}
		
		}	
	}

}
