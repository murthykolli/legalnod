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

/**
 * Abbrevations entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "abbrevations", schema = "bs")
public class Abbrevations implements java.io.Serializable {

	// Fields

	private Integer abbrevationId;
	private Forms forms;
	private String formName;
	private String state;
	private String abbrevation;
	private String replacementAbbrevation;
	private String comments;
	private String loadedBy;
	private Date loadedDate;
	private String modifiedBy;
	private Date modifiedDate;

	// Constructors

	/** default constructor */
	public Abbrevations() {
	}

	// Property accessors
	@Id
	@Column(name = "abbrevation_id", unique = true, nullable = false)
	public Integer getAbbrevationId() {
		return this.abbrevationId;
	}

	public void setAbbrevationId(Integer abbrevationId) {
		this.abbrevationId = abbrevationId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "form_id", nullable = false)
	public Forms getForms() {
		return this.forms;
	}

	public void setForms(Forms forms) {
		this.forms = forms;
	}

	@Column(name = "form_name", nullable = false, length = 100)
	public String getFormName() {
		return this.formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	@Column(name = "state", length = 30)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "abbrevation", length = 60)
	public String getAbbrevation() {
		return this.abbrevation;
	}

	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
	}

	@Column(name = "replacement_abbrevation", length = 80)
	public String getReplacementAbbrevation() {
		return this.replacementAbbrevation;
	}

	public void setReplacementAbbrevation(String replacementAbbrevation) {
		this.replacementAbbrevation = replacementAbbrevation;
	}

	@Column(name = "comments")
	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Column(name = "loaded_by", length = 20)
	public String getLoadedBy() {
		return this.loadedBy;
	}

	public void setLoadedBy(String loadedBy) {
		this.loadedBy = loadedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "loaded_date", length = 13)
	public Date getLoadedDate() {
		return this.loadedDate;
	}

	public void setLoadedDate(Date loadedDate) {
		this.loadedDate = loadedDate;
	}

	@Column(name = "modified_by", length = 20)
	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "modified_date", length = 13)
	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}