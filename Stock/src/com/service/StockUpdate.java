package com.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.dao.StockDao;

public class StockUpdate implements Runnable{

	private String stock;

	public StockUpdate(String stock) {
		super();
		this.stock = stock;
	}
	
	public StockUpdate() {
		super();
	}

	public void run(){
		StockPrice stockPrice = new StockPrice();
		Double price;
		try {
			price = stockPrice.getDetails(stock);
			StockDao stockDao = new StockDao();
			stockDao.updateStocks(stock, price);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void updateDB(String path) throws IOException{
		List<String> stocks = new ArrayList<String>();
		File file = new File(path);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while ((line = br.readLine()) != null)
		{
			stocks.add(line);
		}
		br.close();
		for (String stock : stocks) {
			Thread t = new Thread(new StockUpdate(stock));
			t.start();
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		while(true){
			StockUpdate stockUpdate = new StockUpdate();
			stockUpdate.updateDB(args[0]);
			Thread.sleep(4000);
		}
	}
}
