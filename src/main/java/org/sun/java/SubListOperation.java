package org.sun.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Administrator
 * @date 2016年7月16日
 */
public class SubListOperation {
	final static int COUNT = 18;

	public List<String> init(int size) {
		List<String> lists = new ArrayList<String>();
		for (int i = 0; i < size; i++) {
			lists.add("t" + (i + 1));
		}
		return lists;
	}

	/**
	 * 
	 * @param size
	 * @return 初始化用户列表
	 */
	public List<User> initUser(int size) {
		List<User> lists = new ArrayList<User>();
		for (int i = 0; i < size; i++) {
			lists.add(new User((i + 1), "user" + (i + 1)));
		}
		return lists;
	}

	

	/**
	 * 
	 * @param lists 将被分页展示的列表
	 * @param pageNum 页码数
	 * @param pageSize 每页条数大小
	 * @return
	 */
	public <T> List<T> generalPagenation(List<T> lists,int pageNum, int pageSize) {
		int fromIndex = (pageNum - 1) * pageSize;
		int toIndex = fromIndex + pageSize;
		int size = lists.size();
		if (fromIndex >= size) {
			return new ArrayList<T>();
		}
		return lists.subList(fromIndex, Math.min(size, toIndex));
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

	public static void main(String[] args) {
		System.out.println("-------- start --------");
		new SubListOperation().outputT();
		System.out.println("-------- finish --------");
	}

	public void outputT() {
		int pageNum = 3;
		int pageSize = 5;
		for (Object s : generalPagenation(init(18),pageNum, pageSize)) {
			System.out.println(s);
		}
		System.out.println("---------***---------");
		for (Object s : generalPagenation(initUser(12),pageNum, pageSize)) {
			System.out.println(s);
		}
	}


}
