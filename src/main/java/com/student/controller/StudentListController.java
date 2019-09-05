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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import javax.faces.bean.ManagedBean;
import java.util.List;

@Scope(value = "session")
@Component(value = "students")
@ELBeanName(value = "students")
@ManagedBean(name = "students")
@Join(path="/list", to="student-list.jsf")
@RestController
@RequestMapping("/list")
public class StudentListController {

    @Autowired
    private StudentRepository repo;

    private List<Student> students;

    @Autowired
    public StudentListController(StudentRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public String toStudentList(){
        System.out.println("hello");
        return "/student-list.xhtml";
    }

    @Deferred
//    @RequestAction
//    @IgnorePostback
    public void getAllStudents(){
        System.out.println("hello");
        students = repo.findAll();
        System.out.println(students);
    }

    public List<Student> getStudents(){
        return students;
    }

}
