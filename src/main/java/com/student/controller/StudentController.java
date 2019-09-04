package com.student.controller;

import com.student.data.StudentRepository;
import com.student.pojo.Student;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value="session")
@Component(value = "registerController")
@ELBeanName(value = "registerController")
@Join(path="/student", to="/student-form.jsf")
public class StudentController {

    @Autowired
    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    private StudentRepository repo;

    private Student student;

    private String saveStudent(){
        repo.save(student);
        System.out.println("hi");
        student = new Student();
        return "/student-list.xhtml?faces-redirect=true";
    }

    private Student getStudent(){
        return student;
    }

}
