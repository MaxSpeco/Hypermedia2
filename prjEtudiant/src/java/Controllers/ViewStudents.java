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
import java.util.List; 

/**
 *
 * @author glyder319
 */
public class ViewStudents extends HttpServlet {

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
        out.println("<a href='index.html'>Add New Student</a>");  
        out.println("<h1>Student List</h1>");  
          
        List<Student> list=StudentDao.getAllStudents();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>City</th><th>PhoneNumber</th><th>Edit</th><th>Delete</th></tr>");  
        for(Student e:list){  
         out.print("<tr><td>"+e.getStudentId()+"</td><td>"+e.getStudentName()+"</td><td>"+e.getStudentCity()+"</td>  <td>"+e.getStudentPhoneNumber()+"</td><td><a href='EditStudent?id="+e.getStudentId()+"'>edit</a></td> <td><a href='DeleteStudent?id="+e.getStudentId()+"'>delete</a></td></tr>");  
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
        out.println("<a href='index.html'>Add New Employee</a>");  
        out.println("<h1>Employees List</h1>");  
          
        List<Student> list=StudentDao.getAllStudents();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>City</th><th>PhoneNumber</th><th>Edit</th><th>Delete</th></tr>");  
        for(Student e:list){  
         out.print("<tr><td>"+e.getStudentId()+"</td><td>"+e.getStudentName()+"</td><td>"+e.getStudentCity()+"</td>  <td>"+e.getStudentPhoneNumber()+"</td><td><a href='EditServlet?id="+e.getStudentId()+"'>edit</a></td> <td><a href='DeleteServlet?id="+e.getStudentId()+"'>delete</a></td></tr>");  
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
