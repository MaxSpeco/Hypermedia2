
import DaoImp.StudentDAOImplementation;
import model.Student;
import interfaceDao.StudentDao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Propriétaire
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       StudentDao Dao = new StudentDAOImplementation();
       Student student1 = new Student();
       student1.setStudentId(123);
       student1.setStudentName("Martin");
       student1.setStudentCity("Chicago");
       student1.setStudentPhoneNumber("514-333-2222");
       Dao.create(student1);
    }
    
}
