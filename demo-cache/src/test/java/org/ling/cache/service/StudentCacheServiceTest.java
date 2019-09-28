package org.ling.cache.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ling.common.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentCacheServiceTest {

    @Autowired
    StudentCacheService studentCacheService;

    @Test
    public void getStudentById() {
        System.out.println(studentCacheService.getStudentById(1));;
    }

    @Test
    public void updateStudent() {
        studentCacheService.updateStudent(new Student(1,"lucy","male",23));
    }

    @Test
    public void deleteStudent() {
        studentCacheService.deleteStudent(1);
    }

    @Test
    public void insertStudent() {
        studentCacheService.insertStudent(new Student(1,"abc","male",23));
    }
}