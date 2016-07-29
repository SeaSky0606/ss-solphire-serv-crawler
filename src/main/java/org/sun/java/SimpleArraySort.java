package org.sun.java;

import java.util.Arrays;

/**
 * 测试Arrays，简单数组排序
 * Created by junhong on 2016/7/29.
 */
public class SimpleArraySort {

    public static void main(String[] args) {
        String[] fruits = "apple,pear,watermelon,banana".split(",");
        for (String s : fruits) {
            System.out.println(s);
        }
        System.out.println("--------***");
        Arrays.sort(fruits);
        for (String s : fruits) {
            System.out.println(s);
        }


    }
}

/*
    output:
        apple
        pear
        watermelon
        banana
        --------***
        apple
        banana
        pear
        watermelon
* */
