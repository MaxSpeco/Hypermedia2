package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String un = request.getParameter("username");
        String pw = request.getParameter("password");

        if (un.equals("admin") && pw.equals("admin")) {
            response.sendRedirect("student.html");
            return;
        } else {
           // ?message is a parameter that we send to loging.jsp
           
            response.sendRedirect("login.jsp?message=crendentials incorrect, please try again");
            return;
        }
    }

}