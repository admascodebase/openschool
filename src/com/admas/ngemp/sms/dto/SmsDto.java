package com.admas.ngemp.sms.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jettison.json.JSONObject;



@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="smsDto")
public class SmsDto implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3896441132582237804L;

	@XmlElement(name="message")
	private String message;
	@XmlElement(name="route")
	private Integer route;
	@XmlElement
	private List<String> contactNos;

	
	public JSONObject getsmsdtojson(){
		
		JSONObject smsjsondto = new JSONObject();
		try {
			

			smsjsondto.put("message", message);
			smsjsondto.put("route", route);
			smsjsondto.put("contactNos", contactNos);

			return smsjsondto;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return smsjsondto;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the route
	 */
	public Integer getRoute() {
		return route;
	}

	/**
	 * @param route the route to set
	 */
	public void setRoute(Integer route) {
		this.route = route;
	}

	/**
	 * @return the contactNos
	 */
	public List<String> getContactNos() {
		return contactNos;
	}

	/**
	 * @param contactNos the contactNos to set
	 */
	public void setContactNos(List<String> contactNos) {
		this.contactNos = contactNos;
	}


	
	
	
	
	
	
	
}

	
	
