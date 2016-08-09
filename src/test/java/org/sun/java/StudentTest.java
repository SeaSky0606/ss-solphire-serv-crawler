package org.sun.java;

import org.junit.Test;

public class StudentTest {

	@Test
	public void test() {
	}
	
	@Test
	public void testCompare(){
		Student st1 = new Student();
		st1.setName("Jack");
		st1.setScore(79.1);
		
		Student st2 = new Student();
		st2.setName("Mick");
		st2.setScore(87.1);
		
		System.out.println(st1.compareTo(st2));
	}

}
