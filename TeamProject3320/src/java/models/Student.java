/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import utils.OracleConnection;

/**
 *
 * @author annamariepeeler + VP
 * 
 */
public class Student extends User {

	private String fname;
	private String lname;
	private String studentID;
	private String phoneNumber;
        
        
        
        private Connection conn = null;


	/**
	 * 
	 * @param studentID
         * @param projectID
         * @param comment
	 */
	public void applyForProject(String studentID, String projectID, String comment) {
            PreparedStatement stmt = null;
            try {
                conn = OracleConnection.getConnection();
                String sql = "INSERT INTO Application (studentID, projectID, comments) VALUES (?, ?, ?)";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, studentID);
                stmt.setString(2, projectID);
                stmt.setString(3, comment);
                stmt.executeUpdate();
            }catch(Exception exp){
                    exp.printStackTrace();
                }finally{
                    conn = null;
                    OracleConnection.closeConnection();
                }           
}

	public void viewContsnt() {
		// TODO - implement Student.viewContsnt
		throw new UnsupportedOperationException();
	}

	public Project accessCurrentProjects() {
		// TODO - implement Student.accessCurrentProjects
		throw new UnsupportedOperationException();
	}

	public void discussIssues() {
		// TODO - implement Student.discussIssues
		throw new UnsupportedOperationException();
	}

	public void acceptInvitation() {
		// TODO - implement Student.acceptInvitation
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param hours
	 */
	public void logHours(int hours) {
		// TODO - implement Student.logHours
		throw new UnsupportedOperationException();
	}

	public void filterContent() {
		// TODO - implement Student.filterContent
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param project
	 */
	public void navigateToProject(Project project) {
		// TODO - implement Student.navigateToProject
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param request
	 */
	public void submitRequest(String request) {
		// TODO - implement Student.submitRequest
		throw new UnsupportedOperationException();
	}
        
         /**
	 * @param username
         * @param skills
         * @param year
         * @param major
         * @param minor
         * @param school
         * @param past
         * @return validated 
         * */
	public boolean register(String username, String skills, String year, String major, String minor, String school, String past) {
                //promo
		boolean validated = false;
                try{
                    conn = OracleConnection.getConnection();
                    String sql = "INSERT INTO Student(StudentID, skills, academicYear, major, minor, past, school) VALUES(?,?,?,?,?,?,?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, username);
                    stmt.setString(2, skills);
                    stmt.setString(3, year);
                    stmt.setString(4, major);
                    stmt.setString(5, minor);
                    stmt.setString(6, school);
                    stmt.setString(7, past);
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
