package com.legalnod.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * AllStateFormsCheckoutPaymentAndUserContactSaving entity. @author MyEclipse
 * Persistence Tools
 */
@Entity
@Table(name = "user_payment_transaction_info_saving", schema = "bs")
public class UserPaymentTransactionInfoSaving implements java.io.Serializable {
	
	// Fields

		private Integer userPaymentTransactionInfoSavingId;
		private String userName;
		private String cardNumber;
		private long transactionNumber;
		private String cardExpiryDate;
		private String amount;
		private String orderStatus;
		private String billingFirstName;
		private String billingLastName;
		private String billingAddress;
		private String billingCity;
		private String billingStateName;
		private String billingZip;
		private String shipingFirstName;
		private String shipingLastName;
		private String shipingAddress;
		private String shipingCity;
		private String shipingStateName;
		private String shipingZip;
		private String authorizationCode;
		private Timestamp createdDate;
		private Timestamp modifiedDate;
		
		// Constructors

		/** default constructor */
		public UserPaymentTransactionInfoSaving() {
		}

		// Property accessors
		@Id
		@SequenceGenerator(name = "user_payment_transaction_info_saving_id", sequenceName = "bs.user_payment_transaction_info_saving_id_seq", allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_payment_transaction_info_saving_id")
		@Column(name = "user_payment_transaction_info_saving_id", unique = true, nullable = false)
		public Integer getUserPaymentTransactionInfoSavingId() {
			return userPaymentTransactionInfoSavingId;
		}

		public void setUserPaymentTransactionInfoSavingId(
				Integer userPaymentTransactionInfoSavingId) {
			this.userPaymentTransactionInfoSavingId = userPaymentTransactionInfoSavingId;
		}

		@Column(name = "user_name", nullable = false, length = 60)
		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		@Column(name = "card_number")
		public String getCardNumber() {
			return cardNumber;
		}

		public void setCardNumber(String cardNumber) {
			this.cardNumber = cardNumber;
		}

		@Column(name = "transaction_number")
		public long getTransactionNumber() {
			return transactionNumber;
		}

		public void setTransactionNumber(long transactionNumber) {
			this.transactionNumber = transactionNumber;
		}

		@Column(name = "card_expiry_date")
		public String getCardExpiryDate() {
			return cardExpiryDate;
		}

		public void setCardExpiryDate(String cardExpiryDate) {
			this.cardExpiryDate = cardExpiryDate;
		}

		@Column(name = "amount")
		public String getAmount() {
			return amount;
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}

		@Column(name = "order_status")
		public String getOrderStatus() {
			return orderStatus;
		}

		public void setOrderStatus(String orderStatus) {
			this.orderStatus = orderStatus;
		}

		@Column(name = "billing_first_name", length = 60)
		public String getBillingFirstName() {
			return billingFirstName;
		}

		public void setBillingFirstName(String billingFirstName) {
			this.billingFirstName = billingFirstName;
		}

		@Column(name = "billing_last_name", length = 60)
		public String getBillingLastName() {
			return billingLastName;
		}

		public void setBillingLastName(String billingLastName) {
			this.billingLastName = billingLastName;
		}

		@Column(name = "billing_address")
		public String getBillingAddress() {
			return billingAddress;
		}

		public void setBillingAddress(String billingAddress) {
			this.billingAddress = billingAddress;
		}

		@Column(name = "billing_city", length = 20)
		public String getBillingCity() {
			return billingCity;
		}

		public void setBillingCity(String billingCity) {
			this.billingCity = billingCity;
		}

		@Column(name = "billing_state_name", length = 20)
		public String getBillingStateName() {
			return billingStateName;
		}

		public void setBillingStateName(String billingStateName) {
			this.billingStateName = billingStateName;
		}

		@Column(name = "billing_zip", length = 10)
		public String getBillingZip() {
			return billingZip;
		}

		public void setBillingZip(String billingZip) {
			this.billingZip = billingZip;
		}

		@Column(name = "shipping_first_name", length = 30)
		public String getShipingFirstName() {
			return shipingFirstName;
		}

		public void setShipingFirstName(String shipingFirstName) {
			this.shipingFirstName = shipingFirstName;
		}

		@Column(name = "shipping_lastname", length = 30)
		public String getShipingLastName() {
			return shipingLastName;
		}

		public void setShipingLastName(String shipingLastName) {
			this.shipingLastName = shipingLastName;
		}

		@Column(name = "shipping_address")
		public String getShipingAddress() {
			return shipingAddress;
		}

		public void setShipingAddress(String shipingAddress) {
			this.shipingAddress = shipingAddress;
		}

		@Column(name = "shipping_city", length = 20)
		public String getShipingCity() {
			return shipingCity;
		}

		public void setShipingCity(String shipingCity) {
			this.shipingCity = shipingCity;
		}

		@Column(name = "shipping_state_name", length = 20)
		public String getShipingStateName() {
			return shipingStateName;
		}

		public void setShipingStateName(String shipingStateName) {
			this.shipingStateName = shipingStateName;
		}

		@Column(name = "shipping_zip", length = 10)
		public String getShipingZip() {
			return shipingZip;
		}

		public void setShipingZip(String shipingZip) {
			this.shipingZip = shipingZip;
		}

		@Column(name = "created_date", length = 29)
		public Timestamp getCreatedDate() {
			return this.createdDate;
		}

		public void setCreatedDate(Timestamp createdDate) {
			this.createdDate = createdDate;
		}

		@Column(name = "modified_date", length = 29)
		public Timestamp getModifiedDate() {
			return this.modifiedDate;
		}

		public void setModifiedDate(Timestamp modifiedDate) {
			this.modifiedDate = modifiedDate;
		}

		@Column(name = "authorization_code", length = 30)
		public String getAuthorizationCode() {
			return authorizationCode;
		}

		public void setAuthorizationCode(String authorizationCode) {
			this.authorizationCode = authorizationCode;
		}
		
		
		
		
}
