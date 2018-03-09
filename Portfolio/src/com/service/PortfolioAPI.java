package com.service;


import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import com.bean.ReturnPortfolio;
import com.bean.Transactions;
import com.bean.User;
import com.dao.PortfolioDao;
import com.dao.TransactionDao;
import com.dao.UserDao;
import com.google.gson.Gson;

@Path("/portfolio")
public class PortfolioAPI {
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public static String getPortfolio(){
		PortfolioDao portfolioDao = new PortfolioDao();
		List<ReturnPortfolio> returnPortfolios= portfolioDao.getPortfolio();
		Gson gson = new Gson();
		String json = gson.toJson(returnPortfolios);
		return json;
	}
	
	@GET
	@Path("/getUserPortfolio/{emailId}")
	@Produces(MediaType.APPLICATION_JSON)
	public static String getUserPortfolio(@PathParam("emailId") String emailId){
		PortfolioDao portfolioDao = new PortfolioDao();
		ReturnPortfolio returnPortfolio = portfolioDao.getUserPortfolio(emailId);
		Gson gson = new Gson();
		String json = gson.toJson(returnPortfolio);
		return json;
	}
	
	@POST
	@Path("addUser")
	@Consumes(MediaType.APPLICATION_JSON)
	public static void addUser(String jsonParam){
		JSONObject jsonObject = new JSONObject(jsonParam);
		User user = new User(jsonObject.getString("emailId"), 
				jsonObject.getLong("phoneNo"), jsonObject.getString("userName"));
		UserDao userDao = new UserDao();
		userDao.insert(user);
	}
	
	@POST
	@Path("addTrade")
	public static void addTrade(String jsonParam) throws JSONException, IOException{
		JSONObject jsonObject = new JSONObject(jsonParam);
		User user = new User(jsonObject.getString("emailId"), 
				jsonObject.getLong("phoneNo"), jsonObject.getString("userName"));
		StockPrice stockPrice = new StockPrice();
		Double price= stockPrice.getDetails(jsonObject.getString("stock"));
		Transactions transactions = new Transactions(user, jsonObject.getString("type"),
				price, jsonObject.getString("stock"), jsonObject.getLong("quantity"), new Date());
		TransactionDao transactionDao = new TransactionDao();
		transactionDao.insert(transactions,user);
		transactionDao.insertCompute(jsonObject.getString("emailId"),transactions);
	}

}
