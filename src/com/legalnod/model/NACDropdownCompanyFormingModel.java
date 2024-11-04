package com.legalnod.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author MurthyK
 *
 */

@Entity
@Table(name = "name_availability_check_info", schema = "bs")
public class NACDropdownCompanyFormingModel implements java.io.Serializable {
	
	// Fields
		private static final long serialVersionUID = 1L;
		private String companyForming;
		private Integer documentID;		
		
		/** default constructor */
		public NACDropdownCompanyFormingModel(){			
		}
				
		// Property accessors   GenerationType.SEQUENCE
		@Id					
		@Column(name = "name_availability_check_info_id", unique = true, nullable = false)					
		public Integer getDocumentID() {
			return documentID;
		}

		public void setDocumentID(Integer documentID) {
			this.documentID = documentID;
		}
		
		@Column(name = "company_forming", length = 60)
		public String getCompanyForming() {
			return companyForming;
		}

		public void setCompanyForming(String companyForming) {
			this.companyForming = companyForming;
		}

		
		
		
		

}
