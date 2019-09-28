package org.ling.common.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.ling.common.bean.Student;
import org.springframework.stereotype.Component;

@Component
public interface StudentMapper {
    @Select("select * from student where id = #{id}")
    Student getStudentById(Integer id);

    @Update("update student set name = #{name} ,gender = #{gender} , age = #{age} where id = #{id}")
    void updateStudent(Student student);

    @Delete("delete from student where id = #{id}")
    void delStudent(Integer id);

    @Insert("insert into student(id,name,gender,age) values(#{id},#{name},#{gender},#{age})")
    void insertStudent(Student student);
}
