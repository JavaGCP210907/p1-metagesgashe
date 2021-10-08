package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ers_reimbursement_type")
public class ErsReimbursementType {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "reimb_type_id")
	private int reimb_type_id;
	private String type;
	
	
	public ErsReimbursementType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErsReimbursementType(String type) {
		super();
		this.type = type;
	}
	
	

	public ErsReimbursementType(int reimb_type_id, String type) {
		super();
		this.reimb_type_id = reimb_type_id;
		this.type = type;
	}

	@Override
	public String toString() {
		return "ErsReimbursementType [reimb_type_id=" + reimb_type_id + ", type=" + type + "]";
	}

	public int getReimb_type_id() {
		return reimb_type_id;
	}

	public void setReimb_type_id(int reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	

}
