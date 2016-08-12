package org.sun.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListMapSort {
	
	public static List<Map<String,Object>> init(){ 
		List<Map<String,Object>> mapList = new ArrayList<>();
		Map<String,Object> jack = new HashMap<>();
		jack.put("name","Jack");
		jack.put("sex","female");
		jack.put("birth","2014-01-12");
		
		mapList.add(jack);
		
		Map<String,Object> peter = new HashMap<>();
		peter.put("name","peter");
		peter.put("sex","male");
		peter.put("birth","2015-11-12");
		
		mapList.add(peter);
		
		Map<String,Object> jane = new HashMap<>();
		jane.put("name","jane");
		jane.put("sex","male");
		jane.put("birth","2015-10-12");
		
		mapList.add(jane);
		return mapList;
	}
	public static void outputListMap(List<Map<String, Object>> peoples){
		for(Map<String,Object> p:peoples){
			System.out.println(p);
		}
	}
	
	/*
	=> output:
		{birth=2014-01-12, sex=female, name=Jack}
		{birth=2015-11-12, sex=male, name=peter}
		{birth=2015-10-12, sex=male, name=jane}
		********
		{birth=2014-01-12, sex=female, name=Jack}
		{birth=2015-10-12, sex=male, name=jane}
		{birth=2015-11-12, sex=male, name=peter}
	 */
	
	public static void main(String[] args) {
		
		List<Map<String, Object>> peoples = init();
		outputListMap(peoples);
		System.out.println("********");
		Collections.sort(peoples, new Comparator<Map<String, Object>>() {

			@Override
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
				String s1=  (String) o1.get("birth");
				String s2=  (String) o2.get("birth");
				if(parseDate(s1).after(parseDate(s2))){
					return 1;
				}
				else{
					return -1;
				}
			}
		});
		outputListMap(peoples);
//		System.out.println(parseDate("2016-03-02 22:00:00"));
	}
	
	/**
	 * 
	 * @param source
	 * @return 日期解析
	 */
	public static Date parseDate(String source){
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
