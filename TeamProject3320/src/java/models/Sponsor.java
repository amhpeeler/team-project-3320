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
 * @author annamariepeeler + VP
 */
public class Sponsor extends User {

	private String name;
	private String sponsorID;
	private String emailAddress;
	private String user;
	private String passwd;
        
        private Connection conn = null;


	/**
	 * 
	 * @param title
	 */
	public void submitProject(String title) {
		// TODO - implement Sponsor.submitProject
		throw new UnsupportedOperationException();
	}

	/**
	 * @param uname
         * @param company
         * @param title
         * @return validated 
         * */
	public boolean register(String uname, String company, String title) {
                //promo
		boolean validated = false;
                try{
                    conn = OracleConnection.getConnection();
                    String sql = "INSERT INTO Sponsor(SponsorID, company, title) VALUES(?,?,?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, uname);
                    stmt.setString(2, company);
                    stmt.setString(3, title);

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
