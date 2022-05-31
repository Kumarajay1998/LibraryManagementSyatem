package com.example.demo.Entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Columns;

@Entity
@Table(name="USERS")

public class User {
@Id
//@GeneratedValue
@GeneratedValue(strategy = GenerationType.IDENTITY)

private int id;
private String name ;

@Column(unique=true, nullable=false)
private String email;

@Column(nullable=false)
private String passwords;
private String role;
private String telephone;
private Date createdAt;
private Date updatedAt;

@Transient
private String message;
@Transient
private String statuscode;


public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getStatuscode() {
	return statuscode;
}
public void setStatuscode(String statuscode) {
	this.statuscode = statuscode;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPasswords() {
	return passwords;
}
public void setPasswords(String passwords) {
	this.passwords = passwords;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public Date getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}
public Date getUpdatedAt() {
	return updatedAt;
}
public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", email=" + email + ", passwords=" + passwords + ", role=" + role
			+ ", telephone=" + telephone + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", message="
			+ message + ", statuscode=" + statuscode + "]";
}


}
