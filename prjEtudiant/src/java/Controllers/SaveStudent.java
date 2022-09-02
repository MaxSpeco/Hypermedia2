/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Dao.StudentDao;
import Model.Student;
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
public class SaveStudent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        int id = Integer.parseInt(request.getParameter("id"));  
        String name = request.getParameter("name");  
        String city = request.getParameter("city");  
        String phoneNumber = request.getParameter("phoneNumber");  
        
        Student s = new Student();  
        s.setStudentId(id);  
        s.setStudentName(name);
        s.setStudentCity(city);  
        s.setStudentPhoneNumber(phoneNumber);  
          
        int status=StudentDao.save(s); 

        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("index.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  



}
