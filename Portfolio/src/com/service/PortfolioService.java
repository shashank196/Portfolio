package com.service;

import java.io.IOException;

import com.bean.User;
import com.dao.PortfolioDao;
import com.dao.UserDao;

public class PortfolioService {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDao();
		User user = userDao.getUser("sdafeyfshdkf");
		if(user==null)
			System.out.println("sd");
		System.out.println("sdf");
	}
}
