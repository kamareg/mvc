package org.example.dao;

import org.example.entities.Student;

import java.util.List;

public interface DAOAccess {
    void connect();
    void disconnect();
    void insertStudent(Student student); //create
    List<Student> getAllStudents(); //read
    void updateStudentByGroup(int id, String group); //update
    void removeStudent(int id); //delete
}
