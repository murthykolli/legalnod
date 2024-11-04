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
 * AllFederalFormsDataSaving entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "all_federal_forms_data_saving", schema = "ff")
public class AllFederalFormsDataSaving implements java.io.Serializable {

	// Fields

	private Integer allFederalFormsDataSavingId;
	private String userName;
	private String typeOfDocument;
	private String documentName;
	private String status;
	private Timestamp createdDate;
	private Timestamp modifiedDate;
	private Timestamp deletedDate;
	private String orderStatus;
	private Integer orderNumber;
	private Timestamp orderNumberDate;
	private String addToCart;
	private String pageVariableReference;

	// Constructors

	/** default constructor */
	public AllFederalFormsDataSaving() {
	}

	// Property accessors
	@Id
	@SequenceGenerator(name = "all_federal_forms_data_saving_id", sequenceName = "ff.all_federal_forms_data_saving_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "all_federal_forms_data_saving_id")
	@Column(name = "all_federal_forms_data_saving_id", unique = true, nullable = false)
	public Integer getAllFederalFormsDataSavingId() {
		return this.allFederalFormsDataSavingId;
	}

	public void setAllFederalFormsDataSavingId(
			Integer allFederalFormsDataSavingId) {
		this.allFederalFormsDataSavingId = allFederalFormsDataSavingId;
	}

	@Column(name = "user_name", nullable = false, length = 60)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "type_of_document", nullable = false, length = 60)
	public String getTypeOfDocument() {
		return this.typeOfDocument;
	}

	public void setTypeOfDocument(String typeOfDocument) {
		this.typeOfDocument = typeOfDocument;
	}

	@Column(name = "document_name", nullable = false)
	public String getDocumentName() {
		return this.documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	@Column(name = "status", length = 50)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@Column(name = "deleted_date", length = 29)
	public Timestamp getDeletedDate() {
		return this.deletedDate;
	}

	public void setDeletedDate(Timestamp deletedDate) {
		this.deletedDate = deletedDate;
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

	@Column(name = "order_number_date", length = 29)
	public Timestamp getOrderNumberDate() {
		return this.orderNumberDate;
	}

	public void setOrderNumberDate(Timestamp orderNumberDate) {
		this.orderNumberDate = orderNumberDate;
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