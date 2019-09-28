package org.ling.common.service;

import org.ling.common.bean.Student;
import org.ling.common.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public Student getStudentById(Integer id) {
        System.out.println("从数据库中查询学生：" + id);
        return studentMapper.getStudentById(id);
    }

    public Student updateStudent(Student student) {
        System.out.println("更新数据库中的学生数据：" + student);
        studentMapper.updateStudent(student);
        return student;
    }

    public void deleteStudent(Integer id) {
        System.out.println("删除数据库中的学生：" + id);
        studentMapper.delStudent(id);
    }

    public void insertStudent(Student student) {
        System.out.println("插入学生：" + student + "到数据库中");
        studentMapper.insertStudent(student);
    }
}
