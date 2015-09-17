package com.admas.ngemp.sms.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.admas.logiware.jpa.sms.SmsConfig;

public class SMSUtil {

	
	public static String sendSms(SmsConfig smsConfig, String mobileNo,
			String message, String route) {
		String result = "";
		try {
			StringBuilder sb = new StringBuilder(smsConfig.getUrl()
					+ "sms.php?");
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

			con.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			result = response.toString();
			System.out.println(response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	/*public boolean scheduleSms() {
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
			sb.append("&time=" + time);

			URL obj = new URL(sb.toString().replace(" ", ""));
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : "
					+ sb.toString());
			System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			System.out.println(response.toString());
		} catch (Exception e) {

		}

		return true;
	}*/
	
	/*public boolean deleteScheduleSms(String messageId) {
		try {
			StringBuilder sb = new StringBuilder(urlDelScheduledSms);
			sb.append("uid=");
			sb.append(uid);
			sb.append("&pin=");
			sb.append(pin);
			sb.append("&msgid=" + messageId);

			URL obj = new URL(sb.toString().replace(" ", ""));
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : "
					+ sb.toString());
			System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}
*/
	public static String deleveryReport(SmsConfig smsConfig, String messageId) {

		StringBuffer response = new StringBuffer();

		try {
			StringBuilder sb = new StringBuilder(smsConfig.getUrl()
					+ "dlr.php?");
			sb.append("uid=");
			sb.append(smsConfig.getUid());
			sb.append("&pin=");
			sb.append(smsConfig.getPin());
			sb.append("&msgid=" + messageId);

			URL obj = new URL(sb.toString().replace(" ", ""));
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : "
					+ sb.toString());
			System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response.toString());
		} catch (Exception e) {

		}

		return response.toString();
	}

	public static String getBalance(SmsConfig smsConfig, String route) {

		StringBuffer response = new StringBuffer();
		try {
			StringBuilder sb = new StringBuilder(smsConfig.getUrl()
					+ "balance.php?");
			sb.append("uid=");
			sb.append(smsConfig.getUid());
			sb.append("&pin=");
			sb.append(smsConfig.getPin());
			sb.append("&route=" + route);

			URL obj = new URL(sb.toString().replace(" ", ""));
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : "
					+ sb.toString());
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response.toString();
	}
	

}
