/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DaoImp.StudentDAOImplementation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;

/**
 *
 * @author User
 */
@WebServlet("/welcome")
public class WelcomeController extends HttpServlet {

   int count;
   
   @Override
   public void init(){
   count = 0;
   }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        
       count ++;
        
         List<Student> listStudents = (List<Student>) request.getAttribute("listPers");
        
          response.setContentType("text/html;charset=UTF-8");
         
        try (PrintWriter out = response.getWriter()) {
          
      
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Welcome Servlet </title>");            
            out.println("</head>");
            out.println("<body>");
             out.println("<h1> " + count + "</h1>");
                      out.println("<h1> "   + "</h1>");
                      
            for(Student p:listStudents){
            out.println(  p.getStudentName() );
            }
            
            out.println(" <a href=\"index.html\">new   " );
             out.println(" <a href=\"deletePerson.html\">delete   " );
           //  out.println("<h1> Data Coming from Server  " + city + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws  IOException {
      
        
       

   

}}
