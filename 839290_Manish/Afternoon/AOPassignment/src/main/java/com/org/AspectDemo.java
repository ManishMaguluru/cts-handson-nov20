package com.org;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectDemo {

	@After("execution(public * com.org.EmployeeService.*(..))")
	public void log() {
		System.out.println("log For all methods and all type parameters");
	}
	
	@After("execution(public * com.org.EmployeeService.*(int))")
	public void logForIntType() {
		System.out.println("logForInt arguments passed");
	}
	
	@After("execution(public * com.org.EmployeeService.*(int,String))")
	public void logForIntAndStringType() {
		System.out.println("logForIntAndStringType arguments passed");
	}
	
	@After("execution(public * com.org.EmployeeService.*(int,*))")
	public void logForIntandAnyType() {
		System.out.println("logForIntandAnyType arguments passed");
	}
	
	@After("execution(public String com.org.EmployeeService.*(..))")
	public void logForStringReturnType() {
		System.out.println("log for string return type method");
	}
	
	
	
	
	
	
}
