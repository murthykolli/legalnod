package com.legalnod.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * BusinessFormsFieldsInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "business_forms_fields_info", schema = "bs")
public class BusinessFormsFieldsInfo implements java.io.Serializable {

	// Fields

	private Integer businessFormsFieldsInfoId;
	private String attributeType;
	private String attributeValue;
	private Date loadedDate;
	private String loadedBy;
	private Date modifiedDate;
	private String modifiedBy;

	// Constructors

	/** default constructor */
	public BusinessFormsFieldsInfo() {
	}

	// Property accessors
	@Id
	@Column(name = "business_forms_fields_info_id", unique = true, nullable = false)
	public Integer getBusinessFormsFieldsInfoId() {
		return this.businessFormsFieldsInfoId;
	}

	public void setBusinessFormsFieldsInfoId(Integer businessFormsFieldsInfoId) {
		this.businessFormsFieldsInfoId = businessFormsFieldsInfoId;
	}

	@Column(name = "attribute_type", length = 20)
	public String getAttributeType() {
		return this.attributeType;
	}

	public void setAttributeType(String attributeType) {
		this.attributeType = attributeType;
	}

	@Column(name = "attribute_value")
	public String getAttributeValue() {
		return this.attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "loaded_date", length = 13)
	public Date getLoadedDate() {
		return this.loadedDate;
	}

	public void setLoadedDate(Date loadedDate) {
		this.loadedDate = loadedDate;
	}

	@Column(name = "loaded_by", length = 20)
	public String getLoadedBy() {
		return this.loadedBy;
	}

	public void setLoadedBy(String loadedBy) {
		this.loadedBy = loadedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "modified_date", length = 13)
	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Column(name = "modified_by", length = 20)
	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}