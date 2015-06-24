package com.admas.ngemp.sms.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.admas.ngemp.sms.dto.EmailMessage;

public class EmailUtil {

	public boolean sendEmail(EmailMessage emailMessage, String email, String subject, String contents){
		//LOG.info("EmailUtils: sendEmail method STARTS");
		Integer maxRetryCount = 3;//MessageAttributeConstants.MAX_REDELIVERYCOUNT;

	//	LOG.info("After cachedata");
		final String username = "";//emailConfig.getSmtpUserName();
		final String password = "";//emailConfig.getSmtpUserPassword();

		boolean emailSent = false;
		List<InternetAddress> lstAddresses = null;
		try {
			Properties props = new Properties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "SMTP.bnt-soft.com");
			props.put("mail.smtp.port", "25");
			props.put("mail.smtp.timeout", "60000");
			props.put("mail.smtp.connectiontimeout", "60000");
			props.put("mail.smtp.ssl.trust", "*");

			Session session = null;
			if ("true" == null ||"true".trim().equalsIgnoreCase("false")) {
				session = Session.getInstance(props);
			} else {
				session = Session.getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});
			}

			while (emailSent == false && emailMessage.getRetryCount() < maxRetryCount) {
				//LOG.info("Retry count :" + emailMessage.getRetryCount());
				try {
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("cdtest1@bnt-soft.com"));
					if (email.contains(";")) {
						String[] emailAddresses = email.split(";");
						lstAddresses = new ArrayList<InternetAddress>();
						for (int i = 0; i < emailAddresses.length; i++) {
							if (emailAddresses[i].trim().length() > 0)
								lstAddresses.add(new InternetAddress(emailAddresses[i]));
						}
						message.addRecipients(Message.RecipientType.TO, lstAddresses.toArray(new InternetAddress[] {}));
					} else {
						message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
					}
					message.setSubject(subject);

					message.setContent(contents, "text/html; charset=\"utf-8\"");
					Transport.send(message);
					emailSent = true;
				} catch (Exception e) {
					e.printStackTrace();
					//LOG.info("Exception in sendEmail method after sending email 3 times" + e);
				}
				// Email not Sent
				if (emailSent == false && maxRetryCount != 0 && emailMessage.getRetryCount() <= maxRetryCount) {
					//LOG.info("email sent : " + emailSent);
					emailMessage.setRetryCount(emailMessage.getRetryCount() + 1);
				}
				// Email Sent
				if (emailSent == true) {
					//LOG.info("email sent : " + emailSent);
					emailMessage.setDeliveredOn(new java.sql.Timestamp(new java.util.Date().getTime()));

				}
			}// end of while
		} catch (Exception e) {
			//LOG.error("GOT Exception in class EmailUtil : sendEmail()---", e);
			//throw new EnterpriseBaseException(ErrorName.COULD_NOT_SEND_MAIL);
		} finally {
			lstAddresses = null;
		}
		//LOG.info("EmailUtils: sendEmail method END");
		return emailSent;
	}
	
	public boolean sendEmail(EmailMessage emailMessage, String email, String subject, String contents,String orgCode){
		
		//LOG.info("EmailUtils: sendEmail method STARTS");
		Integer maxRetryCount = 3;//MessageAttributeConstants.MAX_REDELIVERYCOUNT;

	//	LOG.info("After cachedata");
		final String username = "cdtest1@bnt-soft.com";//emailConfig.getSmtpUserName();
		final String password = "bntsoft@12";//emailConfig.getSmtpUserPassword();

		boolean emailSent = false;
		List<InternetAddress> lstAddresses = null;
		try {
			Properties props = new Properties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "SMTP.bnt-soft.com");
			props.put("mail.smtp.port", "25");
			props.put("mail.smtp.timeout", "60000");
			props.put("mail.smtp.connectiontimeout", "60000");
			props.put("mail.smtp.ssl.trust", "*");

			Session session = null;
			if ("true" == null || "true".trim().equalsIgnoreCase("false")) {
				session = Session.getInstance(props);
			} else {
				session = Session.getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});
			}
			while (emailSent == false && emailMessage.getRetryCount() < maxRetryCount) {

				try {
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("cdtest1@bnt-soft.com"));
					if (email.contains(",")) {
						String[] emailAddresses = email.split(",");
						lstAddresses = new ArrayList<InternetAddress>();
						for (int i = 0; i < emailAddresses.length; i++) {
							if (emailAddresses[i].trim().length() > 0)
								lstAddresses.add(new InternetAddress(emailAddresses[i]));
						}
						message.addRecipients(Message.RecipientType.TO, lstAddresses.toArray(new InternetAddress[] {}));
					} else {
						message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
					}
					message.setSubject(subject);
					Multipart multipart = new MimeMultipart();
					BodyPart part1 = new MimeBodyPart();
					part1.setContent(contents, "text/html; charset=\"utf-8\"");
					multipart.addBodyPart(part1);

					/*for (MessageAttachment messageAttachment : listMessageAttachments) {
						BodyPart attachment = null;
						attachment = new MimeBodyPart();

						File file = new File(messageAttachment.getFilePath() + File.separator + messageAttachment.getFileName());
						DataSource source = new FileDataSource(file);
						attachment.setDataHandler(new DataHandler(source));
						attachment.setFileName(messageAttachment.getFileName());
						multipart.addBodyPart(attachment);
						message.setContent(multipart);
					}*/

					Transport.send(message);
					emailSent = true;
				} catch (Exception e) {
					//LOG.info("Exception in sendEmail with attachment method after sending email 3 times" + e);
				}
				// Email not Sent
				if (emailSent == false && maxRetryCount != 0 && emailMessage.getRetryCount() <= maxRetryCount) {
				//	LOG.info("Email Sent  : " + emailSent);
					emailMessage.setRetryCount(emailMessage.getRetryCount() + 1);
				}
				// Email Sent
				if (emailSent == true) {
					//LOG.info("Email Sent : " + emailSent);
					emailMessage.setDeliveredOn(new java.sql.Timestamp(new java.util.Date().getTime()));

				}
			}// end of while
		} catch (Exception e) {
			////LOG.error("Got Exception in class EmailUtil : sendEmail() with attachment---", e);
			//throw new EnterpriseBaseException(ErrorName.COULD_NOT_SEND_MAIL);
		} finally {
			lstAddresses = null;
		}
		//LOG.info("EmailUtils: sendEmail with attachment method END");
		return emailSent;
	}

	public String getEmailHtmlFile(String htmlPath) {
		StringBuilder html = new StringBuilder();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(
					new FileInputStream(htmlPath), "UTF-8"));
			String str;
			while ((str = in.readLine()) != null) {
				html.append(str);
			}
		} catch (IOException e) {
			/*LOG.error(
					"IOException in Class BaseEmailTemplate : getEmailHtmlFile()---",
					e);*/
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return html.toString();
	}
	
	public static void main(String[] args) {
		EmailUtil eu = new EmailUtil();
		EmailMessage em= new EmailMessage();
		em.setRetryCount(2);
		String htmlEmailPath="xyz.htm";
		String content = eu.getEmailHtmlFile(htmlEmailPath);
		eu.sendEmail(em, "xyz.com", "Test mail", content);
		
	}
}
