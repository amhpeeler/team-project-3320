/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.io.Serializable;
import utils.OracleConnection;
import java.sql.*;
/**
 *
 * @author annamarietinsley + Visual Paradigm
 */
public class User implements Serializable{

	private String username;
	private String passwd;
	private String emailAddress;
        private char type;
        
        private Connection conn = null;
	/**
	 * 
	 * @param user
	 * @param passwd
         * @return validated
	 */
	public boolean login(String user, String passwd) {
		// TODO - implement User.login
		//throw new UnsupportedOperationException();
                boolean validated = false;
                try{
                    conn = OracleConnection.getConnection();
                    String sql = "SELECT * FROM Person WHERE ID=? AND password=?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, user);
                    stmt.setString(2, passwd);
                    ResultSet rs = stmt.executeQuery();
                    if(rs.next()){
                        validated = true;
                    }
                }catch(Exception exp){
                    exp.printStackTrace();
                }finally{
                    conn = null;
                    OracleConnection.closeConnection();
                }
                return validated;
	}

		/**
	 * @param fname
         * @param lname
	 * @param uname
	 * @param passwd
         * @param company
         * @param phone
         * @param email
         * @param type
         * @return validated 
         * */
	public boolean register(String fname, String lname, String uname,
                String passwd, String company, String phone, String email, String type) {
                //promo
		boolean validated = false;
                try{
                    conn = OracleConnection.getConnection();
                    String sql = "INSERT INTO Person(ID, password, type, fname, lname, phoneNumber, "
                            + "emailAddress) VALUES(?,?,?,?,?,?,?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, uname);
                    stmt.setString(2, passwd);
                    stmt.setString(3, type);
                    stmt.setString(4, fname);
                    stmt.setString(5, lname);
                    stmt.setString(6, phone);
                    stmt.setString(7, email);
                    ResultSet rs = stmt.executeQuery();
                    //check if data inserted
                    
                    if (type.equals("X")){
                        Sponsor s = new Sponsor();
                        s.register(uname, company, type);
                    } //add others
                }catch(Exception exp){
                    exp.printStackTrace();
                }finally{
                    conn = null;
                    OracleConnection.closeConnection();
                }
                return validated;
	}

}
