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
import java.io.IOException;
import java.io.PrintWriter;
import models.CSUStaff;
import models.Sponsor;
import models.Student;
import models.User;

/**
 *
 * @author annamariepeeler
 */
@WebServlet(name = "registerCTL", urlPatterns = {"/registerCTL"})
public class registerCTL extends HttpServlet {

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
            out.println("<title>Servlet registerCTL</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registerCTL at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        

        
        String username, password, type, fname, lname, phone, email;
        type = request.getParameter("userTypeHidden");
        System.out.println("doPost");
        if(type.equals("sponsor")){
            System.out.println("Sponsor");
            username = request.getParameter("sponsorUName");
            System.out.println(username);
            password = request.getParameter("sponsorPassword");
            System.out.println(password);
            fname = request.getParameter("sponsorFName");
            System.out.println(fname);
            lname = request.getParameter("sponsorLName");
            System.out.println(lname);
            phone = request.getParameter("sponsorPhone");
            System.out.println(phone);
            email = request.getParameter("sponsorEmail");
            System.out.println(email);
            User user = new User();
            boolean validate = user.register(fname, lname, username, password, phone, email, type);
            System.out.println(validate);
            if (validate){
                String company = request.getParameter("sponsorCompany");
                String title = request.getParameter("sponsorTitle");
                Sponsor s = new Sponsor();
                boolean val = s.register(username, company, title);
                if(val) {
                    response.sendRedirect("login.jsp");
                }
            }else{
                response.sendRedirect("index.html");
            }
             
        } else if (type.equals("staff")) {
            username = request.getParameter("staffUName");
            password = request.getParameter("staffPassword");
            fname = request.getParameter("staffFName");
            lname = request.getParameter("staffLName");
            phone = request.getParameter("staffPhone");
            email = request.getParameter("staffEmail");
            User user = new User();
            boolean validate = user.register(fname, lname, username, password, phone, email, type);
            if (validate){
                String department = request.getParameter("staffDepartment");
                CSUStaff s = new CSUStaff();
                boolean val = s.register(username, department);
                if(val) {
                    response.sendRedirect("login.jsp");
                }
            }else{
                response.sendRedirect("index.html");
            }
        } else if(type.equals("student")){
            username = request.getParameter("studentUName");
            password = request.getParameter("studentPassword");
            fname = request.getParameter("studentFName");
            lname = request.getParameter("studentLName");
            phone = request.getParameter("studentPhone");
            email = request.getParameter("studentEmail");
            User user = new User();
            boolean validate = user.register(fname, lname, username, password, phone, email, type);
            if (validate){
                String skills = request.getParameter("studentSkills");
                String year = request.getParameter("studentYear");
                String major = request.getParameter("studentMajor");
                String minor = request.getParameter("studentMinor");
                String school = request.getParameter("studentSchool");
                String past = request.getParameter("studentPast");
                Student s = new Student();
                boolean val = s.register(username, skills, year, major, minor, school, past);
                if(val) {
                    response.sendRedirect("login.jsp");
                }
            }else{
                response.sendRedirect("index.html");
            }
        }else { //none type
            
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
