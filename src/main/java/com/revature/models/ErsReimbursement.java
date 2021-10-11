package com.revature.models;

import java.util.Date;

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
@Table(name = "ers_reimbursement")
public class ErsReimbursement {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "reimb_id")
	private int reimb_id;
	
	@Column(name = "reimb_amount", nullable = false)
	private int reimb_amount;
	
	@Column(name = "reimb_submitted", nullable = false)
	private String reimb_submitted; 
	
	
	
	@Column(name = "reimb_description")
	private String reimb_description;
	
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "reimb_author") 
	private ErsUser reimb_author;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "reimb_resolver")
	private ErsUser reimb_resolver;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "reimb_status")
	private ErsReimbursementStatus reimb_status;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "reimb_type")
	private ErsReimbursementType reimb_type;



	@Override
	public String toString() {
		return "ErsReimbursement [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_submitted="
				+ reimb_submitted + ", reimb_description=" + reimb_description + ", reimb_author=" + reimb_author
				+ ", reimb_resolver=" + reimb_resolver + ", reimb_status=" + reimb_status + ", reimb_type=" + reimb_type
				+ "]";
	}

	public ErsReimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErsReimbursement(int reimb_amount, String reimb_submitted, String reimb_description, ErsUser reimb_author,
			ErsUser reimb_resolver, ErsReimbursementStatus reimb_status, ErsReimbursementType reimb_type) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_description = reimb_description;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_status = reimb_status;
		this.reimb_type = reimb_type;
	}

	public ErsReimbursement(int reimb_id, int reimb_amount, String reimb_submitted, String reimb_description,
			ErsUser reimb_author, ErsUser reimb_resolver, ErsReimbursementStatus reimb_status,
			ErsReimbursementType reimb_type) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_description = reimb_description;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_status = reimb_status;
		this.reimb_type = reimb_type;
	}

	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public int getReimb_amount() {
		return reimb_amount;
	}

	public void setReimb_amount(int reimb_amount) {
		this.reimb_amount = reimb_amount;
	}

	public String getReimb_submitted() {
		return reimb_submitted;
	}

	public void setReimb_submitted(String reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}

	public String getReimb_description() {
		return reimb_description;
	}

	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}

	public ErsUser getReimb_author() {
		return reimb_author;
	}

	public void setReimb_author(ErsUser reimb_author) {
		this.reimb_author = reimb_author;
	}

	public ErsUser getReimb_resolver() {
		return reimb_resolver;
	}

	public void setReimb_resolver(ErsUser reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}

	public ErsReimbursementStatus getReimb_status() {
		return reimb_status;
	}

	public void setReimb_status(ErsReimbursementStatus reimb_status) {
		this.reimb_status = reimb_status;
	}

	public ErsReimbursementType getReimb_type() {
		return reimb_type;
	}

	public void setReimb_type(ErsReimbursementType reimb_type) {
		this.reimb_type = reimb_type;
	}

	

	
	
	

}
