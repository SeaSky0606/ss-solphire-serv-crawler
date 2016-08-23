package com.yeezhao.dolphin.crawler.dbaction;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;


public class HBaseOperation<T> implements DBBaseOperation<T> {

	private Configuration conf = HBaseConfiguration.create();
	HTable table = null;

	public HBaseOperation() {
		conf.set("hbase.zookeeper.quorum", "centos");// ip of hbase
														// server(remote)
		conf.set("hbase.zookeeper.property.clientPort", "2181");// portno : 2181
																// default
	}

	@Override
	public boolean save(T t) {
		return false;
	}

	@Override
	public boolean update(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T get(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T delete(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<T> doQuery(Object query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean conn() {
		try {
			table = new HTable(conf, "t_book");
			System.out.println("conf=" + table.getConfiguration());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public void scan() {
		Scan scan = new Scan();
		String family = "base_info";
		scan.addFamily(family.getBytes());
		try {
			ResultScanner scanner = table.getScanner(scan);
			Iterator<Result> results = scanner.iterator();
			while (results.hasNext()) {
				HashMap<String, String> map = new HashMap<>();
				Result result = results.next();
				for (KeyValue kv : result.raw()) {
					map.put(new String(kv.getQualifier()), new String(kv.getValue()));
				}
				System.out.println("map=" + map);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
