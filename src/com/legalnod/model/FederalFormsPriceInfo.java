package com.legalnod.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 * FederalFormsPriceInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "federal_forms_price_info", schema = "ff")
public class FederalFormsPriceInfo implements java.io.Serializable {

	// Fields

		private Integer federalFormsPriceInfoId;
		private String typeOfFees;
		private String formName;
		private String price;

		// Constructors

		/** default constructor */
		public FederalFormsPriceInfo() {
		}

		// Property accessors
		
		@Id
		@Column(name = "federal_forms_price_info_id", unique = true, nullable = false)
		public Integer getFederalFormsPriceInfoId() {
			return this.federalFormsPriceInfoId;
		}

		public void setFederalFormsPriceInfoId(Integer federalFormsPriceInfoId) {
			this.federalFormsPriceInfoId = federalFormsPriceInfoId;
		}

		@Column(name = "type_of_fees", length = 30)
		public String getTypeOfFees() {
			return this.typeOfFees;
		}

		public void setTypeOfFees(String typeOfFees) {
			this.typeOfFees = typeOfFees;
		}

		@Column(name = "form_name", length = 150)
		public String getFormName() {
			return this.formName;
		}

		public void setFormName(String formName) {
			this.formName = formName;
		}

		@Column(name = "price")
		public String getPrice() {
			return this.price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

}