package com.org;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestComparable {

	public static void main(String[] args) {

		List<Items> items = new ArrayList<Items>();
		
		items.add(new Items(101,"HP",20000.3));
		items.add(new Items(103,"Acer",50000.3));
		items.add(new Items(105,"Dell",22000.3));
		items.add(new Items(102,"Lenova",520000.3));
		items.add(new Items(104,"Vision",27000.3));
		items.add(new Items(106,"HP",20000.0));
		
		System.out.println(items);
		
		Collections.sort(items);
		System.out.println(items);
		
		Comparator<Items> sortByName = new Comparator<Items>() {
			@Override
			public int compare(Items l1, Items l2) {
				
				return l1.getName().compareTo(l2.getName());
			}
		}; 
		Collections.sort(items, sortByName);
		System.out.println(items);

		Collections.sort(items,new Comparator<Items>() {

			@Override
			public int compare(Items l1, Items l2) {
				// TODO Auto-generated method stub
				return l2.getId()-l1.getId();
			}
		});
		
		System.out.println(items);
		
		Collections.sort(items,new Comparator<Items>() {

			@Override
			public int compare(Items l1, Items l2) {
				// TODO Auto-generated method stub
				return l1.getId()-l2.getId();
			}
		});
		
		System.out.println(items);
		
		Collections.sort(items,new Comparator<Items>() {

			@Override
			public int compare(Items l1, Items l2) {
				// TODO Auto-generated method stub
				return (int) (l2.getPrice()-l1.getPrice());
			}
		});
		
		System.out.println(items);
	}

}
