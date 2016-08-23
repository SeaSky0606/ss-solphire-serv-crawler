package com.yeezhao.dolphin.crawler.dbaction;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HBaseOperationTest {
	public HBaseOperation hbaseDao = new HBaseOperation<Book>();
	
	@Before
	public void before(){
		hbaseDao.conn();
	}
	@Test
	public void testHBaseOperation() {
	}

	@Test
	public void testSave() {
		System.out.println("-- test save --");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testList() {
		fail("Not yet implemented");
	}

	@Test
	public void testCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoQuery() {
		fail("Not yet implemented");
	}

	@Test
	public void testConn() {
	}
	
	@Test
	public void testScan(){
		hbaseDao.scan();
	}

}
