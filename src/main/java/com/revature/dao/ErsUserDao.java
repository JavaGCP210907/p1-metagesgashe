package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import com.revature.models.ErsUser;
import com.revature.utils.ConnectionUtil;
import com.revature.utils.HibernateUtil;

public class ErsUserDao implements ErsUserDaoInterface {

	@Override
	public List<ErsUser> getAllUsers(){
		
			Session ses = HibernateUtil.getSession();
			
			List<ErsUser> usersList = ses.createQuery("From Director").list();
			
			HibernateUtil.closeSession();
			
			return usersList;
		
	}
	
	
	//public ErsUser getUserById(int id) {
		
	
		
//					    try(Connection conn = ConnectionUtil.getConnection()){
//								
//								String sql = "SELECT * FROM ers_users where ers_user_id = ?";
//								
//								PreparedStatement ps = conn.prepareStatement(sql); //put our SQL string into a PreparedStatement
//								
//								ps.setInt(1, id); //fill in the parameter
//								
//								ResultSet rs = ps.executeQuery(); //execute our PrepStat into a ResultSet
//								
//								//we won't need a while loop, we're only expecting one result
//								if(rs.next()) {
//									
//									//Using the Home setters instead of the constructor. 
//									//Does the same thing, just wanna show you a different way
//									
//									ErsUser u = new ErsUser(); //empty home object
//									
//									//using setters to populate the empty Home object
//									u.setErs_user_name(rs.getString("ers_user_name"));
//									u.setErs_password(rs.getString("ers_password"));
//									u.setUser_first_name(rs.getString("user_first_name"));
//									u.setUser_last_name(rs.getString("user_last_name"));
//									u.setUser_email(rs.getString("user_email"));
//									u.setUser_role_id(rs.getInt("user_role_id"));
//									
//									return u; //return the home object
//									
//								}
//								
//								
//								
//							} catch (SQLException e) {
//								System.out.println("get home by name failed :*");
//								e.printStackTrace();
//							}
//							return null;

	//}

}
