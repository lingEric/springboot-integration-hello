package org.ling.common.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ling.common.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@SpringBootTest()
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentServiceTest {

    @Autowired
    StudentService studentService;

    @Test
    public void insertStudent() {
        studentService.insertStudent(new Student(1,"aaa","male",12));
    }

    @Test
    public void getStudentById() {
        System.out.println(studentService.getStudentById(1));;
    }

    @Test
    public void updateStudent() {
        studentService.updateStudent(new Student(1,"bbb","male",23));
    }

    @Test
    public void deleteStudent() {
        studentService.deleteStudent(1);
    }
}