/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.OracleConnection;

/**
 *
 * @author annamariepeeler + visual paradigm
 */
public class CSUStaff extends User {

	private String fname;
	private String lname;

        private Connection conn = null;

	/**
	 * 
	 * @param title
         * @return approved
	 */
	public boolean approveProject(String title) {
		// TODO - implement CSUStaff.approveProject
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 * @param team
	 */
	public void assignMentor(String email, Team team) {
		// TODO - implement CSUStaff.assignMentor
		throw new UnsupportedOperationException();
	}
        
        /**
	 * @param uname
         * @param department
         * @return validated 
         * */
	public boolean register(String uname, String department) {
                //promo
		boolean validated = false;
                try{
                    conn = OracleConnection.getConnection();
                    String sql = "INSERT INTO CSUStaff(StaffID, department) VALUES(?,?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, uname);
                    stmt.setString(2, department);
                    int rset = stmt.executeUpdate();
                    //check if data inserted
                    if (rset == 1){
                        //data inserted
                        validated = true;
                    } else {
                        validated = false;
                    }
                    
                }catch(Exception exp){
                    exp.printStackTrace();
                }finally{
                    conn = null;
                    OracleConnection.closeConnection();
                }
                return validated;
	}

}
