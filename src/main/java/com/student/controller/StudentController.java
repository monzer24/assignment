package com.student.controller;

import com.student.data.StudentRepository;
import com.student.pojo.Student;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.faces.bean.ManagedBean;

@Component(value = "registerController")
//@ELBeanName(value = "registerController")
@ManagedBean(name = "registerController")
@Join(path="/student", to="/student-form.jsf")
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository repo;

    private Student student;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    public StudentRepository getRepo() {
        return repo;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @GetMapping
    public String toStudent(){
        System.out.println("hi");
        return "/student-form.xhtml";
    }

    private String saveStudent(){
        repo.save(student);
        System.out.println("hi");
        student = new Student();
        return "/student-list.xhtml";//?faces-redirect=true";
    }

    public Student getStudent(){
        System.out.println(student);
        return student;
    }

}
