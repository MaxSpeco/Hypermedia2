/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Dao.GradeDao;
import Model.Grade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author maxim
 */
public class SaveGrade extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        int gradeId = Integer.parseInt(request.getParameter("gradeId"));
        int grade = Integer.parseInt(request.getParameter("grade"));

        Grade s = new Grade();
        s.setId(id);
        s.setGradeId(gradeId);
        s.setGrade(grade);

        int status = GradeDao.save(s);

        if (status > 0) {
            out.print("<p>Record saved successfully!</p>");
            request.getRequestDispatcher("index.html").include(request, response);
        } else {
            out.println("Sorry! unable to save record");
        }
        out.close();
    }
}
