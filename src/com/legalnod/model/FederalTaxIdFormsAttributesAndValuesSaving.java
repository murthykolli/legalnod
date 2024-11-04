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
 * FederalTaxIdFormsAttributesAndValuesSaving entity. @author MyEclipse
 * Persistence Tools
 */
@Entity
@Table(name = "federal_tax_id_forms_attributes_and_values_saving", schema = "ff")
public class FederalTaxIdFormsAttributesAndValuesSaving implements
		java.io.Serializable {

	// Fields

	private Integer federalTaxIdFormsAttributesAndValuesSavingId;
	private String userName;
	private String legalName;
	private String federalTaxIdFormsAttributesInfoId;
	private String capturedInformation;
	private Timestamp createdDate;
	private Timestamp modifiedDate;

	// Constructors

	/** default constructor */
	public FederalTaxIdFormsAttributesAndValuesSaving() {
	}

	// Property accessors
	@Id
	@SequenceGenerator(name = "federal_tax_id_forms_attributes_and_values_saving_id", sequenceName = "ff.federal_tax_id_forms_attributes_and_values_saving_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "federal_tax_id_forms_attributes_and_values_saving_id")
	@Column(name = "federal_tax_id_forms_attributes_and_values_saving_id", unique = true, nullable = false)
	public Integer getFederalTaxIdFormsAttributesAndValuesSavingId() {
		return this.federalTaxIdFormsAttributesAndValuesSavingId;
	}

	public void setFederalTaxIdFormsAttributesAndValuesSavingId(
			Integer federalTaxIdFormsAttributesAndValuesSavingId) {
		this.federalTaxIdFormsAttributesAndValuesSavingId = federalTaxIdFormsAttributesAndValuesSavingId;
	}

	@Column(name = "user_name", length = 60)
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

	@Column(name = "federal_tax_id_forms_attributes_info_id")
	public String getFederalTaxIdFormsAttributesInfoId() {
		return this.federalTaxIdFormsAttributesInfoId;
	}

	public void setFederalTaxIdFormsAttributesInfoId(
			String federalTaxIdFormsAttributesInfoId) {
		this.federalTaxIdFormsAttributesInfoId = federalTaxIdFormsAttributesInfoId;
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