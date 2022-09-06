/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Connection.ConnectionFactory;
import Model.Course;
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
public class CourseDao {
 
    public static int save(Course c){  
        int status=0;  
        try{  
            Connection con = ConnectionFactory.getConnection();  
            PreparedStatement ps = con.prepareStatement("insert into cours (coursid, coursname, coursdesc) values (?,?,?)");  
            ps.setInt(1,c.getCourseId());  
            ps.setString(2,c.getCourseName());  
            ps.setString(3,c.getCourseDescription());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(SQLException ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Course c){  
        int status=0;  
        try{  
            Connection con=ConnectionFactory.getConnection();  
            PreparedStatement ps=con.prepareStatement("update cours set coursname=?,coursdesc=? where coursid=?");  
              
            ps.setString(1,c.getCourseName());  
            ps.setString(2,c.getCourseDescription());  
            ps.setInt(3,c.getCourseId());   
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(SQLException ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=ConnectionFactory.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from cours where coursid=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Course getCourseById(int id){  
        Course e=new Course();  
          
        try{  
            Connection con = ConnectionFactory.getConnection();  
            PreparedStatement ps = con.prepareStatement("select * from cours where coursid=?");  
            ps.setInt(1,id);  
            ResultSet rs = ps.executeQuery();  
            if(rs.next()){  
                e.setCourseId(rs.getInt(1));  
                e.setCourseName(rs.getString(2));  
                e.setCourseDescription(rs.getString(3));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Course> getAllCourses(){  
        List<Course> list=new ArrayList<Course>();  
          
        try{  
            Connection con = ConnectionFactory.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from cours");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Course e = new Course();  
                e.setCourseId(rs.getInt(1));  
                e.setCourseName(rs.getString(2));  
                e.setCourseDescription(rs.getString(3));  
                list.add(e);  
            }  
            con.close();  
        }catch(SQLException e){e.printStackTrace();}  
          
        return list;  
    }   
}
