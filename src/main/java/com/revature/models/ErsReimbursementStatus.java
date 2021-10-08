package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ers_reimbursement_status")
public class ErsReimbursementStatus {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "reimb_status_id")
	private int reimb_status_id;
	private String status;
	
	@Override
	public String toString() {
		return "ErsReimbursementStatus [reimb_status_id=" + reimb_status_id + ", status=" + status + "]";
	}

	public ErsReimbursementStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErsReimbursementStatus(String status) {
		super();
		this.status = status;
	}

	public ErsReimbursementStatus(int reimb_status_id, String status) {
		super();
		this.reimb_status_id = reimb_status_id;
		this.status = status;
	}

	public int getReimb_status_id() {
		return reimb_status_id;
	}

	public void setReimb_status_id(int reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
