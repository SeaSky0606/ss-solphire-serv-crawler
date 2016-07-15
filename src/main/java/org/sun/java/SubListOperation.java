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
	 * @param pageNum
	 * @param pageSize
	 * @return  简单分页功能
	 */
	public List<String> subList(int pageNum, int pageSize) {
		List<String> lists = init(COUNT);
		int fromIndex = (pageNum - 1) * pageSize;
		int toIndex = fromIndex + pageSize;
		return lists.subList(fromIndex, toIndex);
	}

	public static void main(String[] args) {
		System.out.println("-------- start --------");
		new SubListOperation().output();
		System.out.println("-------- finish --------");
	}
	
	public void output(){
		int pageNum=2;
		int pageSize=5;
		for(String s:subList(pageNum,pageSize)){
			System.out.println(s);
		}
	}

}
