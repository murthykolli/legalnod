package com.legalnod.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * AllStateFormsPaymentInfoSaving entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "all_state_forms_payment_info_saving", schema = "bs", uniqueConstraints = @UniqueConstraint(columnNames = {
		"user_name", "form_name", "state_name", "user_choice" }))
public class AllStateFormsPaymentInfoSaving implements java.io.Serializable {

	// Fields

	private Integer allStateFormsPaymentInfoSavingId;
	private String userName;
	private String formName;
	private String stateName;
	private String userChoice;
	private String processingFee;
	private String standardFilingFee;
	private String totalFee;
	private Date createdDate;
	private Date updatedDate;
	private String typeOfDocument;
	private String addToCart;
	private String formFedStatus;
	private String registeredAgentPrice;
	private Integer bonusPrice;

	// Constructors

	/** default constructor */
	public AllStateFormsPaymentInfoSaving() {
	}

	// Property accessors
	@Id
	@Column(name = "all_state_forms_payment_info_saving_id", unique = true, nullable = false)
	@SequenceGenerator(name = "all_state_forms_payment_info_saving_id", sequenceName = "bs.all_state_forms_payment_info_saving_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "all_state_forms_payment_info_saving_id")
	public Integer getAllStateFormsPaymentInfoSavingId() {
		return this.allStateFormsPaymentInfoSavingId;
	}

	public void setAllStateFormsPaymentInfoSavingId(
			Integer allStateFormsPaymentInfoSavingId) {
		this.allStateFormsPaymentInfoSavingId = allStateFormsPaymentInfoSavingId;
	}

	@Column(name = "user_name", nullable = false, length = 60)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "form_name", nullable = false, length = 100)
	public String getFormName() {
		return this.formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	@Column(name = "state_name", length = 20)
	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Column(name = "user_choice")
	public String getUserChoice() {
		return this.userChoice;
	}

	public void setUserChoice(String userChoice) {
		this.userChoice = userChoice;
	}

	@Column(name = "processing_fee", length = 20)
	public String getProcessingFee() {
		return this.processingFee;
	}

	public void setProcessingFee(String processingFee) {
		this.processingFee = processingFee;
	}

	@Column(name = "standard_filing_fee", length = 20)
	public String getStandardFilingFee() {
		return this.standardFilingFee;
	}

	public void setStandardFilingFee(String standardFilingFee) {
		this.standardFilingFee = standardFilingFee;
	}

	@Column(name = "total_fee", length = 20)
	public String getTotalFee() {
		return this.totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "created_date", length = 13)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "updated_date", length = 13)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "type_of_document", length = 100)
	public String getTypeOfDocument() {
		return this.typeOfDocument;
	}

	public void setTypeOfDocument(String typeOfDocument) {
		this.typeOfDocument = typeOfDocument;
	}

	@Column(name = "add_to_cart", length = 20)
	public String getAddToCart() {
		return this.addToCart;
	}

	public void setAddToCart(String addToCart) {
		this.addToCart = addToCart;
	}

	@Column(name = "form_fed_status", length = 20)
	public String getFormFedStatus() {
		return this.formFedStatus;
	}

	public void setFormFedStatus(String formFedStatus) {
		this.formFedStatus = formFedStatus;
	}

	@Column(name = "registered_agent_price", length = 30)
	public String getRegisteredAgentPrice() {
		return this.registeredAgentPrice;
	}

	public void setRegisteredAgentPrice(String registeredAgentPrice) {
		this.registeredAgentPrice = registeredAgentPrice;
	}
	
	@Column(name = "bonus_price")
	public Integer getBonusPrice() {
		return this.bonusPrice;
	}

	public void setBonusPrice(Integer bonusPrice) {
		this.bonusPrice = bonusPrice;
	}

}