/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import models.Profile;


/**
 *
 * @author celso
 */
@WebServlet(name = "updateProfileCTL", urlPatterns = {"/updateProfileCTL"})
public class updateProfileCTL extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updateProfileCTL</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateProfileCTL at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        String field = request.getParameter("userFieldHidden");
        boolean result = false;
        Profile p = new Profile();
        if(field.equals("fname")){
            result = p.updateFname(user, request.getParameter("fname"));
            if(result){
                response.sendRedirect("displayProfileCTL");
            }
        }else if(field.equals("lname")){
            result = p.updateLname(user, request.getParameter("lname"));
            if(result){
                response.sendRedirect("displayProfileCTL");
            }
        }else if(field.equals("phone")){
            result = p.updatePhone(user, request.getParameter("phone"));
            if(result){
                response.sendRedirect("displayProfileCTL");
            }
        }else if(field.equals("email")){
            result = p.updateEmail(user, request.getParameter("email"));
            if(result){
                response.sendRedirect("displayProfileCTL");
            }
        }else if(field.equals("school")){
            result = p.updateSchool(user, request.getParameter("school"));
            if(result){
                response.sendRedirect("displayProfileCTL");
            }
        }else if(field.equals("year")){
            result = p.updateYear(user, request.getParameter("year"));
            if(result){
                response.sendRedirect("displayProfileCTL");
            }
        }else if(field.equals("major")){
            result = p.updateMajor(user, request.getParameter("major"));
            if(result){
                response.sendRedirect("displayProfileCTL");
            }
        }else if(field.equals("minor")){
            result = p.updateMinor(user, request.getParameter("minor"));
            if(result){
                response.sendRedirect("displayProfileCTL");
            }
        }else if(field.equals("skills")){
            result = p.updateSkills(user, request.getParameter("skills"));
            if(result){
                response.sendRedirect("displayProfileCTL");
            }
        }else if(field.equals("past")){
            result = p.updatePast(user, request.getParameter("past"));
            if(result){
                response.sendRedirect("displayProfileCTL");
            }
        }else{
            response.sendRedirect("test.html");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
