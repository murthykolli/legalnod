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
 * ScorporationFormsAttributesAndValuesSaving entity. @author MyEclipse
 * Persistence Tools
 */
@Entity
@Table(name = "scorporation_forms_attributes_and_values_saving", schema = "ff")
public class ScorporationFormsAttributesAndValuesSaving implements
		java.io.Serializable {

	// Fields

	private Integer scorporationFormsAttributesAndValuesSavingId;
	private String userName;
	private String corpName;
	private String scorporationFormsAttributesInfoId;
	private String capturedInformation;
	private Timestamp createdDate;
	private Timestamp modifiedDate;

	// Constructors

	/** default constructor */
	public ScorporationFormsAttributesAndValuesSaving() {
	}

	// Property accessors
	@Id
	@SequenceGenerator(name = "scorporation_forms_attributes_and_values_saving_id", sequenceName = "ff.scorporation_forms_attributes_and_values_saving_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "scorporation_forms_attributes_and_values_saving_id")
	@Column(name = "scorporation_forms_attributes_and_values_saving_id", unique = true, nullable = false)
	public Integer getScorporationFormsAttributesAndValuesSavingId() {
		return this.scorporationFormsAttributesAndValuesSavingId;
	}

	public void setScorporationFormsAttributesAndValuesSavingId(
			Integer scorporationFormsAttributesAndValuesSavingId) {
		this.scorporationFormsAttributesAndValuesSavingId = scorporationFormsAttributesAndValuesSavingId;
	}

	@Column(name = "user_name", length = 60)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "corp_name")
	public String getCorpName() {
		return this.corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	@Column(name = "scorporation_forms_attributes_info_id")
	public String getScorporationFormsAttributesInfoId() {
		return this.scorporationFormsAttributesInfoId;
	}

	public void setScorporationFormsAttributesInfoId(
			String scorporationFormsAttributesInfoId) {
		this.scorporationFormsAttributesInfoId = scorporationFormsAttributesInfoId;
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