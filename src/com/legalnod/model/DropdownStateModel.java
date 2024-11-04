/**
 * 
 */
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
@Table(name = "dropdown_states_info", schema = "bs")
public class DropdownStateModel implements java.io.Serializable {
	
	// Fields
	private static final long serialVersionUID = 1L;
	private String stateName;
	private Integer stateID;
	private String documentCategory;
	private String abbrevations;
	
	/** default constructor */
	public DropdownStateModel(){
		
	}
	
	// Property accessors   GenerationType.SEQUENCE
			@Id
			/*@SequenceGenerator(name = "Users_Information_Id", sequenceName = "\"UI\".\"User_Id_Seq\"", allocationSize = 1)
			@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "Users_Information_Id")*/
			@Column(name = "dropdown_states_info_id", unique = true, nullable = false)
			public Integer getStateID() {
				return this.stateID;
			}

			public void setStateID(Integer stateID) {
				this.stateID = stateID;
			}
	
	@Column(name = "state_name", length = 100)
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Column(name = "document_category", length = 40)
	public String getDocumentCategory() {
		return documentCategory;
	}

	public void setDocumentCategory(String documentCategory) {
		this.documentCategory = documentCategory;
	}

	@Column(name = "abbrevations", length = 1000)
	public String getAbbrevations() {
		return abbrevations;
	}

	public void setAbbrevations(String abbrevations) {
		this.abbrevations = abbrevations;
	}	
	
	
	

}
