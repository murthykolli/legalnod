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
 * FormFederalDocumentsDataSaving entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "form_federal_documents_data_saving", schema = "bs")
public class FormFederalDocumentsDataSaving implements java.io.Serializable {

	// Fields

	private Integer formFederalDocumentsDataSavingId;
	private String userName;
	private String legalName;
	private String formName;
	private String stateName;
	private String userChoice;
	private String status;
	private String orderStatus;
	private Timestamp createdDate;
	private Timestamp modifiedDate;
	private String addToCart;
	private String pageVariableReference;

	// Constructors

	/** default constructor */
	public FormFederalDocumentsDataSaving() {
	}

	// Property accessors
	@Id
	@SequenceGenerator(name = "form_federal_documents_data_saving_id", sequenceName = "bs.form_federal_documents_data_saving_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "form_federal_documents_data_saving_id")
	@Column(name = "form_federal_documents_data_saving_id", unique = true, nullable = false)
	public Integer getFormFederalDocumentsDataSavingId() {
		return this.formFederalDocumentsDataSavingId;
	}

	public void setFormFederalDocumentsDataSavingId(
			Integer formFederalDocumentsDataSavingId) {
		this.formFederalDocumentsDataSavingId = formFederalDocumentsDataSavingId;
	}

	@Column(name = "user_name", length = 60)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "legal_name")
	public String getLegalName() {
		return this.legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	@Column(name = "form_name", length = 100)
	public String getFormName() {
		return this.formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	@Column(name = "state_name", length = 50)
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

	@Column(name = "status", length = 30)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "order_status")
	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Column(name = "created_date", nullable = false, length = 29)
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

	@Column(name = "add_to_cart", length = 20)
	public String getAddToCart() {
		return this.addToCart;
	}

	public void setAddToCart(String addToCart) {
		this.addToCart = addToCart;
	}

	@Column(name = "page_variable_reference", length = 30)
	public String getPageVariableReference() {
		return this.pageVariableReference;
	}

	public void setPageVariableReference(String pageVariableReference) {
		this.pageVariableReference = pageVariableReference;
	}

}