package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.bean.User;
import com.entity.UserEntity;
import com.util.HibernateUtility;

public class UserDao {

	SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
	
	public void insert(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		UserEntity userEntity = (UserEntity) session.get(UserEntity.class, user.getEmailId());
		if(userEntity==null){
			userEntity = new UserEntity(user.getEmailId(),user.getPhoneNo(),user.getUserName());
			session.persist(userEntity);
			session.getTransaction().commit();
		}
		session.clear();
		session.close();
	}
	
	public User getUser(String emailId){
		Session session = sessionFactory.openSession();
		Query query = (Query)session.createQuery("from UserEntity where emailId=:email");
		query.setParameter("email", emailId);
		UserEntity userEntity = (UserEntity) query.uniqueResult();
		User user = null;
		if(userEntity!=null)
			user = new User(userEntity.getEmailId(),userEntity.getPhoneNo(),userEntity.getUserName());
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getAllUsers(){
		Session session = sessionFactory.openSession();
		Query query = (Query)session.createQuery("select u.emailId from UserEntity u");
		List<String> user = query.list();
		return user;
	}
}
