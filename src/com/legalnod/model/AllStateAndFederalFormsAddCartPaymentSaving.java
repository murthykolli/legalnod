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
 * AllStateAndFederalFormsAddCartPaymentSaving entity. @author MyEclipse
 * Persistence Tools
 */
@Entity
@Table(name = "all_state_and_federal_forms_add_cart_payment_saving", schema = "bs")
public class AllStateAndFederalFormsAddCartPaymentSaving implements
		java.io.Serializable {

	// Fields

	private Integer allStateAndFederalFormsAddCartPaymentSavingId;
	private String userName;
	private String selectedDocumentsName;
	private String typeOfDocument;
	private String amount;
	private String addToCart;
	private String responseReasonText;
	private Integer paymentId;
	private String documentRefType;
	private Timestamp createdDate;
	private String formName;
	private String stateName;
	private String userChoice;

	// Constructors

	/** default constructor */
	public AllStateAndFederalFormsAddCartPaymentSaving() {
	}

	// Property accessors
	@Id
	@SequenceGenerator(name = "all_state_and_federal_forms_add_cart_payment_saving_id", sequenceName = "bs.all_state_and_federal_forms_add_cart_payment_saving", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "all_state_and_federal_forms_add_cart_payment_saving_id")
	@Column(name = "all_state_and_federal_forms_add_cart_payment_saving_id", unique = true, nullable = false)
	public Integer getAllStateAndFederalFormsAddCartPaymentSavingId() {
		return this.allStateAndFederalFormsAddCartPaymentSavingId;
	}

	public void setAllStateAndFederalFormsAddCartPaymentSavingId(
			Integer allStateAndFederalFormsAddCartPaymentSavingId) {
		this.allStateAndFederalFormsAddCartPaymentSavingId = allStateAndFederalFormsAddCartPaymentSavingId;
	}

	@Column(name = "user_name", nullable = false, length = 60)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "selected_documents_name", nullable = false)
	public String getSelectedDocumentsName() {
		return this.selectedDocumentsName;
	}

	public void setSelectedDocumentsName(String selectedDocumentsName) {
		this.selectedDocumentsName = selectedDocumentsName;
	}

	@Column(name = "type_of_document", nullable = false, length = 100)
	public String getTypeOfDocument() {
		return this.typeOfDocument;
	}

	public void setTypeOfDocument(String typeOfDocument) {
		this.typeOfDocument = typeOfDocument;
	}

	@Column(name = "amount", precision = 15)
	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Column(name = "add_to_cart", length = 20)
	public String getAddToCart() {
		return this.addToCart;
	}

	public void setAddToCart(String addToCart) {
		this.addToCart = addToCart;
	}

	@Column(name = "response_reason_text")
	public String getResponseReasonText() {
		return this.responseReasonText;
	}

	public void setResponseReasonText(String responseReasonText) {
		this.responseReasonText = responseReasonText;
	}

	@Column(name = "payment_id")
	public Integer getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	@Column(name = "document_ref_type", length = 20)
	public String getDocumentRefType() {
		return this.documentRefType;
	}

	public void setDocumentRefType(String documentRefType) {
		this.documentRefType = documentRefType;
	}

	@Column(name = "created_date", length = 29)
	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "form_name", length = 100)
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

}