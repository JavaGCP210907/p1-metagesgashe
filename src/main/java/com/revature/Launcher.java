package com.revature;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.revature.controllers.ErsReimbursementController;
import com.revature.controllers.LoginController;
import com.revature.dao.ErsReimbursementDao;
import com.revature.dao.ErsUserDao;
import com.revature.models.ErsReimbursement;
import com.revature.models.ErsReimbursementStatus;
import com.revature.models.ErsReimbursementType;
import com.revature.models.ErsUser;
import com.revature.models.ErsUserRole;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {
	public static void main(String[] args) {
		
		ErsReimbursementDao ersReimbDao = new ErsReimbursementDao();
		ErsUserDao ersUserDao = new ErsUserDao();
		
		
		
		
		ErsUserRole ersUrole1 = new ErsUserRole("employee");
		ErsUserRole ersUrole2 = new ErsUserRole("f_manager");
		
		ErsUser ersU1 = new ErsUser("employee1user", "employee1pass", "John", "Doe", "johndoe@example.com", ersUrole1);
		ErsUser ersU2 = new ErsUser("employee2user", "employee2pass", "Alex", "Smith", "alexsmith@example.com", ersUrole1);
		ErsUser ersU3 = new ErsUser("employee3user", "employee3pass", "Thomas", "George", "thomasgeorge@example.com", ersUrole1);
		ErsUser ersU4 = new ErsUser("f_manageruser", "f_managerpass", "Ema", "Ray", "emaray@example.com", ersUrole2);
		
		ErsReimbursementType ersType1 = new ErsReimbursementType("lodging");
		ErsReimbursementType ersType2= new ErsReimbursementType("travel");
		ErsReimbursementType ersType3 = new ErsReimbursementType("food");
		ErsReimbursementType ersType4 = new ErsReimbursementType("other");
		
		ErsReimbursementStatus ersStatus1 = new ErsReimbursementStatus("pending");
		ErsReimbursementStatus ersStatus2 = new ErsReimbursementStatus("approved");
		ErsReimbursementStatus ersStatus3 = new ErsReimbursementStatus("denied");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //this will format my dates to be SQL acceptable 
		Date date = new Date(); //from java.util - we will convert it into a java.sql Date 
		String currentDate = dateFormat.format(date); 
		
		
		
		ErsReimbursement ersRimb1 = new ErsReimbursement(300, "2021-09-27", null, "imbursement for lodging cost", 10, ersU1, ersU4, ersStatus1, ersType1);
		ErsReimbursement ersRimb2 = new ErsReimbursement(200, "2021-09-27", java.sql.Date.valueOf(currentDate), "imbursement for food cost", 20, ersU2, ersU4, ersStatus2, ersType3);
		ErsReimbursement ersRimb3 = new ErsReimbursement(600, "2021-09-27", null, "imbursement for travel cost", 30, ersU3, ersU4, ersStatus3, ersType2);
		
		ersReimbDao.addErsReimbursement(ersRimb1);
		ersReimbDao.addErsReimbursement(ersRimb2);
		ersReimbDao.addErsReimbursement(ersRimb3);

		
		
		
		
		List<ErsReimbursement> allErs = ersReimbDao.getAllErsReimbursement();
		
		for (ErsReimbursement ers : allErs) {
			System.out.println(ers);
		}
		
		//update ersReimbursement
		
//		System.out.println(ersReimbDao.getErsReimbursementById(1));
//		
//		ersRimb1.setReimb_status(ersStatus2);
//		
//		ersReimbDao.updateErsReimbursementStatus(ersRimb1);
//		
//		System.out.println(ersReimbDao.getErsReimbursementById(1));
		
		
		ErsReimbursementController ersC = new ErsReimbursementController();
		LoginController lc = new LoginController(); 
		
		
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println(("Successfully connected!"));
		} catch (SQLException e) {
			System.err.println("Connection failed");
			e.printStackTrace();
		}

		
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins(); //allows the server to process JS requests from anywhere
				
				}
				).start(8090);
		
		
		app.post("/eLogin", lc.employeeLoginHandler);
		app.post("/mLogin", lc.managerLoginHandler);
		
    	app.get("/allErs", ersC.getAllErsReimbursementHandler);
	
        app.get("/ersById/:id", ersC.getErsReimbursementByIdHandler);
		
		
        
		app.post("/submit", ersC.addErsHandler);
		
		app.post("/update", ersC.updateErsReimbursementStatusHandler);
		        
				
		        
	}

}
