/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Dao.StudentDao;
import Model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author glyder319
 */
public class EditStudent extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditStudent</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Update Student</h1>");  
           String sid=request.getParameter("id");  
           int id=Integer.parseInt(sid);  

           Student e=StudentDao.getStudentById(id);  

           out.print("<form action='EditStudent2' method='post'>");  
           out.print("<table>");  
           out.print("<tr><td>Student ID: </td><td><input type='text' name='id' value='"+e.getStudentId()+"'/></td></tr>");  
           out.print("<tr><td>Name: </td><td><input type='text' name='Name' value='"+e.getStudentName()+"'/></td></tr>");  
           out.print("<tr><td>City: </td><td><input type='text' name='City' value='"+e.getStudentCity()+"'/>  </td></tr>");  
           out.print("<tr><td>Phone Number:</td><td><input type='text' name='Phone Number' value='"+e.getStudentPhoneNumber()+"'/></td></tr>");    
           out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
           out.print("</table>");  
           out.print("</form>");  

           //out.close();  
      
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
