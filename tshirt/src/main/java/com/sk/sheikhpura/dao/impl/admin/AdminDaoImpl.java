package com.sk.sheikhpura.dao.impl.admin;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sk.sheikhpura.dao.admin.AdminDao;
import com.sk.sheikhpura.entity.UserInfo;
@Repository("adminDaoImpl")
public class AdminDaoImpl implements AdminDao{

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> getAllUserInfo() {
		Session session = sessionFactory.getCurrentSession();
		List<UserInfo> producstList = session.createQuery("from USER_INFO").list();
		return producstList;
	}

}
