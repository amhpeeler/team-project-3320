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
    private int id;
    private String title;
    private String mentor;
    private String student;
    private String request;
    private String response;
    
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
    
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    public static boolean makeResponse(int requestid, String response){
        boolean validated = false;
        try{
            conn = OracleConnection.getConnection();
            String sql = "UPDATE Request "
                    + "SET response = ? "
                    + "WHERE requestid =?";
                    
                                        
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, response);
            stmt.setInt(2, requestid);
                    
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
    
    public static List<Request> getAllStudentRequests(String studentID, int projectID) {
        List<Request> requests = new ArrayList<Request>();
        try{
            conn = OracleConnection.getConnection();
            String sql = "SELECT p.title, s.fname, s.lname, m.fname, m.lname, r.request, r.response " +
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
                req.setResponse(rs.getString(7));
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
    
    public static List<Request> getAllMentorRequests(String mentorID, int projectID) {
        List<Request> requests = new ArrayList<Request>();
        try{
            conn = OracleConnection.getConnection();
            String sql = "SELECT r.requestid, p.title, s.fname, s.lname, m.fname, m.lname, r.request, r.response " +
                        "FROM Request r " +
                        "INNER JOIN Person m on r.mentorid = m.id " +
                        "INNER JOIN Person s on r.studentid = s.id " +
                        "INNER JOIN Project p on r.projectid = p.projectid " +
                        "where r.mentorid = ? and r.projectid = ?";
            //Wrap sql with statement
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, mentorID);
            stmt.setInt(2, projectID);
            //run sql
            ResultSet rs = stmt.executeQuery();
            //processed data in result set
            while(rs.next()){
                Request req = new Request();
                req.setId(rs.getInt(1));
                req.setTitle(rs.getString(2));
                req.setStudent(rs.getString(3)+" "+rs.getString(4));
                req.setMentor(rs.getString(5)+" "+rs.getString(6));
                req.setRequest(rs.getString(7));
                req.setResponse(rs.getString(8));
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
    
    public static Request getRequest(int requestID) {
        Request req = new Request();
        try{
            conn = OracleConnection.getConnection();
            String sql = "SELECT r.requestid, p.title, s.fname, s.lname, m.fname, m.lname, r.request, r.response " +
                        "FROM Request r " +
                        "INNER JOIN Person m on r.mentorid = m.id " +
                        "INNER JOIN Person s on r.studentid = s.id " +
                        "INNER JOIN Project p on r.projectid = p.projectid " +
                        "where r.requestid = ?";
            //Wrap sql with statement
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, requestID);
            //run sql
            ResultSet rs = stmt.executeQuery();
            //processed data in result set
            while(rs.next()){
                req.setId(rs.getInt(1));
                req.setTitle(rs.getString(2));
                req.setStudent(rs.getString(3)+" "+rs.getString(4));
                req.setMentor(rs.getString(5)+" "+rs.getString(6));
                req.setRequest(rs.getString(7));
                req.setResponse(rs.getString("RESPONSE"));
                //add to list
            }
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            conn = null;
            OracleConnection.closeConnection();
        }
        return req;
    }
}
