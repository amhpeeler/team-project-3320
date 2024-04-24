/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.OracleConnection;

/**
 *
 * @author annamariepeeler
 */
public class Request {
    private String title;
    private String mentor;
    private String student;
    private String request;
    private static Connection conn = null;
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
    

    
    public static boolean makeRequest(String studentid, String mentorid, int projectid, String request){
        boolean validated = false;
        try{
            conn = OracleConnection.getConnection();
            String sql = "INSERT INTO Request(studentid, mentorid, projectid, request) "
                            + "VALUES(?,?,?,?)";
                    
                                        
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, studentid);
            stmt.setString(2, mentorid);
            stmt.setInt(3, projectid);
            stmt.setString(4, request);
                    
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
    
    public static List<Request> getAllRequests(String studentID, int projectID) {
        List<Request> requests = new ArrayList<Request>();
        try{
            conn = OracleConnection.getConnection();
            String sql = "SELECT p.title, s.fname, s.lname, m.fname, m.lname, r.request " +
                        "FROM Request r " +
                        "INNER JOIN Person m on r.mentorid = m.id " +
                        "INNER JOIN Person s on r.studentid = s.id " +
                        "INNER JOIN Project p on r.projectid = p.projectid " +
                        "where r.studentid = ? and r.projectid = ?";
            //Wrap sql with statement
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, studentID);
            stmt.setInt(2, projectID);
            //run sql
            ResultSet rs = stmt.executeQuery();
            //processed data in result set
            while(rs.next()){
                Request req = new Request();
                req.setTitle(rs.getString(1));
                req.setStudent(rs.getString(2)+" "+rs.getString(3));
                req.setMentor(rs.getString(4)+" "+rs.getString(5));
                req.setRequest(rs.getString(6));
                //add to list
                requests.add(req);
            }
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            conn = null;
            OracleConnection.closeConnection();
        }
        return requests;
    }
}
