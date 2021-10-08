package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ers_users")
public class ErsUser {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "ers_user_id")
	private int ers_user_id;
	
	
	private String ers_user_name;
	private String ers_password;
	private String user_first_name;
	private String user_last_name;
	private String user_email;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_role_id")
	private ErsUserRole user_role_id;

	@Override
	public String toString() {
		return "ErsUser [ers_user_id=" + ers_user_id + ", ers_user_name=" + ers_user_name + ", ers_password="
				+ ers_password + ", user_first_name=" + user_first_name + ", user_last_name=" + user_last_name
				+ ", user_email=" + user_email + ", user_role_id=" + user_role_id + "]";
	}

	public ErsUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErsUser(String ers_user_name, String ers_password, String user_first_name, String user_last_name,
			String user_email, ErsUserRole user_role_id) {
		super();
		this.ers_user_name = ers_user_name;
		this.ers_password = ers_password;
		this.user_first_name = user_first_name;
		this.user_last_name = user_last_name;
		this.user_email = user_email;
		this.user_role_id = user_role_id;
	}

	public ErsUser(int ers_user_id, String ers_user_name, String ers_password, String user_first_name,
			String user_last_name, String user_email, ErsUserRole user_role_id) {
		super();
		this.ers_user_id = ers_user_id;
		this.ers_user_name = ers_user_name;
		this.ers_password = ers_password;
		this.user_first_name = user_first_name;
		this.user_last_name = user_last_name;
		this.user_email = user_email;
		this.user_role_id = user_role_id;
	}

	public int getErs_user_id() {
		return ers_user_id;
	}

	public void setErs_user_id(int ers_user_id) {
		this.ers_user_id = ers_user_id;
	}

	public String getErs_user_name() {
		return ers_user_name;
	}

	public void setErs_user_name(String ers_user_name) {
		this.ers_user_name = ers_user_name;
	}

	public String getErs_password() {
		return ers_password;
	}

	public void setErs_password(String ers_password) {
		this.ers_password = ers_password;
	}

	public String getUser_first_name() {
		return user_first_name;
	}

	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}

	public String getUser_last_name() {
		return user_last_name;
	}

	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public ErsUserRole getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(ErsUserRole user_role_id) {
		this.user_role_id = user_role_id;
	}

	
	
	
	

	
	
	

}
