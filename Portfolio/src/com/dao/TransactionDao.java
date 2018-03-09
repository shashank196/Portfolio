package com.dao;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bean.Transactions;
import com.bean.User;
import com.entity.ComputeEntity;
import com.entity.ComputePKEntity;
import com.entity.TransactionsEntity;
import com.entity.UserEntity;
import com.util.HibernateUtility;

public class TransactionDao {
	SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
	
	public void insert(Transactions transactions , User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		UserEntity userEntity = (UserEntity) session.get(UserEntity.class,user.getEmailId());
		if(userEntity==null)
			userEntity = new UserEntity(user.getEmailId(),user.getPhoneNo(),user.getUserName());
		TransactionsEntity transactionsEntity = new TransactionsEntity(userEntity,transactions.getType()
				,transactions.getPrice(),transactions.getStock(),transactions.getQuantity(),new Date());
		session.persist(transactionsEntity);
		session.getTransaction().commit();
		session.clear();
		session.close();
	}
	
	
	public void insertCompute(String emailId, Transactions transactions){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		ComputePKEntity computePKEntity = new ComputePKEntity(emailId,transactions.getStock());
		ComputeEntity computeEntity = new ComputeEntity();
		computeEntity = (ComputeEntity) session.get(ComputeEntity.class, computePKEntity);
		if(computeEntity==null){
			computeEntity = new ComputeEntity();
			computeEntity.setEmailId(computePKEntity.getEmailId());
			computeEntity.setStock(computePKEntity.getStock());
		}
		String type = transactions.getType().toLowerCase();
		if(type.equals("buy")){
			computeEntity.setBuy_amount(computeEntity.getBuy_amount()+transactions.getPrice()*
					transactions.getQuantity());
			computeEntity.setBuy_count(computeEntity.getBuy_count()+1);
			computeEntity.setTotal_buy(computeEntity.getTotal_buy()+transactions.getPrice());
			computeEntity.setBuy_quantity(computeEntity.getBuy_quantity()+transactions.getQuantity());
		}
		else{
			computeEntity.setSell_amount(computeEntity.getSell_amount()+transactions.getPrice()*
					transactions.getQuantity());
			computeEntity.setSell_quantity(computeEntity.getSell_quantity()+transactions.getQuantity());
		}
		session.persist(computeEntity);
		session.getTransaction().commit();
		session.clear();
		session.close();
	}
}
