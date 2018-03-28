package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.StockEntity;
import com.util.HibernateUtility;

public class StockDao{

	SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
	
	public void updateStocks(String name, Double price){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		StockEntity stockEntity = (StockEntity) session.get(StockEntity.class, name);
		if(stockEntity==null)
			stockEntity = new StockEntity();
		stockEntity.setStock_name(name);
		stockEntity.setPrice(price);
		session.persist(stockEntity);
		session.getTransaction().commit();
		session.clear();
		session.close();
	}
	
}
