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

/**
 * AllFederalFormsPaymentInfoSaving entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "all_federal_forms_payment_info_saving", schema = "ff")
public class AllFederalFormsPaymentInfoSaving implements java.io.Serializable {

	// Fields

	private Integer allFederalFormsPaymentInfoSavingId;
	private String userName;
	private String legalName;
	private String typeOfDocument;
	private String processingFee;
	private String totalFee;
	private Date createdDate;
	private Date updatedDate;
	private String addToCart;
	private Integer bonusPrice;

	// Constructors

	/** default constructor */
	public AllFederalFormsPaymentInfoSaving() {
	}

	// Property accessors
	@Id
	@SequenceGenerator(name = "all_federal_forms_payment_info_saving_id", sequenceName = "ff.all_federal_forms_payment_info_saving_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "all_federal_forms_payment_info_saving_id")
	@Column(name = "all_federal_forms_payment_info_saving_id", unique = true, nullable = false)
	public Integer getAllFederalFormsPaymentInfoSavingId() {
		return this.allFederalFormsPaymentInfoSavingId;
	}

	public void setAllFederalFormsPaymentInfoSavingId(
			Integer allFederalFormsPaymentInfoSavingId) {
		this.allFederalFormsPaymentInfoSavingId = allFederalFormsPaymentInfoSavingId;
	}

	@Column(name = "user_name", nullable = false, length = 60)
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

	@Column(name = "type_of_document", length = 100)
	public String getTypeOfDocument() {
		return this.typeOfDocument;
	}

	public void setTypeOfDocument(String typeOfDocument) {
		this.typeOfDocument = typeOfDocument;
	}

	@Column(name = "processing_fee", length = 20)
	public String getProcessingFee() {
		return this.processingFee;
	}

	public void setProcessingFee(String processingFee) {
		this.processingFee = processingFee;
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

	@Column(name = "add_to_cart", length = 20)
	public String getAddToCart() {
		return this.addToCart;
	}

	public void setAddToCart(String addToCart) {
		this.addToCart = addToCart;
	}
	
	@Column(name = "bonus_price")
	public Integer getBonusPrice() {
		return this.bonusPrice;
	}

	public void setBonusPrice(Integer bonusPrice) {
		this.bonusPrice = bonusPrice;
	}

}