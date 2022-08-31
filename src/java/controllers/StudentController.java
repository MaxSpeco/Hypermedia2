/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DaoImp.StudentDAOImplementation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Student;

/**
 *
 * @author User
 */
@WebServlet("/student")
public class StudentController extends HttpServlet {

    StudentDAOImplementation dao;

    @Override
    public void init() {
        dao = new StudentDAOImplementation();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("x"));
        String action = request.getParameter("act");
     //   PersonDAOImplementation dao = new PersonDAOImplementation();
        if(action.equals("delete")){
            dao.delete(id);
        }
        else if(action.equals("update")){
            Student s = dao.findById(id);
            request.setAttribute("student", s);
            getServletContext().getRequestDispatcher("/studentUpdate.jsp").forward(request, response);
            
            
        }
        

        List<Student> listStudents = dao.findAll();

        //String city = "Montreal";

        request.setAttribute("x", listStudents);  // x is attiribute that holds the list of persons from DAO

        getServletContext().getRequestDispatcher("/studentList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("id1"));
        String name = request.getParameter("name1");
        String city = request.getParameter("city");
        String phoneNumber = request.getParameter("phoneNumber");

      //  PersonDAOImplementation dao = new PersonDAOImplementation();
        Student student = new Student();

        student.setStudentId(id);
        student.setStudentName(name);
        student.setStudentCity(city);
        student.setStudentPhoneNumber(phoneNumber);
        dao.create(student);

        List<Student> listStudents = dao.findAll();

        //String city = "Montreal";
        
        HttpSession session = request.getSession();
        
        String sessionId = session.getId();
        
        request.setAttribute("sessionId", sessionId);
        
        
        System.out.println("Session id" + session.getId());
       // request.setAttribute("sessionId", session);
        request.setAttribute("x", listStudents);  // x is attiribute that holds the list of persons from DAO
        
        request.setAttribute("student1", student);
        //request.setAttribute("city", city);
        
        session.setAttribute("y", listStudents);
        /*
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/welcome");
        dispatcher.forward(request, response); */
//      getServletContext().getRequestDispatcher("/welcome.jsp").forward(request,response);
        // getServletContext().getRequestDispatcher("/person.jsp").forward(request, response);
        getServletContext().getRequestDispatcher("/studentList.jsp").forward(request, response);

    }

}
