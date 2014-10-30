package org.bond.ghost.dao;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface BaseDAO<T> {
	public void save(T entity);

	public void update(T entity);

	public void delete(T entity);

	public void delete(Serializable id);

	public void deleteAll();

	public void batchSave(List<T> list);

	public void batchUpdate(List<T> list);

	public void batchDelete(List<T> list);

	public T findById(Serializable id);

	public List<T> findAll();

	public List<T> findByPage(int pageNo, int pageSize);

	public List<T> findByPage(int pageNo, int pageSize, Map<String, String> where);

	public List<T> findByPage(int pageNo, int pageSize, LinkedHashMap<String, String> orderby);

	public List<T> findByPage(int pageNo, int pageSize, Map<String, String> where, LinkedHashMap<String, String> orderby);
}
