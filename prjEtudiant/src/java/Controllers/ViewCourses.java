/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Dao.CourseDao;
import Model.Course;
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
public class ViewCourses extends HttpServlet {

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
        out.println("<a href='index.html'>Add New Course</a>");  
        out.println("<h1>Course List</h1>");  
          
        List<Course> list=CourseDao.getAllCourses();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>CourseId</th><th>CourseName</th><th>CourseDescription</th><th>Edit</th><th>Delete</th></tr>");  
        for(Course e:list){  
         out.print("<tr><td>"+e.getCourseId()+"</td><td>"+e.getCourseName()+"</td><td>"+e.getCourseDescription()+"</td>  "
                 + "</td><td><a href='EditCourse?id="+e.getCourseId()+"'>edit</a></td> <td><a href='DeleteCourse?id="+e.getCourseId()+"'>delete</a></td></tr>");  
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
          
        List<Course> list=CourseDao.getAllCourses();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>Description</th><th>Edit</th><th>Delete</th></tr>");  
        for(Course e:list){  
         out.print("<tr><td>"+e.getCourseId()+"</td><td>"+e.getCourseName()+"</td><td>"+e.getCourseDescription()+"</td>  <td>"
                 + "<a href='EditServlet?id="+e.getCourseId()+"'>edit</a></td> <td><a href='DeleteServlet?id="+e.getCourseId()+
                 "'>delete</a></td></tr>");  
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
