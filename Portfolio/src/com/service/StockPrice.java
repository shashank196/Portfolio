package com.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

public class StockPrice {
	
	public Double getDetails(String stock) throws IOException{
		
		URL url = new URL("https://www.alphavantage.co/query?"
				+ "function=TIME_SERIES_INTRADAY&symbol="+stock+"&interval=1min&apikey=UNFOX03FUXY46OS2");
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		String response = "{";
		while ((inputLine = in.readLine()) != null) {
			if(inputLine.contains("close")){
				response+=inputLine;
				break;
			}
		}
		response+="}";
		in.close();
		JSONObject jsonObject = new JSONObject(response);
		Double price = jsonObject.getDouble("4. close");
		return price;
	}
}
