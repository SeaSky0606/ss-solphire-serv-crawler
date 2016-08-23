package com.yeezhao.dolphin.crawler.dbaction;

import java.util.List;

/**
 * db基本操作
 * 
 * @author Administrator -> junhong
 * @since 2016年8月23日 下午5:34:14
 * @param <T>
 */
public interface DBBaseOperation<T> {
	
	boolean conn();

	boolean save(T t);

	boolean update(T t);

	T get(Object id);

	T delete(Object id);

	List<T> list();

	long count();

	List<T> doQuery(Object query);
}
