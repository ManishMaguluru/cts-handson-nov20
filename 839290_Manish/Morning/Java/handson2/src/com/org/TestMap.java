package com.org;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMap {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		List<Student> csStudent = new ArrayList<Student>();
		List<Student> ecStudent = new ArrayList<Student>();
		
		Map<String,List> studentData = new HashMap<String,List>();
		
		csStudent.add(new Student(1,"Manish","CSE"));
		csStudent.add(new Student(2,"Sai","CSE"));
		csStudent.add(new Student(3,"Venkat","CSE"));
		ecStudent.add(new Student(1,"Koushik","ECE"));
		ecStudent.add(new Student(2,"Karthik","ECE"));
		ecStudent.add(new Student(3,"khunal","ECE"));
		
		
		studentData.put("CS",csStudent);
		studentData.put("EC",ecStudent);
		
		System.out.println(studentData);
	}

}
