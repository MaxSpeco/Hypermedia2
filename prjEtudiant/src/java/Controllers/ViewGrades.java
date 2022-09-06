/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Dao.GradeDao;
import Model.Grade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List; 

/**
 *
 * @author maxim
 */
public class ViewGrades extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
     out.println("<a href=index.html>Add New Grade</a>");  
        out.println("<h1>Grade List</h1>");  
          
        List<Grade> list=GradeDao.getAllGrades();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Student Id</th><th>Grade Id</th><th>Grade</th><th>Edit</th><th>Delete</th></tr>");  
        for(Grade e:list){  
         out.print("<tr><td>"
                 +e.getId()+"</td><td>"
                 +e.getGradeId()+"</td><td>"
                 +e.getGrade()
                 +"</td><td><a href='EditGrade?id="
                 +e.getId()
                 +"'>edit</a></td> <td><a href='DeleteGrade?id="
                 +e.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();
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
        
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='index.html'>Add New Grade</a>");  
        out.println("<h1>Grades List</h1>");  
          
        List<Grade> list=GradeDao.getAllGrades();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>GradeId</th><th>Grade</th><th>Edit</th><th>Delete</th></tr>");  
        for(Grade e:list){  
         out.print("<tr><td>"
                 +e.getId()+"</td><td>"
                 +e.getGradeId()+"</td><td>"
                 +e.getGrade()
                 +"</td><td><a href='EditServlet?id="
                 +e.getId()+"'>edit</a></td> <td><a href='DeleteServlet?id="
                 +e.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close(); 
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
        processRequest(request, response);
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
