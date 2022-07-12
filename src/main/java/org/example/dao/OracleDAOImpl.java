package org.example.dao;

import org.example.entities.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleDAOImpl implements DAOAccess {
    private Connection connection;
    public static final String DRIVER = "oracle.jdbc.OracleDriver";
    public static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";

    @Override
    public void connect() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DB_URL, "system", "12345678");
            if (!connection.isClosed()) {
                System.out.println("Successfully connected!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertStudent(Student student) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO STUDENTS(STUDENT_ID, STUDENT_FIO, STUDENT_AGE, STUDENT_GROUP) VALUES (NULL, ?, ?, ?)")) {
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setString(3, student.getGroup());
            statement.execute();
            System.out.println("Insert student");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT  * FROM STUDENTS ORDER BY STUDENT_FIO");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                studentList.add(parseStudent(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    private Student parseStudent(ResultSet resultSet) {
        Student student = null;
        try {
            int id = resultSet.getInt("STUDENT_ID");
            String fio = resultSet.getString("STUDENT_FIO");
            int age = resultSet.getInt("STUDENT_AGE");
            String group = resultSet.getString("STUDENT_GROUP");
            student = new Student(id, fio, age, group);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public void updateStudentByGroup(int id, String group) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE STUDENTS SET STUDENT_GROUP = :1 WHERE STUDENT_ID =:2 ")) {
            statement.setString(1, group);
            statement.setInt(2, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeStudent(int id) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE STUDENTS WHERE STUDENT_ID = :1 ")) {
            statement.setInt(1, id);
            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
