package org.example.dao;

import org.example.entities.Student;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        OracleDAOImpl dao = new OracleDAOImpl();
        dao.connect();
        dao.getAllStudents().forEach(System.out::println);
      //  dao.insertStudent(new Student(0, "Tamara", 25, "IN-56"));
        dao.updateStudentByGroup(21, "PB-HGH");
        dao.removeStudent(7);
        System.out.println("After insert");
        dao.getAllStudents().forEach(System.out::println);
        dao.disconnect();
        
    }
}
