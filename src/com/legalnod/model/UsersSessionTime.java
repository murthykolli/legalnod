package com.legalnod.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UsersSessionTime entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "users_session_time", schema = "ui")
public class UsersSessionTime implements java.io.Serializable {

	// Fields

	private Integer usersSessionTimeId;
	private UsersInformation usersInformation;
	private String userName;
	private String sessionTime;
	private Timestamp loginTime;
	private Timestamp logoutTime;
	private String year;
	private String month;
	private String week;
	private String day;

	// Constructors

	/** default constructor */
	public UsersSessionTime() {
	}

	// Property accessors
	@Id
	@Column(name = "users_session_time_id", unique = true, nullable = false)
	public Integer getUsersSessionTimeId() {
		return this.usersSessionTimeId;
	}

	public void setUsersSessionTimeId(Integer usersSessionTimeId) {
		this.usersSessionTimeId = usersSessionTimeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public UsersInformation getUsersInformation() {
		return this.usersInformation;
	}

	public void setUsersInformation(UsersInformation usersInformation) {
		this.usersInformation = usersInformation;
	}

	@Column(name = "user_name", nullable = false, length = 60)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "session_time", length = 30)
	public String getSessionTime() {
		return this.sessionTime;
	}

	public void setSessionTime(String sessionTime) {
		this.sessionTime = sessionTime;
	}

	@Column(name = "login_time", nullable = false, length = 29)
	public Timestamp getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	@Column(name = "logout_time", length = 29)
	public Timestamp getLogoutTime() {
		return this.logoutTime;
	}

	public void setLogoutTime(Timestamp logoutTime) {
		this.logoutTime = logoutTime;
	}

	@Column(name = "year", length = 20)
	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Column(name = "month", length = 20)
	public String getMonth() {
		return this.month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Column(name = "week", length = 20)
	public String getWeek() {
		return this.week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	@Column(name = "day", length = 20)
	public String getDay() {
		return this.day;
	}

	public void setDay(String day) {
		this.day = day;
	}

}