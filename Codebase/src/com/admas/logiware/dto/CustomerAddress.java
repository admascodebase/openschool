package com.admas.logiware.dto;

import java.io.Serializable;

import javax.ws.rs.FormParam;

public class CustomerAddress implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@FormParam("currentAddress")
	private String currentAddress;
	@FormParam("currentPin")
	private String currentPin;
	@FormParam("currentState")
	private State currentState;
	@FormParam("perAddress")
	private String perAddress;
	@FormParam("perPin")
	private String perPin;
	@FormParam("perState")
	private State perState;

	/**
	 * @return the currentAddress
	 */
	public String getCurrentAddress() {
		return currentAddress;
	}
	/**
	 * @param currentAddress the currentAddress to set
	 */
	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}
	/**
	 * @return the currentPin
	 */
	public String getCurrentPin() {
		return currentPin;
	}
	/**
	 * @param currentPin the currentPin to set
	 */
	public void setCurrentPin(String currentPin) {
		this.currentPin = currentPin;
	}
	/**
	 * @return the currentState
	 */
	public State getCurrentState() {
		return currentState;
	}
	/**
	 * @param currentState the currentState to set
	 */
	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}
	/**
	 * @return the perAddress
	 */
	public String getPerAddress() {
		return perAddress;
	}
	/**
	 * @param perAddress the perAddress to set
	 */
	public void setPerAddress(String perAddress) {
		this.perAddress = perAddress;
	}
	/**
	 * @return the perPin
	 */
	public String getPerPin() {
		return perPin;
	}
	/**
	 * @param perPin the perPin to set
	 */
	public void setPerPin(String perPin) {
		this.perPin = perPin;
	}
	/**
	 * @return the perState
	 */
	public State getPerState() {
		return perState;
	}
	/**
	 * @param perState the perState to set
	 */
	public void setPerState(State perState) {
		this.perState = perState;
	}	
	
	
}
