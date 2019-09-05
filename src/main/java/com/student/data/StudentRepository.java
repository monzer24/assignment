package com.student.data;

import com.student.pojo.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component("repo")
public interface StudentRepository extends CrudRepository<Student, String> {

    List<Student> findAll();
}
