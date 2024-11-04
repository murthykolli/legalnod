package com.legalnod.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * BusinessFormsAttributesAndValuesSaving entity. @author MyEclipse Persistence
 * Tools
 */
@Entity
@Table(name = "business_forms_attributes_and_values_saving", schema = "bs", uniqueConstraints = @UniqueConstraint(columnNames = {
		"user_id", "form_id", "business_forms_attributes_info_id",
		"user_choice", "captured_information" }))
public class BusinessFormsAttributesAndValuesSaving implements
		java.io.Serializable {

	// Fields

	private Integer businessFormsAttributesAndValuesSavingId;
	private Forms forms;
	private Integer userId;
	private String userChoice;
	private String businessFormsAttributesInfoId;
	private String capturedInformation;
	private Timestamp createdDate;
	private Timestamp modifiedDate;

	// Constructors

	/** default constructor */
	public BusinessFormsAttributesAndValuesSaving() {
	}

	// Property accessors
	@Id
	@SequenceGenerator(name = "business_forms_attributes_and_values_saving_id", sequenceName = "bs.business_forms_attributes_and_values_saving_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "business_forms_attributes_and_values_saving_id")
	@Column(name = "business_forms_attributes_and_values_saving_id", unique = true, nullable = false)
	public Integer getBusinessFormsAttributesAndValuesSavingId() {
		return this.businessFormsAttributesAndValuesSavingId;
	}

	public void setBusinessFormsAttributesAndValuesSavingId(
			Integer businessFormsAttributesAndValuesSavingId) {
		this.businessFormsAttributesAndValuesSavingId = businessFormsAttributesAndValuesSavingId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "form_id", nullable = false)
	public Forms getForms() {
		return this.forms;
	}

	public void setForms(Forms forms) {
		this.forms = forms;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "user_choice", nullable = false)
	public String getUserChoice() {
		return this.userChoice;
	}

	public void setUserChoice(String userChoice) {
		this.userChoice = userChoice;
	}

	@Column(name = "business_forms_attributes_info_id")
	public String getBusinessFormsAttributesInfoId() {
		return this.businessFormsAttributesInfoId;
	}

	public void setBusinessFormsAttributesInfoId(
			String businessFormsAttributesInfoId) {
		this.businessFormsAttributesInfoId = businessFormsAttributesInfoId;
	}

	@Column(name = "captured_information")
	public String getCapturedInformation() {
		return this.capturedInformation;
	}

	public void setCapturedInformation(String capturedInformation) {
		this.capturedInformation = capturedInformation;
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

}