package com.student.controller;

import com.student.data.StudentRepository;
import com.student.pojo.Student;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Scope(value = "session")
@Component(value = "studentList")
@ELBeanName(value = "studentList")
@Join(path="/", to="student-list.jsf")
public class StudentListController {

    @Autowired
    private StudentRepository repo;

    private List<Student> students;

    @Deferred
    @RequestAction
    @IgnorePostback
    public void getAllStudents(){
        students = (List<Student>) repo.findAll();
        System.out.println(students);
    }

    public List<Student> getStudents(){
        return students;
    }

}
