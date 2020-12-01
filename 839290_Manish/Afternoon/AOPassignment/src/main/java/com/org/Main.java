package com.org;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		EmployeeService service = (EmployeeService) context.getBean("employeeService");

		service.store();
		service.addEmployee();
		service.getEmployees(10,"m");
		service.numberOfEmployees(10);
		service.getEmployeesData(101, 20000);
	}

}
