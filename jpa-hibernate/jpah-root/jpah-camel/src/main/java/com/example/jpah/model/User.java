package com.example.jpah.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Date;

@XmlRootElement(name = "User")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "fc_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	private String username;
	private String password;
	private String email;
	private String phoneNumber;

	private String challengeQ1;
	private String challengeAns1;

	private Date createdDate;
	private Date lastUpdated;
	private boolean active;
	private boolean verified;

	private String foo;


	public Integer getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getChallengeQ1() {
		return challengeQ1;
	}
	public String getChallengeAns1() {
		return challengeAns1;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public boolean isActive() {
		return active;
	}
	public boolean isVerified() {
		return verified;
	}
	public String getFoo() {
		return foo;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setChallengeQ1(String challengeQ1) {
		this.challengeQ1 = challengeQ1;
	}
	public void setChallengeAns1(String challengeAns1) {
		this.challengeAns1 = challengeAns1;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public void setFoo(String foo) {
		this.foo = foo;
	}

}
