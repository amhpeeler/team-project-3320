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
        private int projectID = 9000;//will need to substitute with the way we decide to handle IDs
        
        //might need to change "type" datatype as it is defined in DB as a char, setChar() is not a method in PreparedStatement
	public void createProject(String title, String type, String sponsor, String contacts, String skillsRequested, String disciplines, int numOfStudents, String description, String deliverables) {
		// TODO - implement Project.createProject
		//throw new UnsupportedOperationException();
                try{
                    conn = OracleConnection.getConnection();
                    String sql = "INSERT INTO PROJECT(projectID, title, type, sponsor, contacts, skillsRequested, "
                            + "disciplines, numOfStudents, description, deliverablesToSubmit, submittedDeliverables, reviewedBy)"
                            + "Values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, null, null)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, projectID);
                    stmt.setString(2, title);
                    stmt.setString(3, type);
                    stmt.setString(4, sponsor);
                    stmt.setObject(5, contacts);
                    stmt.setObject(6, skillsRequested);
                    stmt.setObject(7, disciplines);
                    stmt.setInt(8, numOfStudents);
                    stmt.setString(9, description);
                    stmt.setObject(10, deliverables);
                }catch(Exception exp){
                    exp.printStackTrace();
                }finally{
                    conn = null;
                    OracleConnection.closeConnection();
                    projectID += 1;//useless since we create a new instance of Project during a CTL
                }
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
