package com.legalnod.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AdditionalFormsFieldsInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "additional_forms_fields_info", schema = "bs")
public class AdditionalFormsFieldsInfo implements java.io.Serializable {

	// Fields

	private Integer additionalFormsFieldsInfoId;
	private String attributeType;
	private String attributeValue;
	private Date loadedDate;
	private String loadedBy;
	private Date modifiedDate;
	private String modifiedBy;

	// Constructors

	/** default constructor */
	public AdditionalFormsFieldsInfo() {
	}

	// Property accessors
	@Id
	@Column(name = "additional_forms_fields_info_id", unique = true, nullable = false)
	public Integer getAdditionalFormsFieldsInfoId() {
		return this.additionalFormsFieldsInfoId;
	}

	public void setAdditionalFormsFieldsInfoId(
			Integer additionalFormsFieldsInfoId) {
		this.additionalFormsFieldsInfoId = additionalFormsFieldsInfoId;
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