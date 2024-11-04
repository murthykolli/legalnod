package com.legalnod.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * StateFormsPriceInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "state_forms_price_info", schema = "bs")
public class StateFormsPriceInfo implements java.io.Serializable {

	// Fields

	private Integer stateFormsPriceInfoId;
	private Forms forms;
	private String typeOfFees;
	private String formName;
	private String state;
	private String price;
	private String comments;
	private Integer noOfPartners;
	private Double maximumPrice;
	private Double minimumPrice;
	private String flag;
	private String loadedBy;
	private Date loadedDate;
	private String modifiedBy;
	private Date modifiedDate;
	private String crossCheckingStatus;

	// Constructors

	/** default constructor */
	public StateFormsPriceInfo() {
	}

	// Property accessors
	@Id
	@Column(name = "state_forms_price_info_id", unique = true, nullable = false)
	public Integer getStateFormsPriceInfoId() {
		return this.stateFormsPriceInfoId;
	}

	public void setStateFormsPriceInfoId(Integer stateFormsPriceInfoId) {
		this.stateFormsPriceInfoId = stateFormsPriceInfoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "form_id")
	public Forms getForms() {
		return this.forms;
	}

	public void setForms(Forms forms) {
		this.forms = forms;
	}

	@Column(name = "type_of_fees", length = 30)
	public String getTypeOfFees() {
		return this.typeOfFees;
	}

	public void setTypeOfFees(String typeOfFees) {
		this.typeOfFees = typeOfFees;
	}

	@Column(name = "form_name", length = 150)
	public String getFormName() {
		return this.formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	@Column(name = "state", length = 30)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "price", precision = 10)
	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Column(name = "comments")
	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Column(name = "no_of_partners")
	public Integer getNoOfPartners() {
		return this.noOfPartners;
	}

	public void setNoOfPartners(Integer noOfPartners) {
		this.noOfPartners = noOfPartners;
	}

	@Column(name = "maximum_price", precision = 10)
	public Double getMaximumPrice() {
		return this.maximumPrice;
	}

	public void setMaximumPrice(Double maximumPrice) {
		this.maximumPrice = maximumPrice;
	}

	@Column(name = "minimum_price", precision = 10)
	public Double getMinimumPrice() {
		return this.minimumPrice;
	}

	public void setMinimumPrice(Double minimumPrice) {
		this.minimumPrice = minimumPrice;
	}

	@Column(name = "flag", length = 10)
	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Column(name = "loaded_by", length = 30)
	public String getLoadedBy() {
		return this.loadedBy;
	}

	public void setLoadedBy(String loadedBy) {
		this.loadedBy = loadedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "loaded_date", length = 13)
	public Date getLoadedDate() {
		return this.loadedDate;
	}

	public void setLoadedDate(Date loadedDate) {
		this.loadedDate = loadedDate;
	}

	@Column(name = "modified_by", length = 30)
	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "modified_date", length = 13)
	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Column(name = "cross_checking_status", length = 20)
	public String getCrossCheckingStatus() {
		return this.crossCheckingStatus;
	}

	public void setCrossCheckingStatus(String crossCheckingStatus) {
		this.crossCheckingStatus = crossCheckingStatus;
	}

}