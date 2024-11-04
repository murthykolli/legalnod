package com.legalnod.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Forms entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "forms", schema = "bs")
public class Forms implements java.io.Serializable {

	// Fields

	private Integer formId;
	private String formName;
	private String state;
	private Integer noOfAttributes;
	private Integer requiredAttributes;
	private String status;
	private String docCategory;
	private String docBusinessCategory;
	private String docSubCategoryForm;
	private String docCategoryBs;
	private Integer docOrderStatus;
	private Date loadedDate;
	private String loadedBy;
	private Date modifiedDate;
	private String modifiedBy;
	private String federalStatus;
	private String typeOfDocument;
	private String businessServicesByStates;
	private String foreignQualificationsByStates;
	private Integer requiredAttributesOld;
	private Set<BusinessFormsAttributesInfo> businessFormsAttributesInfos = new HashSet<BusinessFormsAttributesInfo>(
			0);
	private Set<BusinessFormsAttributesAndValuesSaving> businessFormsAttributesAndValuesSavings = new HashSet<BusinessFormsAttributesAndValuesSaving>(
			0);
	private Set<StateTaxFormsAttributesAndValuesSaving> stateTaxFormsAttributesAndValuesSavings = new HashSet<StateTaxFormsAttributesAndValuesSaving>(
			0);
	private Set<Abbrevations> abbrevationses = new HashSet<Abbrevations>(0);
	private Set<StateFormsPriceInfo> stateFormsPriceInfos = new HashSet<StateFormsPriceInfo>(
			0);
	private Set<AdditionalFormsAttributesInfo> additionalFormsAttributesInfos = new HashSet<AdditionalFormsAttributesInfo>(
			0);
	private Set<StateTaxFormsAttributesInfo> stateTaxFormsAttributesInfos = new HashSet<StateTaxFormsAttributesInfo>(
			0);
	private Set<AdditionalFormsAttributesAndValuesSaving> additionalFormsAttributesAndValuesSavings = new HashSet<AdditionalFormsAttributesAndValuesSaving>(
			0);

	// Constructors

	/** default constructor */
	public Forms() {
	}

	// Property accessors
	@Id
	@Column(name = "form_id", unique = true, nullable = false)
	public Integer getFormId() {
		return this.formId;
	}

	public void setFormId(Integer formId) {
		this.formId = formId;
	}

	@Column(name = "form_name", length = 100)
	public String getFormName() {
		return this.formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	@Column(name = "state", length = 20)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "no_of_attributes")
	public Integer getNoOfAttributes() {
		return this.noOfAttributes;
	}

	public void setNoOfAttributes(Integer noOfAttributes) {
		this.noOfAttributes = noOfAttributes;
	}

	@Column(name = "required_attributes")
	public Integer getRequiredAttributes() {
		return this.requiredAttributes;
	}

	public void setRequiredAttributes(Integer requiredAttributes) {
		this.requiredAttributes = requiredAttributes;
	}

