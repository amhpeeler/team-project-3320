/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.*;
import utils.OracleConnection;

/**
 *
 * @author annamariepeeler + VP
 */
public class Project {

	private String title;
	private String type;
	private String sponsorCompany;
	private String[] contacts;
	private int academicYear;
	private String[] skillsRequested;
	private String[] disciplines;
	private int numOfStudents;
	private String[] deliverables;
	private int numOfTeams = 1;
        
        private Connection conn = null;  
        
        //might need to change "type" datatype as it is defined in DB as a char, setChar() is not a method in PreparedStatement
	public boolean createProject(String title, String type, String sponsor, String contacts, String skillsRequested, String disciplines, int numOfStudents, String description, String deliverables) {
		// TODO - implement Project.createProject
		//throw new UnsupportedOperationException();
                boolean created = false;
                try{
                    conn = OracleConnection.getConnection();
                    String sql = "INSERT INTO PROJECT(title, type, sponsor, contacts, skillsRequested, "
                            + "disciplines, numOfStudents, description, deliverablesToSubmit, submittedDeliverables, reviewedBy, mentor)"
                            + "Values(?, ?, ?, ?, ?, ?, ?, ?, ?, null, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, title);
                    stmt.setString(2, type);
                    stmt.setString(3, sponsor);//must be a sponsor already in the database
                    stmt.setString(4, contacts);
                    stmt.setString(5, skillsRequested);
                    stmt.setString(6, disciplines);
                    stmt.setInt(7, numOfStudents);
                    stmt.setString(8, description);
                    stmt.setString(9, deliverables);
                    stmt.setString(10, "null");
                    stmt.setString(11, "null");
                    int rset = stmt.executeUpdate();
                    if(rset == 1){
                        created = true;
                    }
                }catch(Exception exp){
                    exp.printStackTrace();
                }finally{
                    conn = null;
                    OracleConnection.closeConnection();
                }
                return created;
	}

	public String[] getContact() {
		// TODO - implement Project.getContact
		throw new UnsupportedOperationException();
	}

	public String getTitle() {
		return this.title;
	}
        
        public void setTitle(String t){
            this.title = t;
        }
        
	public void viewProjectDetails() {
		// TODO - implement Project.viewProjectDetails
		throw new UnsupportedOperationException();
	}
        
}
