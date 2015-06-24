package com.admas.ngemp.sms.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SMSUtil {

	private String url = "http://smsalertbox.com/api/sms.php?";
	private String urlDelScheduledSms = "http://smsalertbox.com/api/deleteschedule.php?";
	private String urlDlrRpt = "http://smsalertbox.com/api/dlr.php?";
	private String urlBalance = "http://smsalertbox.com/api/balance.php?";
	private String uid = "";
	private String pin = "";
	private String sender = "sender1";
	private String mobile = "";
	private String message = "Test sms";
	private String route = "4";
	private String time = "18-06-2015-16-40";

	public boolean sendSms() {		
		try {
			StringBuilder sb = new StringBuilder(url);
			sb.append("uid=");
			sb.append(uid);
			sb.append("&pin=");
			sb.append(pin);
			sb.append("&sender=");
			sb.append(sender);
			sb.append("&route=");
			sb.append(route);
			sb.append("&mobile=");
			sb.append(mobile);
			sb.append("&message=");
			sb.append(URLEncoder.encode(message, "UTF-8"));

			URL obj = new URL(sb.toString().replace(" ", ""));
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			// add request header
			// con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + sb.toString());
			System.out.println("Response Code : " + responseCode);
	 
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
	 
			//print result
			System.out.println(response.toString());	
		} catch (Exception e) {

		}
		
		return true;
	}
	
	public boolean scheduleSms() {
		try {
			StringBuilder sb = new StringBuilder(url);
			sb.append("uid=");
			sb.append(uid);
			sb.append("&pin=");
			sb.append(pin);
			sb.append("&sender=");
			sb.append(sender);
			sb.append("&route=");
			sb.append(route);
			sb.append("&mobile=");
			sb.append(mobile);
			sb.append("&message=");
			sb.append(URLEncoder.encode(message, "UTF-8"));
			sb.append("&time="+time);
			
			URL obj = new URL(sb.toString().replace(" ", ""));
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			// add request header
			// con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + sb.toString());
			System.out.println("Response Code : " + responseCode);
	 
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
	 
			//print result
			System.out.println(response.toString());	
		} catch (Exception e) {

		}
		
		return true;
	}
	
	public boolean deleteScheduleSms(String messageId) {
		try {
			StringBuilder sb = new StringBuilder(urlDelScheduledSms);
			sb.append("uid=");
			sb.append(uid);
			sb.append("&pin=");
			sb.append(pin);
			sb.append("&msgid="+messageId);

			URL obj = new URL(sb.toString().replace(" ", ""));
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			// add request header
			// con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + sb.toString());
			System.out.println("Response Code : " + responseCode);
	 
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
	 
			//print result
			System.out.println(response.toString());	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean deleveryReport(String messageId) {
		try {
			StringBuilder sb = new StringBuilder(urlDlrRpt);
			sb.append("uid=");
			sb.append(uid);
			sb.append("&pin=");
			sb.append(pin);
			sb.append("&msgid="+messageId);

			URL obj = new URL(sb.toString().replace(" ", ""));
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			// add request header
			// con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + sb.toString());
			System.out.println("Response Code : " + responseCode);
	 
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
	 
			//print result
			System.out.println(response.toString());	
		} catch (Exception e) {

		}
		
		return true;
	}
	
	public boolean getBalance(String route) {
		try {
			StringBuilder sb = new StringBuilder(urlBalance);
			sb.append("uid=");
			sb.append(uid);
			sb.append("&pin=");
			sb.append(pin);
			sb.append("&route="+route);

			URL obj = new URL(sb.toString().replace(" ", ""));
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			// add request header
			// con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + sb.toString());
			System.out.println("Response Code : " + responseCode);
	 
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
	 
			//print result
			System.out.println(response.toString());	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		SMSUtil su = new SMSUtil();
		su.sendSms();
		//su.scheduleSms();
		//su.deleteScheduleSms("348427607");
		//su.deleveryReport("348429858");
		su.getBalance("4");
	}
}
