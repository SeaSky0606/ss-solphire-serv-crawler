package com.google.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator -> junhong
 * on 2016/8/11.
 */
public class MapOperation {

    public List<President> init() {
        List<President> pre = new ArrayList<>();
        pre.add(new President("Obama", "Jack"));
        pre.add(new President("Nacsh", "Steve"));
        return pre;
    }

    public List<President> init2() {
        List<President> pre = new ArrayList<>();
        pre.add(new President("Obama", "Jack2"));
        pre.add(new President("Nacsh", "Steve2"));
        return pre;
    }

//    public static void main(String... args) {
//
//    }
}
