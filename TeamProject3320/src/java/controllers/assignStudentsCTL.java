/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import models.Mentor;
import models.Project;
import models.Student;


/**
 *
 * @author annamariepeeler
 */
@WebServlet(name = "assignStudentsCTL", urlPatterns = {"/assignStudentsCTL"})
public class assignStudentsCTL extends HttpServlet {

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
            out.println("<title>Servlet assignStudentsCTL</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet assignStudentsCTL at " + request.getContextPath() + "</h1>");
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
        String projectIdString = request.getParameter("projectId");
        int projectId = Integer.parseInt(projectIdString);
        HttpSession session = request.getSession();
        session.setAttribute("project", projectId);

        List<Student> students = Student.getAllStudents(projectId);
        System.out.println(students.get(0).getName());
        System.out.println(students.get(0).getStudentID());
        request.setAttribute("students", students);

        request.setAttribute("projectid", projectId);
        
        RequestDispatcher rd = request.getRequestDispatcher("assignStudents.jsp");
        rd.forward(request, response);
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
        int projectId = (Integer)session.getAttribute("project");
        String mentorID = (String) session.getAttribute("user");
        
        String s1 = request.getParameter("student1");
        String s2 = request.getParameter("student2");
        String s3 = request.getParameter("student3");
        String s4 = request.getParameter("student4");
        String s5 = request.getParameter("student5");

        // Use the selected student IDs as needed
        System.out.println("Selected Student 1: " + s1);
        System.out.println("Selected Student 2: " + s2);
        System.out.println("Selected Student 3: " + s3);
        System.out.println("Selected Student 4: " + s4);
        System.out.println("Selected Student 5: " + s5);

        if(Mentor.assignStudents(projectId, mentorID, s1, s2, s3, s4, s5)){
            response.sendRedirect("mentorViewCTL");
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
