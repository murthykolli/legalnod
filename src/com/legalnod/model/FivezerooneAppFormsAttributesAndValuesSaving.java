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
 * FivezerooneAppFormsAttributesAndValuesSaving entity. @author MyEclipse
 * Persistence Tools
 */
@Entity
@Table(name = "fivezeroone_app_forms_attributes_and_values_saving", schema = "ff")
public class FivezerooneAppFormsAttributesAndValuesSaving implements
		java.io.Serializable {

	// Fields

	private Integer fivezerooneAppFormsAttributesAndValuesSavingId;
	private String userName;
	private String appName;
	private String fivezerooneAppFormsAttributesInfoId;
	private String capturedInformation;
	private Timestamp createdDate;
	private Timestamp modifiedDate;

	// Constructors

	/** default constructor */
	public FivezerooneAppFormsAttributesAndValuesSaving() {
	}

	// Property accessors
	@Id
	@SequenceGenerator(name = "fivezeroone_app_forms_attributes_and_values_saving_id", sequenceName = "ff.fivezeroone_app_forms_attributes_and_values_saving_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "fivezeroone_app_forms_attributes_and_values_saving_id")
	@Column(name = "fivezeroone_app_forms_attributes_and_values_saving_id", unique = true, nullable = false)
	public Integer getFivezerooneAppFormsAttributesAndValuesSavingId() {
		return this.fivezerooneAppFormsAttributesAndValuesSavingId;
	}

	public void setFivezerooneAppFormsAttributesAndValuesSavingId(
			Integer fivezerooneAppFormsAttributesAndValuesSavingId) {
		this.fivezerooneAppFormsAttributesAndValuesSavingId = fivezerooneAppFormsAttributesAndValuesSavingId;
	}

	@Column(name = "user_name", length = 60)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "app_name")
	public String getAppName() {
		return this.appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	@Column(name = "fivezeroone_app_forms_attributes_info_id")
	public String getFivezerooneAppFormsAttributesInfoId() {
		return this.fivezerooneAppFormsAttributesInfoId;
	}

	public void setFivezerooneAppFormsAttributesInfoId(
			String fivezerooneAppFormsAttributesInfoId) {
		this.fivezerooneAppFormsAttributesInfoId = fivezerooneAppFormsAttributesInfoId;
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