package com.revature.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.revature.dao.ErsReimbursementDao;
import com.revature.models.ErsReimbursement;
import com.revature.models.ErsReimbursementStatus;
import com.revature.services.ErsReimbursementService;

import io.javalin.http.Handler;

public class ErsReimbursementController {
	
	ErsReimbursementService ersService = new ErsReimbursementService();
	
	Logger log = LogManager.getLogger(ErsReimbursementController.class);
	
	
	public Handler getAllErsReimbursementHandler = (ctx) -> {
		
		if (ctx.req.getSession(false) != null) {
		
		List<ErsReimbursement> allErsReimbursements = ersService.getAllErsReimbursement();
		
		
		Gson gson = new Gson();
		
		String JSONErsReimburs = gson.toJson(allErsReimbursements); 
		
		ctx.result(JSONErsReimburs); 
		
		ctx.status(200); 
		log.info("User retrieved all the reimbursements info ");
		} else {
			ctx.status(403);
		}
	};
	
	public Handler getErsReimbursementByIdHandler = (ctx) -> {
		
		if (ctx.req.getSession(false) != null) {
			int id = Integer.parseInt(ctx.pathParam("id"));
			
			try {
				ErsReimbursement reimbursementById = ersService.getErsReimbursementById(id);
				Gson gson = new Gson();			
				
					String JSONreimbursById = gson.toJson(reimbursementById); 
					ctx.result(JSONreimbursById); 
			
					ctx.status(200); 
					
					log.info("User retrieved the information about id number " + id);
					
			} catch (ArrayIndexOutOfBoundsException e) {
				ctx.result("Employe reimbursement id not found!");
				ctx.status(400);
			}
			
		} else {
			ctx.status(403);
		}
	};

	public Handler addErsHandler = (ctx) -> {
		String body = ctx.body(); 
		
		Gson gson = new Gson();
		
		ErsReimbursement ers = gson.fromJson(body, ErsReimbursement.class);
		
		ersService.addErsReimbursement(ers);
		
		ctx.status(201); //201 = "created"
		log.info(ers.getReimb_author().getUser_first_name() + " added new reimbursement.");
		
	};
	
	
	public Handler updateErsReimbursementStatusHandler = (ctx) -> {
		String body = ctx.body(); 
		
		Gson gson = new Gson();
		
		ErsReimbursement ers = gson.fromJson(body, ErsReimbursement.class);
		 
        
		ersService.updateErsReimbursementStatus(ers);
		
		ctx.status(201); //201 = "created"
		log.info("The finance manager updated the status of " + ers.getReimb_author().getUser_first_name());
	};

}
