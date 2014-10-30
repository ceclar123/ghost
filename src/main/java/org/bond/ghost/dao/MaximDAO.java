package org.bond.ghost.dao;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.bond.ghost.model.MaximModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class MaximDAO implements BaseDAO<MaximModel> {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public MaximModel getRandOne() {
		MaximModel model = null;
		try {
			String sSql = "SELECT id,title,content FROM g_maxim WHERE 1=1 ORDER BY RAND() LIMIT 1";
			SqlRowSet set = jdbcTemplate.queryForRowSet(sSql);
			if (set.next()) {
				model = new MaximModel();
				model.setId(set.getLong(1));
				model.setTitle(set.getString(2));
				model.setContent(set.getString(3));
			}
		} catch (Exception ex) {
			Logger.getLogger(MaximDAO.class).error(ex.getMessage());
			ex.printStackTrace();
		}

		return model;
	}

	public void save(MaximModel entity) {
		// TODO Auto-generated method stub

	}

	public void update(MaximModel entity) {
		// TODO Auto-generated method stub

	}

	public void delete(MaximModel entity) {
		// TODO Auto-generated method stub

	}

	public void delete(Serializable id) {
		// TODO Auto-generated method stub

	}

	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	public void batchSave(List list) {
		// TODO Auto-generated method stub

	}

	public void batchUpdate(List list) {
		// TODO Auto-generated method stub

	}

	public void batchDelete(List list) {
		// TODO Auto-generated method stub

	}

	public MaximModel findById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByPage(int pageNo, int pageSize, Map where) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByPage(int pageNo, int pageSize, LinkedHashMap orderby) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByPage(int pageNo, int pageSize, Map where, LinkedHashMap orderby) {
		// TODO Auto-generated method stub
		return null;
	}
}
