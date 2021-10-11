package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.models.ErsReimbursement;
import com.revature.models.ErsReimbursementStatus;
import com.revature.models.ErsReimbursementType;
import com.revature.models.ErsUser;
import com.revature.services.ErsReimbursementService;
import com.revature.services.LoginService;

public class Tests {
	
	public static ErsReimbursementService ers;
	public static LoginService logS = new LoginService();
	
	//some reference variables
	static ErsReimbursementStatus ersStatus1 = new ErsReimbursementStatus("pending");
	static ErsReimbursementStatus ersStatus2 = new ErsReimbursementStatus("approved");
	static ErsReimbursementStatus ersStatus3 = new ErsReimbursementStatus("denied");
	
	static ErsReimbursementType ersType1 = new ErsReimbursementType("food");
	static ErsReimbursementType ersType2 = new ErsReimbursementType("travel");
	static ErsReimbursementType ersType3 = new ErsReimbursementType("lodging");
	static ErsReimbursementType ersType4 = new ErsReimbursementType("other");
	
	
	//variables to change the date
	static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //this will format my dates to be SQL acceptable 
	static Date date = new Date(); //from java.util - we will convert it into a java.sql Date 
	static String currentDate = dateFormat.format(date); 
	
	
	//variables to be used for arguments of the test methods
	public static int reimb_amount = 500;
	
	public static String reimb_submitted = "2021-10-15"; 
	
	public static Date reimb_resolved = java.sql.Date.valueOf(currentDate);
	
	
	public static String reimb_description = "For transportation";
	
	
	public static int reimb_receipt = 11;
	
	public static ErsUser reimb_author = null;
	
	public static ErsUser reimb_resolver = null;
	
	public static ErsReimbursementStatus reimb_status = ersStatus1;
	
	public static ErsReimbursementType reimb_type = ersType2;
	
	
	
	String manager  = "manager";
	String pass = "456";
	
	String employee = "john";
	String pass2 = "123";
	
	
	
	public ErsReimbursement result; //this one is uninitialized for now
	
	
	
	
	
	@BeforeAll 
	public static void createErsService() {
		ers = new ErsReimbursementService();
		System.out.println("In the @BeforeAll method");
		
		
		ErsReimbursement addErs = new ErsReimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_resolver, reimb_status, reimb_type);
		ers.addErsReimbursement(addErs);
	}
	
	@AfterAll 
	public static void clearErsService() {
		ers = null;
		System.out.println("In the @AfterAll method");
	}
	
	
	
	//unit tests--------------------------
	
	@Test 
	public void testGetAllErsReimbursement() {
		System.out.println("TESTING GET ALL METHOD");
		result = ers.getAllErsReimbursement().get(0); 
		assertTrue(result.getReimb_id() == 1); 
		
	}
	
	@Test
	public void testGetErsReimbursementById() {
		System.out.println("TESTING GET BY ID METHOD");
		result = ers.getErsReimbursementById(1);
		assertTrue(result.getReimb_amount() == 500); 
	}
	
	@Test
	public void testAddErsReimbursement() {
		System.out.println("TESTING ADD METHOD");
		
		ErsReimbursement addErs = new ErsReimbursement(300, "2021-10-16", "For other expenses", null, null, ersStatus2, ersType4);
		
		ers.addErsReimbursement(addErs);
		
		result = ers.getAllErsReimbursement().get(1);
		assertEquals(result.getReimb_status().getStatus(), "approved");
		
		
	}
	
	@Test
	public void testManagerLogin() {
		System.out.println("TESTING MANAGER LOGIN METHOD");
		
		
		boolean boolResult = logS.mLogin(manager, pass);
			
		assertTrue(boolResult == true);
	}
	
	@Test
	public void testEmployeeLogin() {
		System.out.println("TESTING EMPLOYEE LOGIN METHOD");
		
		
		boolean boolResult2 = logS.eLogin(employee, pass2);
			
		assertTrue(boolResult2 == true);
	}
	


}
