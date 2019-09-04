package com.student.controller;

import com.student.data.StudentRepository;
import com.student.pojo.Student;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Scope(value = "session")
@Component(value = "studentList")
@ELBeanName(value = "studentList")
@Join(path="/", to="student-list.jsf")
public class StudentListController {

    private final StudentRepository repo;

    private List<Student> students;

    public StudentListController(@Qualifier(value = "studentRepository") StudentRepository repo) {
        this.repo = repo;
    }

    @Deferred
//    @RequestAction
    @IgnorePostback
    public void getAllStudents(){
        System.out.println("hello");
        students = (List<Student>) repo.findAll();
        System.out.println(students);
    }

    public List<Student> getStudents(){
        return students;
    }

}
