package com.sk.sheikhpura.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sk.sheikhpura.dao.UserDao;
import com.sk.sheikhpura.entity.UserInfo;

@Transactional
@Repository("accountDaoImpl")
public class UserDaoImpl implements UserDao{

	@Autowired
    private SessionFactory sessionFactory;
	/*@Autowired
	private RoleDao roleDao;
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
 
    @Override
    public Account findAccount(String userName ) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Account> criteria = builder.createQuery(Account.class);
        ((Criteria) criteria).add(Restrictions.eq("userName", userName));
        return (Account) ((Criteria) criteria).uniqueResult();
    }

	@Override
	public void saveAccount(Account account) {
		 Set<Role> roles = new HashSet<>();
		 roles.add(roleDao.findRoleByRoleNAme("USER"));
		 System.out.println("ROLES --------------"+roles);
		// account.setRoles(roles);
		 Session session = sessionFactory.getCurrentSession();
		 account.setActive(true);
		 account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
		 session.save(account);
	}*/
	
	@Override
    public UserInfo findUserById(int id) {
        return sessionFactory.getCurrentSession().get(UserInfo.class, id);
    }

	@Override
	public List<UserInfo> getUsers() {
		@SuppressWarnings("unchecked")
		List<UserInfo> usersList = sessionFactory.getCurrentSession().createQuery("from UserInfo").list();
		return usersList;
		/*Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<UserInfo> cq = cb.createQuery(UserInfo.class);
	      Root<UserInfo> root = cq.from(UserInfo.class);
	      cq.select(root);
	      Query<UserInfo> query = session.createQuery(cq);
	      return query.getResultList();*/
	}

	@Override
	public UserInfo saveOrUpdateUser(UserInfo user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return user;
	}

	@Override
	public void deleteeUser(String username) {
		UserInfo userInfo = (UserInfo) sessionFactory.getCurrentSession().load(UserInfo.class, username);
        if (null != userInfo) {
            this.sessionFactory.getCurrentSession().delete(userInfo);
        }
	}

	@Override
	public UserInfo findUserByUserName(String username) {
		return null;
		// TODO Auto-generated method stub
		
	}
	 
}
