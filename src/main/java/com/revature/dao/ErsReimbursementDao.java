package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.ErsReimbursement;
import com.revature.models.ErsUser;
import com.revature.utils.HibernateUtil;

public class ErsReimbursementDao implements ErsReimbursementDaoInterface {

	
	ErsUserDao ersUserDao = new ErsUserDao();
	ErsUser user = new ErsUser();
	
	@Override
	public void addErsReimbursement(ErsReimbursement ersReimb) {
		
		Session ses = HibernateUtil.getSession();
		ses.save(ersReimb);
		HibernateUtil.closeSession();
		
		
		
//						try(Connection conn = ConnectionUtil.getConnection()){
//								
//							
//								DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //this will format my dates to be SQL acceptable 
//								Date date = new Date(); //from java.util - we will convert it into a java.sql Date 
//								String currentDate = dateFormat.format(date); 
//								
//								String sql = "insert into ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)"
//										+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//								
//								PreparedStatement ps = conn.prepareStatement(sql);
//								
//								ps.setInt(1, ersReimb.getReimb_amount());
//								ps.setDate(2, java.sql.Date.valueOf(currentDate));
//								ps.setDate(3, java.sql.Date.valueOf(currentDate));
//								ps.setString(4, ersReimb.getReimb_description());
//								ps.setInt(5, ersReimb.getReimb_receipt());
//								ps.setObject(6, null);
//								ps.setObject(7, null);
//								ps.setInt(8, ersReimb.getReimb_status_id());
//								ps.setInt(9, ersReimb.getReimb_type_id());
//								
//								ps.executeUpdate();
//					
//							} catch (SQLException e) {
//								System.err.println("Sorry we can't add the product");
//								System.out.println();
//								e.printStackTrace();
//							}

	}
	@Override
	public List<ErsReimbursement> getAllErsReimbursement() {
		
		Session ses = HibernateUtil.getSession();
		
		List <ErsReimbursement> ersList = ses.createQuery("From ErsReimbursement").list();
		
		HibernateUtil.closeSession();
		return ersList;
		
//							try (Connection conn = ConnectionUtil.getConnection()){
//								
//								ResultSet rs = null;
//								
//								String sql = "select * from \"project\".ers_reimbursement";
//								Statement st = conn.createStatement();
//								
//								rs = st.executeQuery(sql);
//								
//								List<ErsReimbursement> ersReimbList = new ArrayList<>();
//								
//								while(rs.next()) {
//									ErsReimbursement ers = new ErsReimbursement(
//											rs.getInt("reimb_id"),
//											rs.getInt("reimb_amount"),
//											rs.getString("reimb_submitted"),
//											rs.getString("reimb_resolved"),
//											rs.getString("reimb_description"),
//											rs.getInt("reimb_receipt"),
//											null,
//											null,
//											rs.getInt("reimb_status_id"),
//											rs.getInt("reimb_type_id")					
//											);
//									if (rs.getString("reimb_author") != null || rs.getString("reimb_resolver") != null) {
//										ers.setReimb_author(ersUserDao.getUserById(rs.getInt("reimb_author")));
//										ers.setReimb_resolver(ersUserDao.getUserById(rs.getInt("reimb_resolver")));
//									}
//									
//									ersReimbList.add(ers);
//								}
//								
//								return ersReimbList;
//							
//								
//							} catch (SQLException e) {
//								System.err.println("Sorry we can't get list of ErsReimbursements");
//								e.printStackTrace();
//							}
//							return null;
	}

	

	@Override
	public ErsReimbursement getErsReimbursementById(int id) {
		
       Session ses = HibernateUtil.getSession();
		
       ErsReimbursement ersById = ses.get(ErsReimbursement.class, id);
		
		HibernateUtil.closeSession();
		return ersById;
		
		
			//		try(Connection conn = ConnectionUtil.getConnection()){
			//			ResultSet rs = null;
			//			
			//			String sql = "select * from ers_reimbursement where reimb_author = ?";
			//			
			//			PreparedStatement ps = conn.prepareStatement(sql);
			//			ps.setInt(1, id);
			//			
			//			rs = ps.executeQuery();
			//			
			//			List<ErsReimbursement> ersListById = new ArrayList<>();
			//			while(rs.next()) {
			//				ErsReimbursement ersById = new ErsReimbursement(
			//						rs.getInt("reimb_id"),
			//						rs.getInt("reimb_amount"),
			//						rs.getString("reimb_submitted"),
			//						rs.getString("reimb_resolved"),
			//						rs.getString("reimb_description"),
			//						rs.getInt("reimb_receipt"),
			//						null,
			//						null,
			//						rs.getInt("reimb_status_id"),
			//						rs.getInt("reimb_type_id")	
			//						);
			//	
			//			if (rs.getString("reimb_author") != null || rs.getString("reimb_resolver") != null) {
			//				ersById.setReimb_author(ersUserDao.getUserById(rs.getInt("reimb_author")));
			//				ersById.setReimb_resolver(ersUserDao.getUserById(rs.getInt("reimb_resolver")));
			//			}
			//			
			//			ersListById.add(ersById);
			//			}
			//			
			//			return ersListById;
			//			
			//		} catch (SQLException e) {
			//			System.err.println("Sorry we can't get the result");
			//			e.printStackTrace();
			//		}
			//		return null;
	}
	
	
	@Override
	public void updateErsReimbursementStatus(ErsReimbursement ersReimb) {
		
			Session ses = HibernateUtil.getSession();
			Transaction tran = ses.beginTransaction();
			
	        String HQL = "UPDATE ErsReimbursement SET reimb_status = '" + ersReimb.getReimb_status().getReimb_status_id() + 
	        		"' WHERE reimb_id = " + ersReimb.getReimb_id();
			
			//Instantiate a Query object with createQuery()
			Query q = ses.createQuery(HQL);
			
			//Send the update to the DB just like JDBC
			q.executeUpdate();
			
			
			//close transaction and session to prevent memory leak
			tran.commit();
			
			HibernateUtil.closeSession();
			
			
			
	
	}
	
	@Override
	public List<ErsReimbursement> getErsReimbursementByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}



}
