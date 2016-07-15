package org.sun.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
/**
 * Array subList實踐
 * @author Administrator
 * @since  2016年7月15日 上午8:40:19
 */
public class ListOpeTest {

	@Test
	public void testLoopList() {
		String[] fruits = { "peach", "watermelon", "pear", "orange", "banana" };
		List<String> fs = Arrays.asList(fruits);
		for (String s : fs) {
			System.out.println(s);
		}
	}

	@Test
	public void testSubList() {
		String[] fruits = { "peach", "watermelon", "pear", "orange", "banana" };
		List<String> fs = Arrays.asList(fruits);
		List<String> subList = fs.subList(1, 2);
		for (String s : subList) {
			System.out.println(s);
		}
	}

	public List<User> userInit(int size) {
		List<User> users = new ArrayList<>();
		for (int index = 0; index < size; index++) {
			users.add(new User(index + 1, "user" + (index + 1)));
		}
		System.out.println("---- init finish -----");
		return users;
	}

	@Test
	public void testSubListOfObject() {
		int fromIndex = 4;
		int toIndex = 5;
		List<User> users = getSubUsers(fromIndex, toIndex);
		for (User s : users) {
			System.out.println(s.name);
		}
	}

	@Test
	public void testGetUsers() {
		int pageNum = 3;
		int pageSize = 5;
		List<User> users = getUsers(pageNum, pageSize);
		for (User s : users) {
			System.out.println(s.name);
		}
	}

	/**
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return 按照分页从List获取元素
	 */
	public List<User> getUsers(int pageNum, int pageSize) {
		List<User> userInit = userInit(18);
		int fromIndex = (pageNum - 1) * pageSize;
		int toIndex = fromIndex + pageSize;
		return userInit.subList(fromIndex, toIndex);
	}

	public List<User> getSubUsers(int fromIndex, int toIndex) {
		List<User> userInit = userInit(18);
		return userInit.subList(fromIndex, toIndex);
	}

	static class User {
		int id;
		String name;

		public User(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + "]";
		}
		
		
	}
}
