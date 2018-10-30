/*
 * TestMain.java
 *
 * Copyright (c) 2018 Southwest Airlines, Co.
 * 2702 Love Field Drive, Dallas, TX 75235, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Southwest Airlines, Co.
 *
 */
package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMain {

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {

		ExecutorService executor = Executors.newFixedThreadPool(30);
		Runnable worker = new MyRunnable();
		for (int i = 0; i < 100; i++) {
			executor.execute(worker);
		}
		executor.shutdown();
	}

	public static class MyRunnable implements Runnable {
		int i = 0;

		@Override
		public void run() {
			String result = "";
			try {

				String query = "{\r\n" + "	\"variables\":{\r\n"
						+ "		\"customerId\":\"3MKCVKHUKPG4TDB6BFZIERESE\"\r\n" + "	}\r\n" + "}";

				HttpURLConnection urlConn;
				URL mUrl = new URL("http://localhost:8080/rtds-customer-service/persistedquery/customer");
				urlConn = (HttpURLConnection) mUrl.openConnection();
				urlConn.setDoOutput(true);
				// query is your body
				urlConn.addRequestProperty("Content-Type", "application/" + "POST");
				urlConn.setRequestProperty("Content-Length", Integer.toString(query.length()));
				urlConn.getOutputStream().write(query.getBytes("UTF8"));
				BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					content.append(inputLine);
				}
				in.close();
				int responseCode = urlConn.getResponseCode();
				System.out.println("Counter = " + i++ + " Thread ID = " + Thread.currentThread().getId()
						+ " responseCode = " + responseCode + "  content = " + content);
			} catch (Exception e) {
				result = "-> Red <-\t" + "Wrong domain - Exception: " + e.getMessage();

			}
		}

	}

}
