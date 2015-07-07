package com.admas.ngemp.sms.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.ws.rs.core.Response;

import com.admas.ngemp.sms.jpa.SmsConfig;

public class SMSUtil {

	private String url = "http://smsalertbox.com/api/sms.php?";
	private String urlDelScheduledSms = "http://smsalertbox.com/api/deleteschedule.php?";
	private String urlDlrRpt = "http://smsalertbox.com/api/dlr.php?";
//	private String urlBalance = "http://smsalertbox.com/api/balance.php?";
	private String uid = "616d6f6c73353036";
	private String pin = "4f36aa3903768";
	private String sender = "sender1";
	private String mobile = "9028341164,7588942517,9028108440,9730101211";
	private String message = "hi friend here is my SMS :-)";
	private String route = "4";
	private String time = "27-06-2015-14-32";
	
	/*
	 * private String uid = "616d6f6c73353036";
	private String pin = "4f36aa3903768";
	private String sender = "sender1";
	private String mobile = "7588942517,9028341164";
	private String message = "Skype var online ye or mala call kar : Amol";
	private String route = "4";
	private String time = "18-06-2015-16-40";
	 * 
	 * 
	 * */

	public static String sendSms(SmsConfig smsConfig , String mobileNo , String message , String route) {		
			String result = "";
		try {
			StringBuilder sb = new StringBuilder(smsConfig.getUrl()+"sms.php?");
			sb.append("uid=");
			sb.append(smsConfig.getUid());
			sb.append("&pin=");
			sb.append(smsConfig.getPin());
			sb.append("&sender=");
			sb.append("Admas");
			sb.append("&route=");
			sb.append(route);
			sb.append("&mobile=");
			sb.append(mobileNo);
			sb.append("&message=");
			sb.append(URLEncoder.encode(message, "UTF-8"));

			URL obj = new URL(sb.toString().replace(" ", ""));
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			// add request header
			// con.setRequestProperty("User-Agent", USER_AGENT);

			//int responseCode = con.getResponseCode();
			/*System.out.println("\nSending 'GET' request to URL : " + sb.toString());
			System.out.println("Response Code : " + responseCode);*/
	 
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			result = response.toString();
			//print result
			System.out.println(response.toString());	
		} catch (Exception e) {

		}
		
		return result;
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
	
	public static String deleveryReport(SmsConfig smsConfig, String messageId) {
		
		StringBuffer response = new StringBuffer();
		
		try {
			StringBuilder sb = new StringBuilder(smsConfig.getUrl()+"dlr.php?");
			sb.append("uid=");
			sb.append(smsConfig.getUid());
			sb.append("&pin=");
			sb.append(smsConfig.getPin());
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
			
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
	 
			//print result
			System.out.println(response.toString());	
		} catch (Exception e) {

		}
		
		return response.toString();
	}
	
	public static String getBalance(SmsConfig smsConfig, String route) {
		
		StringBuffer response = new StringBuffer();
		try {
			StringBuilder sb = new StringBuilder(smsConfig.getUrl()+"balance.php?");
			sb.append("uid=");
			sb.append(smsConfig.getUid());
			sb.append("&pin=");
			sb.append(smsConfig.getPin());
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
			
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
	 
			//print result
			System.out.println(response.toString());	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response.toString();
	}
	
	public static void main(String[] args) {
		SMSUtil su = new SMSUtil();
		//su.sendSms();
		//su.scheduleSms();
		su.deleteScheduleSms("350503240");
		//su.deleveryReport("350503078,350503079,350503080,350503081");
		//su.getBalance("4");
	}
}
