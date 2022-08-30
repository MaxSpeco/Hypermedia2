package DaoImp;


import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Student;
import interfaceDao.StudentDao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class StudentDAOImplementation implements StudentDao{
    
    Connection connection = ConnectionFactory.getConnection();

    // Constructor 
    public StudentDAOImplementation() {

    }

    
    // Create a new Person
    public void create(Student student) {

        PreparedStatement preparedStatement;

        try {
            String createQuery = "INSERT INTO ETUDIANTS(id, name, city, phoneNumber) VALUES(?,?,?,?)";
            preparedStatement = connection.prepareStatement(createQuery);
            
            preparedStatement.setInt(1, student.getStudentId());
            preparedStatement.setString(2, student.getStudentName());
            preparedStatement.setString(3, student.getStudentCity() );
            preparedStatement.setString(4, student.getStudentPhoneNumber() );
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Find by id
    @Override
    public Student findById(int id) {

        Student student = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            String selectIdQuery = "SELECT * FROM persons where id = ?";
            preparedStatement = connection.prepareStatement(selectIdQuery);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            resultSet.next();
            student = new Student();
            student.setStudentId(resultSet.getInt("id"));
            student.setStudentName(resultSet.getString("name"));
            student.setStudentCity(resultSet.getString("city"));
            student.setStudentPhoneNumber(resultSet.getString("phonenumber"));
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return student;
    }

    // find All people
    public List<Student> findAll() {

        List<Student> students = new ArrayList<>();
        Student student = null;
        ResultSet resultSet;
        PreparedStatement preparedStatement;

        try {
            String selectAllQuery = "SELECT * FROM ETUDIANTS ORDER BY ID";
            preparedStatement = connection.prepareStatement(selectAllQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                student = new Student();
                student.setStudentId(resultSet.getInt("id"));
                student.setStudentName(resultSet.getString("name"));
                student.setStudentCity(resultSet.getString("city"));
                student.setStudentPhoneNumber(resultSet.getString("phonenumber"));
                students.add(student);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return students;
    }

    // Update person's info
    public void update(Student student) {

        PreparedStatement preparedStatement;

        try {
            String updateQuery = "UPDATE ETUDIANTS SET NAME = ? SET CITY = ? SET PHONENUMBER = ? WHERE ID = ?";
            //System.out.println("Query = " + updateQuery);
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setString(2, student.getStudentCity());
            preparedStatement.setString(3, student.getStudentPhoneNumber());
            preparedStatement.setInt(4, student.getStudentId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Delete person
    public void delete(int id) {

        PreparedStatement preparedStatement;

        try {
            String deleteQuery = "DELETE FROM ETUDIANTS WHERE ID =" + id;
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
