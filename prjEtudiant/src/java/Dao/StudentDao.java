/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Connection.ConnectionFactory;
import Model.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author glyder319
 */
public class StudentDao {
    
 
    public static int save(Student s){  
        int status=0;  
        try{  
            Connection con = ConnectionFactory.getConnection();  
            PreparedStatement ps = con.prepareStatement("insert into etudiants(id,name,city,phoneNumber) values (?,?,?,?)");  
            ps.setInt(1,s.getStudentId());  
            ps.setString(2,s.getStudentName());  
            ps.setString(3,s.getStudentCity());  
            ps.setString(4,s.getStudentPhoneNumber());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(SQLException ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Student s){  
        int status=0;  
        try{  
            Connection con=ConnectionFactory.getConnection();  
            PreparedStatement ps=con.prepareStatement("update etudiants set name=?,city=?,phoneNumber=? where id=?");  
              
            ps.setString(1,s.getStudentName());  
            ps.setString(2,s.getStudentCity());  
            ps.setString(3,s.getStudentPhoneNumber()); 
            ps.setInt(4,s.getStudentId());   
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(SQLException ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=ConnectionFactory.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from etudiants where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Student getStudentById(int id){  
        Student e=new Student();  
          
        try{  
            Connection con = ConnectionFactory.getConnection();  
            PreparedStatement ps = con.prepareStatement("select * from etudiants where id=?");  
            ps.setInt(1,id);  
            ResultSet rs = ps.executeQuery();  
            if(rs.next()){  
                e.setStudentId(rs.getInt(1));  
                e.setStudentName(rs.getString(2));  
                e.setStudentCity(rs.getString(3));  
                e.setStudentPhoneNumber(rs.getString(4));  

            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Student> getAllStudents(){  
        List<Student> list=new ArrayList<Student>();  
          
        try{  
            Connection con = ConnectionFactory.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from etudiants");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Student e = new Student();  
                e.setStudentId(rs.getInt(1));  
                e.setStudentName(rs.getString(2));  
                e.setStudentCity(rs.getString(3));  
                e.setStudentPhoneNumber(rs.getString(4));  
                list.add(e);  
            }  
            con.close();  
        }catch(SQLException e){e.printStackTrace();}  
          
        return list;  
    }  
    
}
