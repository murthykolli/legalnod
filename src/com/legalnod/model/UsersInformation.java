package com.legalnod.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * UsersInformation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "users_information", schema = "ui", uniqueConstraints = @UniqueConstraint(columnNames = "user_name"))
public class UsersInformation implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;	
	private String passwordSalt;
	private String typeOfUser;
	private Timestamp createdDate;	
	private Timestamp lastPasswordChangedDate;
	private String securityPin;
	private Timestamp emailSentDate;
	private String adminType;
	private Set<UsersSessionTime> usersSessionTimes = new HashSet<UsersSessionTime>(
			0);

	// Constructors

	/** default constructor */
	public UsersInformation() {
	}

	// Property accessors
	@Id	
	@SequenceGenerator(name = "users_information_id", sequenceName = "ui.users_information_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "users_information_id")	
	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "user_name", unique = true, nullable = false, length = 60)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password", nullable = false, length = 128)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "first_name", length = 60)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", length = 128)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "password_salt", nullable = false, length = 128)
	public String getPasswordSalt() {
		return this.passwordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	@Column(name = "type_of_user", length = 2)
	public String getTypeOfUser() {
		return this.typeOfUser;
	}

	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}

	@Column(name = "created_date", nullable = false, length = 29)
	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}	

	@Column(name = "last_password_changed_date", length = 29)
	public Timestamp getLastPasswordChangedDate() {
		return this.lastPasswordChangedDate;
	}

	public void setLastPasswordChangedDate(Timestamp lastPasswordChangedDate) {
		this.lastPasswordChangedDate = lastPasswordChangedDate;
	}

	@Column(name = "security_pin", length = 30)
	public String getSecurityPin() {
		return this.securityPin;
	}

	public void setSecurityPin(String securityPin) {
		this.securityPin = securityPin;
	}

	@Column(name = "email_sent_date", length = 29)
	public Timestamp getEmailSentDate() {
		return this.emailSentDate;
	}

	public void setEmailSentDate(Timestamp emailSentDate) {
		this.emailSentDate = emailSentDate;
	}

	@Column(name = "admin_type", length = 50)
	public String getAdminType() {
		return this.adminType;
	}

	public void setAdminType(String adminType) {
		this.adminType = adminType;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usersInformation")
	public Set<UsersSessionTime> getUsersSessionTimes() {
		return this.usersSessionTimes;
	}

	public void setUsersSessionTimes(Set<UsersSessionTime> usersSessionTimes) {
		this.usersSessionTimes = usersSessionTimes;
	}

}