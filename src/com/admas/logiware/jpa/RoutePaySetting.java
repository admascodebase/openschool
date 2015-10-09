package com.admas.logiware.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.admas.logiware.dto.RoutePaySettingDto;

@Entity
@Table(name="route_pay_setting")
public class RoutePaySetting implements Serializable{
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@Column(name="TRANSPORT_TYPE_ID" ,nullable = false )
		private Integer transportTypeId;
		
		@Column(name="ROUTE_ID" ,nullable = false )
		private Integer routeId;
		
		@Column(name="AMOUNT" ,nullable = false )
		private Double amount;
		
		@Column(name="ADVANCE" ,nullable = false )
		private Double advance;
		
		@Column(name="BALANCE" ,nullable = false )
		private Double balance;
		
		@Column(name="CREATED_BY" ,nullable = false)
		private Integer createdBy;
		
		@Column(name="UPDATED_BY")
		private Integer updatedBy;
		
		@Column(name="CREATED_ON",nullable = false)
		@Temporal(TemporalType.TIMESTAMP)
		private Date createdOn;
		
		@Column(name="UPDATED_ON")
		@Temporal(TemporalType.TIMESTAMP)
		private Date updatedOn;
		
		@Column(name="DEL_FLG" ,nullable = false) 
		private Character delFlag;

		/**
		 * @return the id
		 */
		public Integer getId() {
			return id;
		}

		/**
		 * @return the transportTypeId
		 */
		public Integer getTransportTypeId() {
			return transportTypeId;
		}

		/**
		 * @return the routeId
		 */
		public Integer getRouteId() {
			return routeId;
		}

		/**
		 * @return the amount
		 */
		public Double getAmount() {
			return amount;
		}

		/**
		 * @return the advance
		 */
		public Double getAdvance() {
			return advance;
		}

		/**
		 * @return the balance
		 */
		public Double getBalance() {
			return balance;
		}

		/**
		 * @return the createdBy
		 */
		public Integer getCreatedBy() {
			return createdBy;
		}

		/**
		 * @return the updatedBy
		 */
		public Integer getUpdatedBy() {
			return updatedBy;
		}

		/**
		 * @return the createdOn
		 */
		public Date getCreatedOn() {
			return createdOn;
		}

		/**
		 * @return the updatedOn
		 */
		public Date getUpdatedOn() {
			return updatedOn;
		}

		/**
		 * @return the delFlag
		 */
		public Character getDelFlag() {
			return delFlag;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(Integer id) {
			this.id = id;
		}

		/**
		 * @param transportTypeId the transportTypeId to set
		 */
		public void setTransportTypeId(Integer transportTypeId) {
			this.transportTypeId = transportTypeId;
		}

		/**
		 * @param routeId the routeId to set
		 */
		public void setRouteId(Integer routeId) {
			this.routeId = routeId;
		}

		/**
		 * @param amount the amount to set
		 */
		public void setAmount(Double amount) {
			this.amount = amount;
		}

		/**
		 * @param advance the advance to set
		 */
		public void setAdvance(Double advance) {
			this.advance = advance;
		}

		/**
		 * @param balance the balance to set
		 */
		public void setBalance(Double balance) {
			this.balance = balance;
		}

		/**
		 * @param createdBy the createdBy to set
		 */
		public void setCreatedBy(Integer createdBy) {
			this.createdBy = createdBy;
		}

		/**
		 * @param updatedBy the updatedBy to set
		 */
		public void setUpdatedBy(Integer updatedBy) {
			this.updatedBy = updatedBy;
		}

		/**
		 * @param createdOn the createdOn to set
		 */
		public void setCreatedOn(Date createdOn) {
			this.createdOn = createdOn;
		}

		/**
		 * @param updatedOn the updatedOn to set
		 */
		public void setUpdatedOn(Date updatedOn) {
			this.updatedOn = updatedOn;
		}

		/**
		 * @param delFlag the delFlag to set
		 */
		public void setDelFlag(Character delFlag) {
			this.delFlag = delFlag;
		}
		
		public RoutePaySettingDto _toDto() {
			RoutePaySettingDto routePaySettingDto = new RoutePaySettingDto();
			routePaySettingDto.setAdvance(this.advance);
			routePaySettingDto.setAmount(this.amount);
			routePaySettingDto.setBalance(this.balance);
			routePaySettingDto.setCreatedBy(this.createdBy);
			routePaySettingDto.setCreatedOn(this.createdOn);
			routePaySettingDto.setDelFlag(this.delFlag);
			routePaySettingDto.setId(this.id);
			routePaySettingDto.setRouteId(this.routeId);
			routePaySettingDto.setTransportTypeId(this.transportTypeId);
			routePaySettingDto.setUpdatedBy(this.updatedBy);
			routePaySettingDto.setUpdatedOn(this.updatedOn);
			return routePaySettingDto;
		}
		
}
