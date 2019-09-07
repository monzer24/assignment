package com.student.controller;

import com.student.data.StudentRepository;
import com.student.pojo.Student;
import lombok.extern.slf4j.Slf4j;
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
import javax.faces.bean.ManagedBean;
import java.util.List;

@Component(value = "studentListController")
@ELBeanName(value = "studentListController")
@ManagedBean(name = "students")
@Join(path="/list", to="student-list.jsf")
@RestController
@RequestMapping("/list")
@Slf4j
public class StudentListController {

    private StudentRepository repo;

    private List<Student> students;

    @Autowired
    public StudentListController(StudentRepository repo) {
        System.out.println("constructed");
        this.repo = repo;
    }

    @GetMapping
    public String toStudentList(){
        System.out.println("hello");
        return "/student-list.xhtml";
    }

    @Deferred
    @RequestAction
    @IgnorePostback
    public void getAllStudents(){
        System.out.println("hello");
        students = repo.findAll();
        System.out.println(students);
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents(){
        getAllStudents();
        log.info(String.valueOf(students));
        System.out.println(students);
        return students;
    }
}
