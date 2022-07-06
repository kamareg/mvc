package org.example.controllers;

import org.example.entities.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/students")
public class StudentController {
    private List<Student> studentList;
    @GetMapping
    @RequestMapping(value = "/viewAllStudents", method = RequestMethod.GET)
    public ModelAndView viewAllStudents () {
        studentList = (studentList != null) ? studentList: getAllStudents();
        return new ModelAndView("viewAllStudents", "listOfStudents", studentList);
    }

    @GetMapping
    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public ModelAndView addStudent () {
        studentList = (studentList != null) ? studentList: getAllStudents();
        return new ModelAndView("viewAllStudents", "listOfStudents", studentList);
    }

    @GetMapping
    @RequestMapping(value = "/editStudent", method = RequestMethod.GET)
    public ModelAndView editStudent () {
        studentList = (studentList != null) ? studentList: getAllStudents();
        return new ModelAndView("viewAllStudents", "listOfStudents", studentList);
    }

    @GetMapping
    @RequestMapping(value = "/removeStudent/{id}", method = RequestMethod.GET)
    public ModelAndView removeStudent (@PathVariable int id) {
        studentList = (studentList != null) ? studentList: getAllStudents();
for (int i = 0; i < studentList.size() ; i++) {
    if (id == studentList.get(i).getId()) {
        studentList.remove(studentList.get(i));
    }
}        return new ModelAndView("redirect:/app/students/viewAllStudents");
    }
private List<Student> getAllStudents () {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Olga", 20, "In-81"));
    studentList.add(new Student(2, "Oleg", 21, "In-82"));
    studentList.add(new Student(3, "Ol", 22, "In-83"));
    studentList.add(new Student(4, "Olg", 23, "In-84"));

    return studentList;
}
}
