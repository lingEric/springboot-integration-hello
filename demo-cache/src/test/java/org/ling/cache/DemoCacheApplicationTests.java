package org.ling.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ling.common.bean.Student;
import org.ling.common.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoCacheApplicationTests {
    @Autowired
    private StudentService studentService;

    @Test
    public void contextLoads() {
        System.out.println(studentService.getStudentById(2));
    }

    @Test
    public void testUpdate() {
        studentService.updateStudent(new Student(1,"gotohell","female",23));
    }

    @Test
    public void testDelete() {
        studentService.deleteStudent(1);
    }
}
