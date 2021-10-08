package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ers_user_roles")
public class ErsUserRole {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "ers_user_role_id")
	private int ers_user_role_id;
	private String ers_user_role;
	
	public ErsUserRole() {
		super();
		
	}
	
	public ErsUserRole(int ers_user_role_id, String ers_user_role) {
		super();
		this.ers_user_role_id = ers_user_role_id;
		this.ers_user_role = ers_user_role;
	}
	
	
	public ErsUserRole(String ers_user_role) {
		super();
		this.ers_user_role = ers_user_role;
	}

	@Override
	public String toString() {
		return "ErsUserRole [ers_user_role_id=" + ers_user_role_id + ", ers_user_role=" + ers_user_role + "]";
	}
	
	public int getErs_user_role_id() {
		return ers_user_role_id;
	}
	
	public void setErs_user_role_id(int ers_user_role_id) {
		this.ers_user_role_id = ers_user_role_id;
	}
	
	public String getErs_user_role() {
		return ers_user_role;
	}
	
	public void setErs_user_role(String ers_user_role) {
		this.ers_user_role = ers_user_role;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ers_user_role == null) ? 0 : ers_user_role.hashCode());
		result = prime * result + ers_user_role_id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErsUserRole other = (ErsUserRole) obj;
		if (ers_user_role == null) {
			if (other.ers_user_role != null)
				return false;
		} else if (!ers_user_role.equals(other.ers_user_role))
			return false;
		if (ers_user_role_id != other.ers_user_role_id)
			return false;
		return true;
	}
	
	

}


