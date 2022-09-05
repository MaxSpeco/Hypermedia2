/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Dao.CourseDao;
import Model.Course;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author glyder319
 */
public class SaveCourse extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        int id = Integer.parseInt(request.getParameter("id"));  
        String name = request.getParameter("name");  
        String description = request.getParameter("description");   
        
        Course c = new Course();  
        c.setCourseId(id);  
        c.setCourseName(name);
        c.setCourseDescription(description);  
                   
        int status=CourseDao.save(c); 

        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("index.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
}
