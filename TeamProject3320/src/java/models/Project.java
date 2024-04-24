/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.OracleConnection;

/**
 *
 * @author annamariepeeler + VP
 */
public class Project {

        private String title;
	private String type;
	private String sponsorCompany;
	private String contacts;
	private String academicYear;
	private String skillsRequested;
	private String disciplines;
	private int numOfStudents;
	private String deliverables;
	private int numOfTeams = 1;
        
        private static Connection conn = null;
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
        
        public String getTitle() {
            return title;
        }
        private void setType(String type) {
            this.type = type;
        }

        private void setSponsorCompany(String sponsorCompany) {
            this.sponsorCompany = sponsorCompany;
        }

        private void setContacts(String contacts) {
            this.contacts = contacts;
        }

        private void setAcademicYear(String academicYear) {
            this.academicYear = academicYear;
        }

        private void setSkillsRequested(String skillsRequested) {
            this.skillsRequested = skillsRequested;
        }

        private void setDisciplines(String disciplines) {
            this.disciplines = disciplines;
        }

        private void setNumOfStudents(int numOfStudents) {
            this.numOfStudents = numOfStudents;
        }

        private void setDeliverables(String deliverables) {
            this.deliverables = deliverables;
        }

        private void setNumOfTeams(int numOfTeams) {
            this.numOfTeams = numOfTeams;
        }


        private void setProjectID(int projectID) {
            this.projectID = projectID;
        }

        
        private void setTitle(String t){
            this.title = t;
        }
        
	public void viewProjectDetails() {
		// TODO - implement Project.viewProjectDetails
		throw new UnsupportedOperationException();
	}
        
        public static List<Project> getNewProjects() {
            List<Project> projects = new ArrayList<Project>();
            try{
                conn = OracleConnection.getConnection();
                String sql = "SELECT * FROM Project where reviewedby is NULL";
                //Wrap sql with statement
                Statement stmt = conn.createStatement();
                //run sql
                ResultSet rs = stmt.executeQuery(sql);
                //processed data in result set
                while(rs.next()){
                    Project proj = new Project();
                    proj.setTitle(rs.getString(1));
                    proj.setType(rs.getString(2));
                    proj.setSponsorCompany(rs.getString(3));
                    proj.setContacts(rs.getString(4));
                    proj.setAcademicYear(rs.getString(5));
                    proj.setSkillsRequested(rs.getString(6));
                    proj.setDisciplines(rs.getString(7));
                    proj.setNumOfStudents((rs.getInt(8)));
                    proj.setDeliverables(rs.getString(9));
                    //add to list
                    projects.add(proj);
                }
            
            }catch(Exception e){
                e.printStackTrace();
            } finally{
                conn = null;
                OracleConnection.closeConnection();
            }
            return projects;
        }
        
        public static List<Project> getMentorProjects(String mentorID) {
            List<Project> projects = new ArrayList<Project>();
            try{
                conn = OracleConnection.getConnection();
                String sql = "SELECT * FROM Project where mentor=?";
                //Wrap sql with statement
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, mentorID);

                //run sql
                ResultSet rs = stmt.executeQuery();
                //processed data in result set
                while(rs.next()){
                    Project proj = new Project();
                    proj.setTitle(rs.getString(1));
                    proj.setType(rs.getString(2));
                    proj.setSponsorCompany(rs.getString(3));
                    proj.setContacts(rs.getString(4));
                    proj.setAcademicYear(rs.getString(5));
                    proj.setSkillsRequested(rs.getString(6));
                    proj.setDisciplines(rs.getString(7));
                    proj.setNumOfStudents((rs.getInt(8)));
                    proj.setDeliverables(rs.getString(9));
                    //add to list
                    projects.add(proj);
                }
            
            }catch(Exception e){
                e.printStackTrace();
            } finally{
                conn = null;
                OracleConnection.closeConnection();
            }
            return projects;
        }

}
