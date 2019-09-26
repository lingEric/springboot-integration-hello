package org.ling.cache.service;

import org.ling.cache.bean.Student;
import org.ling.cache.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "student")
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Cacheable
    public Student getStudentById(Integer id) {
        System.out.println("从数据库中查询学生：" + id);
        return studentMapper.getStudentById(id);
    }

    @CachePut(key = "#result.id")
    public Student updateStudent(Student student) {
        System.out.println("更新数据库中的学生数据：" + student);
        studentMapper.updateStudent(student);
        return student;
    }

    @CacheEvict
    public void deleteStudent(Integer id) {
        System.out.println("删除数据库中的学生："+id);
        studentMapper.delStudent(id);
    }
}
