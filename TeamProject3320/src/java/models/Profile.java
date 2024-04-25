/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;


import java.sql.PreparedStatement;
import utils.OracleConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author annamariepeeler + VP
 */
public class Profile {

	private String fname;
	private String lname;
	private String phoneNumber;
	private String emailAddress;
	private String skills;
	private String pastExperiences;
        private String year;
        private String major;
        private String minor;
        private String school;
        
        private static Connection conn = null;
        
	public boolean updateFname(String user, String fname) {
	
		boolean updated = false;
                try{
                    conn = OracleConnection.getConnection();
                    String sql = "UPDATE PERSON SET fname=? WHERE id=?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, fname);
                    stmt.setString(2, user);
                    int rset = stmt.executeUpdate();
                    //check if data inserted
                    if (rset == 1){
                        //data inserted
                        updated = true;
                    }
                }catch(Exception exp){
                    exp.printStackTrace();
                }finally{
                    conn = null;
                    OracleConnection.closeConnection();
                }
                return updated;
        
	}
        
        public boolean updateLname(String user, String lname) {
		boolean updated = false;
                try{
                    conn = OracleConnection.getConnection();
                    String sql = "UPDATE PERSON SET lname=? WHERE id=?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, lname);
                    stmt.setString(2, user);
                    int rset = stmt.executeUpdate();
                    //check if data inserted
                    if (rset == 1){
                        //data inserted
                        updated = true;
                    }
                }catch(Exception exp){
                    exp.printStackTrace();
                }finally{
                    conn = null;
                    OracleConnection.closeConnection();
                }
                return updated;
	}
        
        public boolean updatePhone(String user, String phone) {
		boolean updated = false;
                try{
                    conn = OracleConnection.getConnection();
                    String sql = "UPDATE PERSON SET phonenumber=? WHERE id=?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, phone);
                    stmt.setString(2, user);
                    int rset = stmt.executeUpdate();
                    //check if data inserted
                    if (rset == 1){
                        //data inserted
                        updated = true;
                    }
                }catch(Exception exp){
                    exp.printStackTrace();
                }finally{
                    conn = null;
                    OracleConnection.closeConnection();
                }
                return updated;
	}
        
        public boolean updateEmail(String user, String email) {
		boolean updated = false;
                try{
                    conn = OracleConnection.getConnection();
                    String sql = "UPDATE PERSON SET emailaddress=? WHERE id=?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, email);
                    stmt.setString(2, user);
                    int rset = stmt.executeUpdate();
                    //check if data inserted
                    if (rset == 1){
                        //data inserted
                        updated = true;
                    }
                }catch(Exception exp){
                    exp.printStackTrace();
                }finally{
                    conn = null;
                    OracleConnection.closeConnection();
                }
                return updated;
	}
        
        public boolean updateSchool(String user, String school) {
		boolean updated = false;
                try{
                    conn = OracleConnection.getConnection();
                    String sql = "UPDATE Student SET school=? WHERE studentid=?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, school);
                    stmt.setString(2, user);
                    int rset = stmt.executeUpdate();
                    //check if data inserted
                    if (rset == 1){
                        //data inserted
                        updated = true;
                    }
                }catch(Exception exp){
                    exp.printStackTrace();
                }finally{
                    conn = null;
                    OracleConnection.closeConnection();
                }
                return updated;
	}
        
        public boolean updateYear(String user, String year) {
		boolean updated = false;
                try{
                    conn = OracleConnection.getConnection();
                    String sql = "UPDATE Student SET academicyear=? WHERE studentid=?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, year);
                    stmt.setString(2, user);
                    int rset = stmt.executeUpdate();
                    //check if data inserted
                    if (rset == 1){
                        //data inserted
                        updated = true;
                    }
                }catch(Exception exp){
                    exp.printStackTrace();
                }finally{
                    conn = null;
                    OracleConnection.closeConnection();
                }
                return updated;
	}
        
        public boolean updateMajor(String user, String major) {
		boolean updated = false;
                try{
                    conn = OracleConnection.getConnection();
                    String sql = "UPDATE Student SET major=? WHERE studentid=?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, major);
                    stmt.setString(2, user);
                    int rset = stmt.executeUpdate();
                    //check if data inserted
                    if (rset == 1){
                        //data inserted
                        updated = true;
                    }
                }catch(Exception exp){
                    exp.printStackTrace();
                }finally{
                    conn = null;
                    OracleConnection.closeConnection();
                }
                return updated;
	}
        
