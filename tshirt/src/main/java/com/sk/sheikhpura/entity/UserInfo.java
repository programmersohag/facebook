package com.sk.sheikhpura.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER_INFO")
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -2054386655979281969L;
    private int userId;
    @NotEmpty(message="Not Blank this Field!s")
    private String firstName;
    
    @NotEmpty(message="Not Blank this Field!s")
    private String lastName;
    
    @NotEmpty(message="Not Blank this Field!s")
    @Size(min=4, max=20)
    private String userName;
    
    @NotEmpty(message="Not Blank this Field!s")
    @Email
    private String email;
    
    @NotEmpty(message="Not Blank this Field!s")
    private String password;
    
    @NotEmpty(message="Not Blank this Field!s")
    @Size(min=3, max=50)
    private String gender;
    
    @NotEmpty(message="Not Blank this Field!s")
    @Size(min=8, max=11)
    private String phone;
    
    private boolean active;
    private String insUser;
    private Date insDate;
    private String updUser;
    private Date updDate;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID", length = 20, nullable = false)
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Column(name = "FIRST_NAME", length = 50, nullable = false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name = "LAST_NAME", length = 50, nullable = false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(name = "USER_NAME", length = 100, nullable = false)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name = "EMAIL", length = 50, nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "PASSWORD", length = 100, nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "GENDER", length = 50, nullable = false)
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Column(name = "CONTACT_NO", length = 50, nullable = false)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name = "IS_ACTIVE", length = 50, nullable = false)
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Column(name = "INS_USER", length = 50, nullable = true)
	public String getInsUser() {
		return insUser;
	}
	public void setInsUser(String insUser) {
		this.insUser = insUser;
	}
	@Column(name = "INS_DATE", length = 50, nullable = true)
	public Date getInsDate() {
		return insDate;
	}
	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}
	@Column(name = "UPD_USER", length = 50, nullable = true)
	public String getUpdUser() {
		return updUser;
	}
	public void setUpdUser(String updUser) {
		this.updUser = updUser;
	}
	@Column(name = "UPD_DATE", length = 50, nullable = true)
	public Date getUpdDate() {
		return updDate;
	}
	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}
   
    
}
