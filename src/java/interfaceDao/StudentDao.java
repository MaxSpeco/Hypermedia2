package interfaceDao;


import java.util.List;
import model.Student;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public interface StudentDao {
    



    void create(Student p);
    
    void update(Student p);
    
    void delete(int id);

    List<Student> findAll();

    Student findById(int id);
}
