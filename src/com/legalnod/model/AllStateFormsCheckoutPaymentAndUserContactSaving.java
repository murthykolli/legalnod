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
@Table(name = "all_state_forms_checkout_payment_and_user_contact_saving", schema = "bs")
public class AllStateFormsCheckoutPaymentAndUserContactSaving implements
		java.io.Serializable {

	// Fields

	private Integer allStateFormsCheckoutPaymentAndUserContactSavingId;
	private String userName;
	private String formName;
	private String stateName;
	private String userChoice;
	private String responseReasonText;
	private Integer invoiceNum;
	private String amount;
	private String orderReceived;
	private Timestamp orderReceivedCreatedDate;
	private String orderProcessed;
	private Timestamp orderProcessedCreatedDate;
	private String signature;
	private Timestamp signatureCreatedDate;
	private String docFiled;
	private Timestamp docFiledCreatedDate;
	private String docAccepted;
	private Timestamp docAcceptedCreatedDate;
	private String docEmailed;
	private Timestamp docEmailedCreatedDate;
	private Timestamp createdDate;
	private Timestamp modifiedDate;
	private String typeOfDocument;
	private String addToCart;
	private String documentRefType;	
	private String formFedLegalname;
	private String registeredAgentPrice;
	private Integer userPaymentTransactionInfoSavingId;

	// Constructors

	/** default constructor */
	public AllStateFormsCheckoutPaymentAndUserContactSaving() {
	}

	// Property accessors
	@Id
	@SequenceGenerator(name = "all_state_forms_checkout_payment_and_user_contact_saving_id", sequenceName = "bs.all_state_forms_checkout_payment_and_user_contact_saving_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "all_state_forms_checkout_payment_and_user_contact_saving_id")
	@Column(name = "all_state_forms_checkout_payment_and_user_contact_saving_id", unique = true, nullable = false)
	public Integer getAllStateFormsCheckoutPaymentAndUserContactSavingId() {
		return this.allStateFormsCheckoutPaymentAndUserContactSavingId;
	}

	public void setAllStateFormsCheckoutPaymentAndUserContactSavingId(
			Integer allStateFormsCheckoutPaymentAndUserContactSavingId) {
		this.allStateFormsCheckoutPaymentAndUserContactSavingId = allStateFormsCheckoutPaymentAndUserContactSavingId;
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

	@Column(name = "response_reason_text")
	public String getResponseReasonText() {
		return this.responseReasonText;
	}

	public void setResponseReasonText(String responseReasonText) {
		this.responseReasonText = responseReasonText;
	}

	@Column(name = "invoice_num")
	public Integer getInvoiceNum() {
		return this.invoiceNum;
	}

	public void setInvoiceNum(Integer invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	@Column(name = "amount", precision = 15)
	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Column(name = "order_received", length = 30)
	public String getOrderReceived() {
		return this.orderReceived;
	}

	public void setOrderReceived(String orderReceived) {
		this.orderReceived = orderReceived;
	}

	@Column(name = "order_received_created_date", length = 29)
	public Timestamp getOrderReceivedCreatedDate() {
		return this.orderReceivedCreatedDate;
	}

	public void setOrderReceivedCreatedDate(Timestamp orderReceivedCreatedDate) {
		this.orderReceivedCreatedDate = orderReceivedCreatedDate;
	}

	@Column(name = "order_processed", length = 30)
	public String getOrderProcessed() {
		return this.orderProcessed;
	}

	public void setOrderProcessed(String orderProcessed) {
		this.orderProcessed = orderProcessed;
	}

	@Column(name = "order_processed_created_date", length = 29)
	public Timestamp getOrderProcessedCreatedDate() {
		return this.orderProcessedCreatedDate;
	}

	public void setOrderProcessedCreatedDate(Timestamp orderProcessedCreatedDate) {
		this.orderProcessedCreatedDate = orderProcessedCreatedDate;
	}

	@Column(name = "signature", length = 30)
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	@Column(name = "signature_created_date", length = 29)
	public Timestamp getSignatureCreatedDate() {
		return signatureCreatedDate;
	}

	public void setSignatureCreatedDate(Timestamp signatureCreatedDate) {
		this.signatureCreatedDate = signatureCreatedDate;
	}

	@Column(name = "doc_filed", length = 30)
	public String getDocFiled() {
		return this.docFiled;
	}

	public void setDocFiled(String docFiled) {
		this.docFiled = docFiled;
	}

	@Column(name = "doc_filed_created_date", length = 29)
	public Timestamp getDocFiledCreatedDate() {
		return this.docFiledCreatedDate;
	}

	public void setDocFiledCreatedDate(Timestamp docFiledCreatedDate) {
		this.docFiledCreatedDate = docFiledCreatedDate;
	}

	@Column(name = "doc_accepted", length = 30)
	public String getDocAccepted() {
		return this.docAccepted;
	}

	public void setDocAccepted(String docAccepted) {
		this.docAccepted = docAccepted;
	}

	@Column(name = "doc_accepted_created_date", length = 29)
	public Timestamp getDocAcceptedCreatedDate() {
		return this.docAcceptedCreatedDate;
	}

	public void setDocAcceptedCreatedDate(Timestamp docAcceptedCreatedDate) {
		this.docAcceptedCreatedDate = docAcceptedCreatedDate;
	}

	@Column(name = "doc_emailed", length = 30)
	public String getDocEmailed() {
		return this.docEmailed;
	}

	public void setDocEmailed(String docEmailed) {
		this.docEmailed = docEmailed;
	}

	@Column(name = "doc_emailed_created_date", length = 29)
	public Timestamp getDocEmailedCreatedDate() {
		return this.docEmailedCreatedDate;
	}

	public void setDocEmailedCreatedDate(Timestamp docEmailedCreatedDate) {
		this.docEmailedCreatedDate = docEmailedCreatedDate;
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

	@Column(name = "document_ref_type", length = 20)
	public String getDocumentRefType() {
		return this.documentRefType;
	}

	public void setDocumentRefType(String documentRefType) {
		this.documentRefType = documentRefType;
	}

	@Column(name = "form_fed_legalname", length = 250)
	public String getFormFedLegalname() {
		return this.formFedLegalname;
	}

	public void setFormFedLegalname(String formFedLegalname) {
		this.formFedLegalname = formFedLegalname;
	}

	@Column(name = "registered_agent_price", length = 30)
	public String getRegisteredAgentPrice() {
		return this.registeredAgentPrice;
	}

	public void setRegisteredAgentPrice(String registeredAgentPrice) {
		this.registeredAgentPrice = registeredAgentPrice;
	}
	
	@Column(name = "user_payment_transaction_info_saving_id")
	public Integer getUserPaymentTransactionInfoSavingId() {
		return userPaymentTransactionInfoSavingId;
	}

	public void setUserPaymentTransactionInfoSavingId(
			Integer userPaymentTransactionInfoSavingId) {
		this.userPaymentTransactionInfoSavingId = userPaymentTransactionInfoSavingId;
	}

}