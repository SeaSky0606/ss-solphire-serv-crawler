package com.google.common;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import org.junit.After;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator -> junhong
 * on 2016/8/11.
 */
public class MapOperationTest {
    private MapOperation oper = new MapOperation();

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testInit() throws Exception {
        ListMultimap<String, String> multimap = ArrayListMultimap.create();
        for (President pres : oper.init()) {
            multimap.put(pres.getFirstName(), pres.getLastName());
        }
        ListMultimap<String, String> multimap2 = ArrayListMultimap.create();
        for (President pres : oper.init2()) {
            multimap2.put(pres.getFirstName(), pres.getLastName());
        }
        // init the multimap with a map
        ListMultimap<String, String> bigMapList = ArrayListMultimap.create(multimap);
        bigMapList.putAll(multimap2);
        System.out.println("******* output as map:");
        System.out.println(bigMapList.asMap());
        bigMapList.put("Obama", "John");
        System.out.println("-------- output keySet=");
        System.out.println(bigMapList.keySet());
        System.out.println("******* output as map:");
        System.out.println(bigMapList.asMap());
        List<String> obama = bigMapList.replaceValues("Obama", Arrays.asList(new String[]{"value1", "value2"}));
        System.out.println("======== replaceValues return=" + obama);
        System.out.println("******* output as map:");
        System.out.println(bigMapList.asMap());
    }


}