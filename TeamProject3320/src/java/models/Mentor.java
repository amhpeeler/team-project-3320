/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Statement;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.OracleConnection;

/**
 *
 * @author annamariepeeler + visual paradigm
 */
public class Mentor extends CSUStaff {

	private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
	private String name;
        
        private static Connection conn = null;


	public void reviewStudRequest() {
		// TODO - implement Mentor.reviewStudRequest
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param students
	 */
	public void createTeam(Student[] students) {
		// TODO - implement Mentor.createTeam
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param projectId
         * @param deliverables
	 */
	public static boolean uploadDeliverables(int projectId, String deliverables) {
            boolean validated = false;
            try{
                conn = OracleConnection.getConnection();
                String sql = "UPDATE Project "
                    + "SET submitteddeliverables = ? "
                    + "WHERE projectid =?";
                    
                                        
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, deliverables);
                stmt.setInt(2, projectId);
                    
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

	public Project accessCurrentProjects() {
		// TODO - implement Mentor.accessCurrentProjects
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param student
	 * @param project
	 */
	public void issuesInvitation(Student student, Project project) {
		// TODO - implement Mentor.issuesInvitation
		throw new UnsupportedOperationException();
	}
        
        public static List<Mentor> getAllMentors(){
            List<Mentor> mentors = new ArrayList<Mentor>();
            try{
                conn = OracleConnection.getConnection();
                String sql = "SELECT * FROM Person WHERE type='staff'";
                //Wrap sql with statement
                Statement stmt = conn.createStatement();
                //run sql
                ResultSet rs = stmt.executeQuery(sql);
                //processed data in result set
                while(rs.next()){
                    Mentor m = new Mentor();
                    m.setUsername(rs.getString("id"));
                    m.setName(rs.getString("fname")+" "+rs.getString("lname"));
                    //add to list
                    mentors.add(m);
                }
            }catch(Exception e){
                e.printStackTrace();
            } finally{
                conn = null;
                OracleConnection.closeConnection();
            }
            return mentors;
        }
        
        
	public static boolean assignStudents(int projectID, String mentorID, String s1, String s2, String s3, String s4, String s5) {
		// TODO - implement CSUStaff.approveProject
		//throw new UnsupportedOperationException();
                boolean changed = false;
                
                try{
                    conn = OracleConnection.getConnection();
                    String sql = "INSERT INTO TEAM(projectID,mentorID, student1, Student2, Student3, Student4, Student5) "
                            + "Values(?,?,?,?,?,?,?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, projectID);
                    stmt.setString(2, mentorID);
                    stmt.setString(3, s1);
                    stmt.setString(4, s2);
                    stmt.setString(5, s3);
                    stmt.setString(6, s4);
                    stmt.setString(7, s5);
                    
                    int rset = stmt.executeUpdate();
                    if(rset == 1){
                        changed = true;
                    }
                }catch(Exception exp){
                    exp.printStackTrace();
                }finally{
                    conn = null;
                    OracleConnection.closeConnection();
                }
                return changed;
	}

}
