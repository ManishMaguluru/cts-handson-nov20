package com.org;

import java.util.ArrayList;
import java.util.List;

public class TestEmployee {
	
	public static void main(String[] args) {
		
		List<User> users = new ArrayList<User>();
		
		users.add(new User(1,"Manish","pwd1"));
		users.add(new User(2,"Sai","pwd2"));
		users.add(new User(3,"koushik","pwd3"));
		users.add(new User(4,"venkat","pwd4"));
		users.add(new User(5,"karthik","pwd5"));
	
		for(User user: users) {
			if(user.getName().length() > 5)
			{
				System.out.println(user.getName());
			}
		}
		
	}

}
