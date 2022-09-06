/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Dao.GradeDao;
import Model.Grade;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author maxim
 */
public class EditGrade2 extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
            try ( PrintWriter out = response.getWriter()) {
        
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet EditGrade2</title>");            
                out.println("</head>");
                out.println("<body>");

               String sid = request.getParameter("id");  
               String numGradeID = request.getParameter("gradeId");
               String numGrade = request.getParameter("grade");
                int id = Integer.parseInt(sid);  
                int gradeId = Integer.parseInt(numGradeID);  
                int grade = Integer.parseInt(numGrade);  
                
                Grade e=new Grade();  
                e.setId(id);  
                e.setGradeId(gradeId);  
                e.setGrade(grade);  
               
                int status=GradeDao.update(e);  
                if(status>0){  
                    response.sendRedirect("ViewGrades");  
                }else{  
                    out.println("Sorry! unable to update record");  
                    out.println(e.toString());
                }  



               out.close();
                    out.println("</body>");
                    out.println("</html>");
            }catch (Exception e){
                out.println(e.toString());
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