	@Column(name = "status", length = 30)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "doc_category", length = 50)
	public String getDocCategory() {
		return this.docCategory;
	}

	public void setDocCategory(String docCategory) {
		this.docCategory = docCategory;
	}

	@Column(name = "doc_business_category", length = 50)
	public String getDocBusinessCategory() {
		return this.docBusinessCategory;
	}

	public void setDocBusinessCategory(String docBusinessCategory) {
		this.docBusinessCategory = docBusinessCategory;
	}

	@Column(name = "doc_sub_category_form", length = 100)
	public String getDocSubCategoryForm() {
		return this.docSubCategoryForm;
	}

	public void setDocSubCategoryForm(String docSubCategoryForm) {
		this.docSubCategoryForm = docSubCategoryForm;
	}

	@Column(name = "doc_category_bs", length = 100)
	public String getDocCategoryBs() {
		return this.docCategoryBs;
	}

	public void setDocCategoryBs(String docCategoryBs) {
		this.docCategoryBs = docCategoryBs;
	}

	@Column(name = "doc_order_status")
	public Integer getDocOrderStatus() {
		return this.docOrderStatus;
	}

	public void setDocOrderStatus(Integer docOrderStatus) {
		this.docOrderStatus = docOrderStatus;
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

	@Column(name = "modified_by", length = 50)
	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Column(name = "federal_status", length = 20)
	public String getFederalStatus() {
		return this.federalStatus;
	}

	public void setFederalStatus(String federalStatus) {
		this.federalStatus = federalStatus;
	}

	@Column(name = "type_of_document", length = 100)
	public String getTypeOfDocument() {
		return this.typeOfDocument;
	}

	public void setTypeOfDocument(String typeOfDocument) {
		this.typeOfDocument = typeOfDocument;
	}

	@Column(name = "business_services_by_states", length = 100)
	public String getBusinessServicesByStates() {
		return this.businessServicesByStates;
	}

	public void setBusinessServicesByStates(String businessServicesByStates) {
		this.businessServicesByStates = businessServicesByStates;
	}

	@Column(name = "foreign_qualifications_by_states", length = 100)
	public String getForeignQualificationsByStates() {
		return this.foreignQualificationsByStates;
	}

	public void setForeignQualificationsByStates(
			String foreignQualificationsByStates) {
		this.foreignQualificationsByStates = foreignQualificationsByStates;
	}

	@Column(name = "required_attributes_old")
	public Integer getRequiredAttributesOld() {
		return this.requiredAttributesOld;
	}

	public void setRequiredAttributesOld(Integer requiredAttributesOld) {
		this.requiredAttributesOld = requiredAttributesOld;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "forms")
	public Set<BusinessFormsAttributesInfo> getBusinessFormsAttributesInfos() {
		return this.businessFormsAttributesInfos;
	}

	public void setBusinessFormsAttributesInfos(
			Set<BusinessFormsAttributesInfo> businessFormsAttributesInfos) {
		this.businessFormsAttributesInfos = businessFormsAttributesInfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "forms")
	public Set<BusinessFormsAttributesAndValuesSaving> getBusinessFormsAttributesAndValuesSavings() {
		return this.businessFormsAttributesAndValuesSavings;
	}

	public void setBusinessFormsAttributesAndValuesSavings(
			Set<BusinessFormsAttributesAndValuesSaving> businessFormsAttributesAndValuesSavings) {
		this.businessFormsAttributesAndValuesSavings = businessFormsAttributesAndValuesSavings;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "forms")
	public Set<StateTaxFormsAttributesAndValuesSaving> getStateTaxFormsAttributesAndValuesSavings() {
		return this.stateTaxFormsAttributesAndValuesSavings;
	}

	public void setStateTaxFormsAttributesAndValuesSavings(
			Set<StateTaxFormsAttributesAndValuesSaving> stateTaxFormsAttributesAndValuesSavings) {
		this.stateTaxFormsAttributesAndValuesSavings = stateTaxFormsAttributesAndValuesSavings;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "forms")
	public Set<Abbrevations> getAbbrevationses() {
		return this.abbrevationses;
	}

	public void setAbbrevationses(Set<Abbrevations> abbrevationses) {
		this.abbrevationses = abbrevationses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "forms")
	public Set<StateFormsPriceInfo> getStateFormsPriceInfos() {
		return this.stateFormsPriceInfos;
	}

	public void setStateFormsPriceInfos(
			Set<StateFormsPriceInfo> stateFormsPriceInfos) {
		this.stateFormsPriceInfos = stateFormsPriceInfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "forms")
	public Set<AdditionalFormsAttributesInfo> getAdditionalFormsAttributesInfos() {
		return this.additionalFormsAttributesInfos;
	}

	public void setAdditionalFormsAttributesInfos(
			Set<AdditionalFormsAttributesInfo> additionalFormsAttributesInfos) {
		this.additionalFormsAttributesInfos = additionalFormsAttributesInfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "forms")
	public Set<StateTaxFormsAttributesInfo> getStateTaxFormsAttributesInfos() {
		return this.stateTaxFormsAttributesInfos;
	}

	public void setStateTaxFormsAttributesInfos(
			Set<StateTaxFormsAttributesInfo> stateTaxFormsAttributesInfos) {
		this.stateTaxFormsAttributesInfos = stateTaxFormsAttributesInfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "forms")
	public Set<AdditionalFormsAttributesAndValuesSaving> getAdditionalFormsAttributesAndValuesSavings() {
		return this.additionalFormsAttributesAndValuesSavings;
	}

	public void setAdditionalFormsAttributesAndValuesSavings(
			Set<AdditionalFormsAttributesAndValuesSaving> additionalFormsAttributesAndValuesSavings) {
		this.additionalFormsAttributesAndValuesSavings = additionalFormsAttributesAndValuesSavings;
	}

}