        public boolean updateMinor(String user, String minor) {
		boolean updated = false;
                try{
                    conn = OracleConnection.getConnection();
                    String sql = "UPDATE Student SET minor=? WHERE studentid=?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, minor);
                    stmt.setString(2, user);
                    int rset = stmt.executeUpdate();
                    //check if data inserted
                    if (rset == 1){
                        //data inserted
                        updated = true;
                    }
                }catch(Exception exp){
                    exp.printStackTrace();
                }finally{
                    conn = null;
                    OracleConnection.closeConnection();
                }
                return updated;
	}
        
        public boolean updateSkills(String user, String skills) {
		boolean updated = false;
                try{
                    conn = OracleConnection.getConnection();
                    String sql = "UPDATE Student SET skills=? WHERE studentid=?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, skills);
                    stmt.setString(2, user);
                    int rset = stmt.executeUpdate();
                    //check if data inserted
                    if (rset == 1){
                        //data inserted
                        updated = true;
                    }
                }catch(Exception exp){
                    exp.printStackTrace();
                }finally{
                    conn = null;
                    OracleConnection.closeConnection();
                }
                return updated;
	}
        
        public boolean updatePast(String user, String past) {
		boolean updated = false;
                try{
                    conn = OracleConnection.getConnection();
                    String sql = "UPDATE Student SET past=? WHERE studentid=?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, past);
                    stmt.setString(2, user);
                    int rset = stmt.executeUpdate();
                    //check if data inserted
                    if (rset == 1){
                        //data inserted
                        updated = true;
                    }
                }catch(Exception exp){
                    exp.printStackTrace();
                }finally{
                    conn = null;
                    OracleConnection.closeConnection();
                }
                return updated;
	}

	public List<Profile> displayProfile(String user) {
		List<Profile> profileAttrib = new ArrayList<Profile>();
            try {
                conn = OracleConnection.getConnection();
                String sql = "SELECT p.fname, p.lname, p.emailaddress, p.phonenumber, s.skills, s.academicyear, "
                        + "s.major, s.minor, s.past, s.school FROM Person p JOIN Student s ON p.id = s.studentid"
                        + " WHERE p.id=?";
                
                //Wrap sql with statement
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, user);
                //run sql
                ResultSet rs = stmt.executeQuery();
                //processed data in result set
                while(rs.next()){
                    Profile p = new Profile();
                    p.setFname(rs.getString(1));
                    p.setLname(rs.getString(2));
                    p.setEmail(rs.getString(3));
                    p.setPhone(rs.getString(4));
                    p.setSkills(rs.getString(5));
                    p.setYear(rs.getString(6));
                    p.setMajor(rs.getString(7));
                    p.setMinor(rs.getString(8));
                    p.setPast(rs.getString(9));
                    p.setSchool(rs.getString(10));
                    //add to list
                    profileAttrib.add(p);
                }
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                conn = null;
                OracleConnection.closeConnection();

            }
          return profileAttrib;
	}

        public void setFname(String f){
            this.fname = f;
        }
        
        public void setLname(String l){
            this.lname = l;
        }
        
        public void setSkills(String s){
            this.skills = s;
        }
        
        public void setEmail(String e){
            this.emailAddress = e;
        }
        
        public void setPhone(String p){
            this.phoneNumber = p;
        }
        
        public void setPast(String p){
            this.pastExperiences = p;
        }
        
        public void setYear(String y){
            this.year = y;
        }
        
        public void setMajor(String m){
            this.major = m;
        }
        
        public void setMinor(String m){
            this.minor = m;
        }
        
        public void setSchool(String s){
            this.school = s;
        }
        
        public String getFname(){
            return this.fname;
        }
        
        public String getLname(){
            return this.lname;
        }
        
        public String getPhone(){
            return this.phoneNumber;
        }
        
        public String getEmail(){
            return this.emailAddress;
        }
        
        public String getYear(){
            return this.year;
        }
        
        public String getMajor(){
            return this.major;
        }
        
        public String getMinor(){
            return this.minor;
        }
        
        public String getSkills(){
            return this.skills;
        }
        
        public String getPast(){
            return this.pastExperiences;
        }
        
        public String getSchool(){
            return this.school;
        }
}
