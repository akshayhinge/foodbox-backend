package com.foodbox.mvc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private Long id;
	
	@Column(nullable = false)
	private String fname;
	
	@Column(nullable = false)
	private String lname;
	
	@Column(length = 10,nullable = false,unique = true)
	private Long phoneno;
	
	@Column(nullable = false)
	private String address;
	
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = true)
	private String photoUrl;
	
	
	public Admin() {}


	


	public Admin(String fname, String lname, Long phoneno, String address, String password, String photoUrl) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.phoneno = phoneno;
		this.address = address;
		this.password = password;
		this.photoUrl = photoUrl;
	}





	public Admin(Long phoneno, String password) {
		super();
		this.phoneno = phoneno;
		this.password = password;
	}


	public String getPhotoUrl() {
		return photoUrl;
	}


	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public Long getPhoneno() {
		return phoneno;
	}


	public void setPhoneno(Long phoneno) {
		this.phoneno = phoneno;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


}
