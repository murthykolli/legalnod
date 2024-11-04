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
 * NameAvailabilityCheckSaving entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "name_availability_check_saving", schema = "bs")
public class NameAvailabilityCheckSaving implements java.io.Serializable {

	// Fields

	private Integer nameAvailabilityCheckSavingId;
	private String userEmail;
	private String businessState;
	private String companyForming;
	private String description;
	private String businessName;
	private String alternateName1;
	private String alternateName2;
	private String alternateName3;
	private String alternateName4;
	private Timestamp createdDate;
	private Timestamp modifiedDate;
	private String status;

	// Constructors

	/** default constructor */
	public NameAvailabilityCheckSaving() {
	}

	// Property accessors
	@Id
	@SequenceGenerator(name = "name_availability_check_saving_id", sequenceName = "bs.name_availability_check_saving_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "name_availability_check_saving_id")	
	@Column(name = "name_availability_check_saving_id", unique = true, nullable = false)
	
	public Integer getNameAvailabilityCheckSavingId() {
		return this.nameAvailabilityCheckSavingId;
	}

	public void setNameAvailabilityCheckSavingId(
			Integer nameAvailabilityCheckSavingId) {
		this.nameAvailabilityCheckSavingId = nameAvailabilityCheckSavingId;
	}

	@Column(name = "user_email", nullable = false, length = 60)
	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Column(name = "business_state", length = 60)
	public String getBusinessState() {
		return this.businessState;
	}

	public void setBusinessState(String businessState) {
		this.businessState = businessState;
	}

	@Column(name = "company_forming", length = 60)
	public String getCompanyForming() {
		return this.companyForming;
	}

	public void setCompanyForming(String companyForming) {
		this.companyForming = companyForming;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "business_name")
	public String getBusinessName() {
		return this.businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	@Column(name = "alternate_name1")
	public String getAlternateName1() {
		return this.alternateName1;
	}

	public void setAlternateName1(String alternateName1) {
		this.alternateName1 = alternateName1;
	}

	@Column(name = "alternate_name2")
	public String getAlternateName2() {
		return this.alternateName2;
	}

	public void setAlternateName2(String alternateName2) {
		this.alternateName2 = alternateName2;
	}

	@Column(name = "alternate_name3")
	public String getAlternateName3() {
		return this.alternateName3;
	}

	public void setAlternateName3(String alternateName3) {
		this.alternateName3 = alternateName3;
	}

	@Column(name = "alternate_name4")
	public String getAlternateName4() {
		return this.alternateName4;
	}

	public void setAlternateName4(String alternateName4) {
		this.alternateName4 = alternateName4;
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

	@Column(name = "status", length = 100)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}