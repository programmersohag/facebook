package com.sk.sheikhpura.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.sk.sheikhpura.dao.MemberInfoDao;
import com.sk.sheikhpura.model.MemberInfo;

@Repository
public class MemberInfoDaoImpl extends JdbcDaoSupport implements MemberInfoDao {

	@Autowired
	private DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<MemberInfo> getAllMember() {
		List<MemberInfo> memList = new ArrayList<MemberInfo>();
		String sql="SELECT * FROM SHEIKHPURA";
		memList = getJdbcTemplate().query(sql, 
                new BeanPropertyRowMapper(MemberInfo.class));
		return memList;
	}

}
