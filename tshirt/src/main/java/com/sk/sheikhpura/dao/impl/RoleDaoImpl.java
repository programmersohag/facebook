package com.sk.sheikhpura.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sk.sheikhpura.dao.RoleDao;
import com.sk.sheikhpura.entity.Role;



@Transactional
@Repository("roleDaoImpl")
public class RoleDaoImpl implements RoleDao{

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public Role findRoleByRoleNAme(String role) {
		 return sessionFactory.getCurrentSession().get(Role.class, role);
	}
}
