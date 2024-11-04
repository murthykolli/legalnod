package com.legalnod.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * FivezerooneAppFormsAttributesInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "fivezeroone_app_forms_attributes_info", schema = "ff")
public class FivezerooneAppFormsAttributesInfo implements java.io.Serializable {

	// Fields

	private Integer fivezerooneAppFormsAttributesInfoId;
	private String attributeName;
	private String attributeSmallName;
	private String attributeType;
	private String attributeValue;
	private String status;
	private Integer requiredAttribute;
	private String attributeType1;
	private Date loadedDate;
	private String loadedBy;
	private Date modifiedDate;
	private String modifiedBy;
	private Integer fivezerooneId;

	// Constructors

	/** default constructor */
	public FivezerooneAppFormsAttributesInfo() {
	}

	// Property accessors
	@Id
	@Column(name = "fivezeroone_app_forms_attributes_info_id", unique = true, nullable = false)
	public Integer getFivezerooneAppFormsAttributesInfoId() {
		return this.fivezerooneAppFormsAttributesInfoId;
	}

	public void setFivezerooneAppFormsAttributesInfoId(
			Integer fivezerooneAppFormsAttributesInfoId) {
		this.fivezerooneAppFormsAttributesInfoId = fivezerooneAppFormsAttributesInfoId;
	}

	@Column(name = "attribute_name")
	public String getAttributeName() {
		return this.attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	@Column(name = "attribute_small_name")
	public String getAttributeSmallName() {
		return this.attributeSmallName;
	}

	public void setAttributeSmallName(String attributeSmallName) {
		this.attributeSmallName = attributeSmallName;
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

	@Column(name = "status", length = 50)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "required_attribute")
	public Integer getRequiredAttribute() {
		return this.requiredAttribute;
	}

	public void setRequiredAttribute(Integer requiredAttribute) {
		this.requiredAttribute = requiredAttribute;
	}

	@Column(name = "attribute_type1", length = 50)
	public String getAttributeType1() {
		return this.attributeType1;
	}

	public void setAttributeType1(String attributeType1) {
		this.attributeType1 = attributeType1;
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

	@Column(name = "fivezeroone_id", length = 20)
	public Integer getFivezerooneId() {
		return fivezerooneId;
	}

	public void setFivezerooneId(Integer fivezerooneId) {
		this.fivezerooneId = fivezerooneId;
	}

}