package com.legalnod.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ScorporationFormsAttributesInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "scorporation_forms_attributes_info", schema = "ff")
public class ScorporationFormsAttributesInfo implements java.io.Serializable {

	// Fields

	private Integer scorporationFormsAttributesInfoId;
	private String attributeName;
	private String attributeType;
	private String attributeFieldName;
	private String attributeValue;
	private String status;
	private Integer requiredType;
	private Date loadedDate;
	private String loadedBy;
	private Date modifiedDate;
	private String modifiedBy;
	private Integer scorporationId;

	// Constructors

	/** default constructor */
	public ScorporationFormsAttributesInfo() {
	}

	// Property accessors
	@Id
	@Column(name = "scorporation_forms_attributes_info_id", unique = true, nullable = false)
	public Integer getScorporationFormsAttributesInfoId() {
		return this.scorporationFormsAttributesInfoId;
	}

	public void setScorporationFormsAttributesInfoId(
			Integer scorporationFormsAttributesInfoId) {
		this.scorporationFormsAttributesInfoId = scorporationFormsAttributesInfoId;
	}

	@Column(name = "attribute_name")
	public String getAttributeName() {
		return this.attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	@Column(name = "attribute_type")
	public String getAttributeType() {
		return this.attributeType;
	}

	public void setAttributeType(String attributeType) {
		this.attributeType = attributeType;
	}

	@Column(name = "attribute_field_name")
	public String getAttributeFieldName() {
		return this.attributeFieldName;
	}

	public void setAttributeFieldName(String attributeFieldName) {
		this.attributeFieldName = attributeFieldName;
	}

	@Column(name = "attribute_value")
	public String getAttributeValue() {
		return this.attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	@Column(name = "status", length = 30)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "required_type")
	public Integer getRequiredType() {
		return this.requiredType;
	}

	public void setRequiredType(Integer requiredType) {
		this.requiredType = requiredType;
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

	@Column(name = "scorporation_id", length = 20)
	public Integer getScorporationId() {
		return scorporationId;
	}

	public void setScorporationId(Integer scorporationId) {
		this.scorporationId = scorporationId;
	}

}