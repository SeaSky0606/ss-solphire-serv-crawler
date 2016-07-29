package org.sun.java;

import spring.data.mongodb.pojo.People;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 按照年龄从小到大进行排序
 * Created by junhong on 2016/7/29.
 */
public class ObjectListSort {

    public static void main(String[] args) {
        System.out.println("-----****------");
        List<People> peoples = new ArrayList<>();
        peoples.add(new People(1, "Jack", "female", "2016-01-12"));
        peoples.add(new People(3, "John", "male", "1993-02-12"));
        peoples.add(new People(2, "Michael", "male", "1994-01-11"));
        peoples.add(new People(4, "Robots", "female", "1994-01-10"));
        Collections.sort(peoples, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o2.getBirthDate().compareTo(o1.getBirthDate());
            }
        });
        for (People p : peoples) {
            System.out.println(p.getName());
        }
    }
}
