package com.yeezhao.dolphin.crawler.dbaction;

import java.util.List;

public class MysqlOperation<T> implements DBBaseOperation<T> {

	@Override
	public boolean save(T t) {
		return false;
	}

	@Override
	public boolean update(T t) {
		return false;
	}

	@Override
	public T get(Object id) {
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
		// TODO Auto-generated method stub
		return false;
	}

}
