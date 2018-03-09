package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bean.Compute;
import com.bean.ReturnPortfolio;
import com.entity.ComputeEntity;
import com.util.HibernateUtility;

public class PortfolioDao {

	SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
	
	public List<ReturnPortfolio> getPortfolio(){
		UserDao userDao = new UserDao();
		List<ReturnPortfolio> returnPortfolios = new ArrayList<ReturnPortfolio>();
		List<String> emailIds = userDao.getAllUsers();
		for (String emailId : emailIds) {
			returnPortfolios.add(getUserPortfolio(emailId));
		}
		return returnPortfolios;
	}
	
	
	@SuppressWarnings("unchecked")
	public ReturnPortfolio getUserPortfolio(String emailId){
		Session session = sessionFactory.openSession();
		Query query = (Query)session.createQuery("from ComputeEntity c where c.emailId=:email");
		query.setParameter("email",emailId);
		List<ComputeEntity> list = query.list();
		ReturnPortfolio returnPortfolio = new ReturnPortfolio();
		List<Compute> computes = new ArrayList<Compute>();
		for (ComputeEntity computeEntity : list) {
			computes.add(compute(computeEntity));
		}
		UserDao userDao = new UserDao();
		returnPortfolio.setDetails(computes);
		returnPortfolio.setUser(userDao.getUser(emailId));
		return returnPortfolio;
	}
	
	public Compute compute(ComputeEntity computeEntity){
		Compute com = new Compute();
		com.setAvgBuyPrice(computeEntity.getTotal_buy()/computeEntity.getBuy_amount());
		com.setHoldings(computeEntity.getBuy_quantity()-computeEntity.getSell_quantity());
		com.setStock(computeEntity.getStock());
		com.setReturns((computeEntity.getBuy_amount()-computeEntity.getSell_amount())/computeEntity.getBuy_amount());
		return com;
	}
}
