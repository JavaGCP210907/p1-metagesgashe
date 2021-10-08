package com.revature.dao;

import java.util.List;

import com.revature.models.ErsReimbursement;

public interface ErsReimbursementDaoInterface {
	
	public List<ErsReimbursement> getAllErsReimbursement();
	public List<ErsReimbursement> getErsReimbursementByStatus(String status);
	public void updateErsReimbursementStatus(ErsReimbursement ersReimb);
	public ErsReimbursement getErsReimbursementById(int id);
	public void addErsReimbursement(ErsReimbursement ersReimb);
	

}
