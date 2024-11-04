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
import javax.persistence.UniqueConstraint;

/**
 * StateTaxFormsAttributesInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "state_tax_forms_attributes_info", schema = "bs", uniqueConstraints = @UniqueConstraint(columnNames = {
		"state_tax_forms_attributes_info_id", "form_id" }))
public class StateTaxFormsAttributesInfo implements java.io.Serializable {

	// Fields

	private Integer stateTaxFormsAttributesInfoId;
	private Forms forms;
	private String attributeCategory;
	private String attributeName;
	private String attributeType;
	private Integer requiredType;
	private String radioButtonStatus;
	private String radioButtonIdStatus;
	private String addAnotherRbstatus;
	private Date loadedDate;
	private String loadedBy;
	private Date modifiedDate;
	private String modifiedBy;

	// Constructors

	/** default constructor */
	public StateTaxFormsAttributesInfo() {
	}

	// Property accessors
	@Id
	@Column(name = "state_tax_forms_attributes_info_id", unique = true, nullable = false)
	public Integer getStateTaxFormsAttributesInfoId() {
		return this.stateTaxFormsAttributesInfoId;
	}

	public void setStateTaxFormsAttributesInfoId(
			Integer stateTaxFormsAttributesInfoId) {
		this.stateTaxFormsAttributesInfoId = stateTaxFormsAttributesInfoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "form_id")
	public Forms getForms() {
		return this.forms;
	}

	public void setForms(Forms forms) {
		this.forms = forms;
	}

	@Column(name = "attribute_category", length = 50)
	public String getAttributeCategory() {
		return this.attributeCategory;
	}

	public void setAttributeCategory(String attributeCategory) {
		this.attributeCategory = attributeCategory;
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

	@Column(name = "required_type")
	public Integer getRequiredType() {
		return this.requiredType;
	}

	public void setRequiredType(Integer requiredType) {
		this.requiredType = requiredType;
	}

	@Column(name = "radio_button_status", length = 60)
	public String getRadioButtonStatus() {
		return this.radioButtonStatus;
	}

	public void setRadioButtonStatus(String radioButtonStatus) {
		this.radioButtonStatus = radioButtonStatus;
	}

	@Column(name = "radio_button_id_status")
	public String getRadioButtonIdStatus() {
		return this.radioButtonIdStatus;
	}

	public void setRadioButtonIdStatus(String radioButtonIdStatus) {
		this.radioButtonIdStatus = radioButtonIdStatus;
	}

	@Column(name = "add_another_rbstatus", length = 20)
	public String getAddAnotherRbstatus() {
		return this.addAnotherRbstatus;
	}

	public void setAddAnotherRbstatus(String addAnotherRbstatus) {
		this.addAnotherRbstatus = addAnotherRbstatus;
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