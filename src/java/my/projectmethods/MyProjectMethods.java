/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.projectmethods;

import DaoImp.StudentDAOImplementation;
import java.util.List;
import java.util.Scanner;
import model.Student;
import interfaceDao.StudentDao;

/**
 *
 * @author User
 */
public class MyProjectMethods {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    
        StudentDao dao = new StudentDAOImplementation();
          List<Student> listStudents = dao.findAll();
   for ( Student p:listStudents)
   {
       System.out.println("name"  +p.getStudentName());
   }
}}

 