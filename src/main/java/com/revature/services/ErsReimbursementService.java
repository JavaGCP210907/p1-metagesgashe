package com.revature.services;

import java.util.List;

import com.revature.dao.ErsReimbursementDao;
import com.revature.models.ErsReimbursement;

public class ErsReimbursementService {

	ErsReimbursementDao ersDao = new ErsReimbursementDao();
	public List<ErsReimbursement> getAllErsReimbursement(){
		return ersDao.getAllErsReimbursement();
	}
	
	public ErsReimbursement getErsReimbursementById(int id) {
		return ersDao.getErsReimbursementById(id);
	}

	public void addErsReimbursement(ErsReimbursement ers) {
		ersDao.addErsReimbursement(ers);
		
	}
	
	public void updateErsReimbursementStatus(ErsReimbursement ersReimb) {
		ersDao.updateErsReimbursementStatus(ersReimb);
	}
}
