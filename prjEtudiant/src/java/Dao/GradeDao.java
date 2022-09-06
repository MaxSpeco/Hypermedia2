/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Connection.ConnectionFactory;
import Model.Grade;
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
 * @author admin
 */
public class GradeDao {

    public static int save(Grade s) {
        int status = 0;
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into notes(id,coursId ,note) values (?,?,?)");
            ps.setInt(1, s.getId());
            ps.setInt(2, s.getGradeId());
            ps.setInt(3, s.getGrade());

            status = ps.executeUpdate();

            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int update(Grade s) {
        int status = 0;
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement("update notes set note=? where id=? AND coursid=?");

            ps.setInt(1,s.getGrade());
            ps.setInt(2,s.getId());
            ps.setInt(3,s.getGradeId());


            status = ps.executeUpdate();

            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from notes where id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static Grade getGradeById(int id) {
        Grade e = new Grade();

        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from notes where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setId(rs.getInt(1));
                e.setGradeId(rs.getInt(2));
                e.setGrade(rs.getInt(3));

            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }

    public static List<Grade> getAllGrades() {
        List<Grade> list = new ArrayList<Grade>();

        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from notes");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Grade e = new Grade();
                e.setId(rs.getInt(1));
                e.setGradeId(rs.getInt(2));
                e.setGrade(rs.getInt(3));

                list.add(e);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

}
