package models.BO;

import models.Bean.Student;
import models.DAO.StudentDAO;
import utils.Validator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author tranphuquy19@gmail.com
 * @since 31/10/2019
 */
public class StudentBO {
    public static ArrayList<Student> getStudents() throws SQLException, ClassNotFoundException {
        ArrayList<Student> students = new ArrayList<>();
        ResultSet rs = StudentDAO.getStudents();
        return getStudents(students, rs);
    }

    public static ArrayList<Student> getStudentsByFacultyId(int facultyId) throws SQLException, ClassNotFoundException {
        ArrayList<Student> students = new ArrayList<>();
        ResultSet rs = StudentDAO.getStudentsByFacultyId(facultyId);
        return getStudents(students, rs);
    }

    private static ArrayList<Student> getStudents(ArrayList<Student> students, ResultSet rs) throws SQLException {
        while (rs.next()) {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setMale(rs.getBoolean("male"));
            student.setFaculty(rs.getString("faculty"));
            students.add(student);
        }
        return students;
    }

    public static Validator addStudent(int id, String name, boolean isMale, int facultyId) throws SQLException, ClassNotFoundException {
        Validator val = putCurrentValues(id, name, isMale, facultyId);
        Student student = getStudentById(id);
        if (student != null) {
            val.update("id", id, false, "ID đã tồn tại");
            return val;
        } else {
            if (StudentDAO.addStudentWithId(id, name, isMale, facultyId)) {
                //do somethings
            }
        }
        return val;
    }

    public static Validator updateStudent(int id, String name, boolean isMale, int facultyId){
        Validator val = putCurrentValues(id, name, isMale, facultyId);
        StudentDAO.updateStudentWithId(id, name, isMale, facultyId);
        return val;
    }

    public static Student getStudentById(int id) throws SQLException, ClassNotFoundException {
        Student student = null;
        ResultSet rs = StudentDAO.getStudentById(id);
        if (rs.next()) {
            student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setMale(rs.getBoolean("male"));
            student.setFaculty(rs.getString("faculty"));
        }
        return student;
    }

    private static Validator putCurrentValues(int id, String name, boolean isMale, int facultyId) {
        Validator val = new Validator();

        val.put("id", id, true, null);
        val.put("name", name, true, null);
        val.put("isMale", isMale, true, null);
        val.put("facultyId", facultyId, true, null);
        return val;
    }

    public static ArrayList<Student> findStudents(String key) {
        ArrayList<Student> students = new ArrayList<>();

        return students;
    }

    public boolean createStudent(Student student) {
        return true;
    }

    public boolean updateStudent(Student student) {
        return true;
    }

    public boolean deleteStudent(Student student) {
        return true;
    }
}
