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
 * AllStateFormsDataSaving entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "all_state_forms_data_saving", schema = "bs")
public class AllStateFormsDataSaving implements java.io.Serializable {

	// Fields

	private Integer allStateFormsDataSavingId;
	private String userName;
	private String typeOfDocument;
	private String formName;
	private String stateName;
	private String userChoice;
	private String status;
	private String orderStatus;
	private Integer orderNumber;
	private Timestamp createdDate;
	private Timestamp modifiedDate;
	private Timestamp deleteDate;
	private Timestamp orderedDate;
	private Timestamp orderNumberDate;
	private String federalStatus;
	private String adminDeleteStatus;
	private String formStatus;
	private String addToCart;
	private String registeredAgentPrice;
	private String pageVariableReference;
	private String formFederalLegalname;

	// Constructors

	/** default constructor */
	public AllStateFormsDataSaving() {
	}

	// Property accessors
	@Id
	@SequenceGenerator(name = "all_state_forms_data_saving_id", sequenceName = "bs.all_state_forms_data_saving_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "all_state_forms_data_saving_id")
	@Column(name = "all_state_forms_data_saving_id", unique = true, nullable = false)
	public Integer getAllStateFormsDataSavingId() {
		return this.allStateFormsDataSavingId;
	}

	public void setAllStateFormsDataSavingId(Integer allStateFormsDataSavingId) {
		this.allStateFormsDataSavingId = allStateFormsDataSavingId;
	}

	@Column(name = "user_name", nullable = false, length = 60)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "type_of_document", length = 60)
	public String getTypeOfDocument() {
		return this.typeOfDocument;
	}

	public void setTypeOfDocument(String typeOfDocument) {
		this.typeOfDocument = typeOfDocument;
	}

	@Column(name = "form_name", nullable = false, length = 100)
	public String getFormName() {
		return this.formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	@Column(name = "state_name", nullable = false, length = 20)
	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Column(name = "user_choice", nullable = false)
	public String getUserChoice() {
		return this.userChoice;
	}

	public void setUserChoice(String userChoice) {
		this.userChoice = userChoice;
	}

	@Column(name = "status", length = 20)
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

	@Column(name = "order_number", length = 20)
	public Integer getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
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

	@Column(name = "delete_date", length = 29)
	public Timestamp getDeleteDate() {
		return this.deleteDate;
	}

	public void setDeleteDate(Timestamp deleteDate) {
		this.deleteDate = deleteDate;
	}

	@Column(name = "ordered_date", length = 29)
	public Timestamp getOrderedDate() {
		return this.orderedDate;
	}

	public void setOrderedDate(Timestamp orderedDate) {
		this.orderedDate = orderedDate;
	}

	@Column(name = "order_number_date", length = 29)
	public Timestamp getOrderNumberDate() {
		return this.orderNumberDate;
	}

	public void setOrderNumberDate(Timestamp orderNumberDate) {
		this.orderNumberDate = orderNumberDate;
	}

	@Column(name = "federal_status", length = 50)
	public String getFederalStatus() {
		return this.federalStatus;
	}

	public void setFederalStatus(String federalStatus) {
		this.federalStatus = federalStatus;
	}

	@Column(name = "admin_delete_status", length = 50)
	public String getAdminDeleteStatus() {
		return this.adminDeleteStatus;
	}

	public void setAdminDeleteStatus(String adminDeleteStatus) {
		this.adminDeleteStatus = adminDeleteStatus;
	}

	@Column(name = "form_status", length = 50)
	public String getFormStatus() {
		return this.formStatus;
	}

	public void setFormStatus(String formStatus) {
		this.formStatus = formStatus;
	}

	@Column(name = "add_to_cart", length = 20)
	public String getAddToCart() {
		return this.addToCart;
	}

	public void setAddToCart(String addToCart) {
		this.addToCart = addToCart;
	}

	@Column(name = "registered_agent_price", length = 30)
	public String getRegisteredAgentPrice() {
		return this.registeredAgentPrice;
	}

	public void setRegisteredAgentPrice(String registeredAgentPrice) {
		this.registeredAgentPrice = registeredAgentPrice;
	}

	@Column(name = "page_variable_reference", length = 30)
	public String getPageVariableReference() {
		return this.pageVariableReference;
	}

	public void setPageVariableReference(String pageVariableReference) {
		this.pageVariableReference = pageVariableReference;
	}
	
	@Column(name = "form_federal_legalname")
	public String getFormFederalLegalname() {
		return formFederalLegalname;
	}

	public void setFormFederalLegalname(String formFederalLegalname) {
		this.formFederalLegalname = formFederalLegalname;
	}
	

}