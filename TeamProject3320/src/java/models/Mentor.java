/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Statement;
import java.io.File;
import java.sql.Connection;
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
	 * @param title
         * @param files
	 */
	public void uploadDeliverables(String title, File files) {
		// TODO - implement Mentor.uploadDeliverables
		throw new UnsupportedOperationException();
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

}
