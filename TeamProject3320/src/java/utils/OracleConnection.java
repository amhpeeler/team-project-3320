package utils;

import java.security.Security;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author annamariepeeler
 */
public class OracleConnection {
    private static Connection connection = null;
    
    public static Connection getConnection() {
        try{
            connection = null;
            //Connect to the Oracle Cloud
            String url = "jdbc:oracle:thin:@QTB0OBN9PQ8AJAAR_high?"
                    +"TNS_ADMIN=/Users/annamariepeeler/NetBeansProjects/CSCI3320Proj2024/OracleCloud/Wallet_QTB0OBN9PQ8AJAAR";
            Properties props = new Properties();
            props.setProperty("user", "atinsley2");
            props.setProperty("password", "CSci3320$2024!");
            
            //single sign on
            props.setProperty("javax.net.ssl.trustStore", "/Users/annamariepeeler/NetBeansProjects/CSCI3320Proj2024/OracleCloud/Wallet_QTB0OBN9PQ8AJAAR/cwallet.sso");
            props.setProperty("javax.net.ssl.trustStoreType","SSO");
            props.setProperty("javax.net.ssl.keyStore", "/Users/annamariepeeler/NetBeansProjects/CSCI3320Proj2024/OracleCloud/Wallet_QTB0OBN9PQ8AJAAR/cwallet.sso");
            props.setProperty("javax.net.ssl.keyStoreType","SSO");
            props.setProperty("oracle.net.authentication_services","(TCPS)");
            
            //Load the Oracle Database Driver
            Security.addProvider(new oracle.security.pki.OraclePKIProvider());
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            connection = DriverManager.getConnection(url,props);
            if (connection != null) {
                System.out.println("You are connected to Oracle Cloud");
            } else {
                System.out.println("Failed to make connection!");
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return connection;
    }
    
    public static void closeConnection() {
        try{
            connection.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args){
        //test connection to Oracle Cloud
        try{
            /*steps to connect to Oracle
            1. get oracle connection handle
            2. build and run SQL statement
            3. parse the returned result
            */
            Connection conn = OracleConnection.getConnection();
            //build SQL
            String sql = "select sysdate from dual";
            //WRAP & Excecute
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = (stmt.executeQuery());
            //process the result of the query
            
            while(rs.next()){
                System.out.println("Current DB System Time: " + rs.getString(1));
                //columns start from 1 not 0
                
            }
            
            
            OracleConnection.getConnection();
        } catch(Exception e){
            e.printStackTrace();
        }finally{
            OracleConnection.closeConnection();
        }
    }
}
