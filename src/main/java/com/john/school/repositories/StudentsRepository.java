package com.john.school.repositories;

import com.john.school.dto.Student;
import com.john.school.entities.StudentsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentsRepository extends CrudRepository<StudentsEntity, Integer> {

    @Query("SELECT new com.john.school.dto.Student(s.id, s.name, c.id) " +
            "From StudentsEntity s INNER JOIN s.classroom c WHERE s.id= :id")
    Student fetchStudentDto(@Param("id") int id);

    @Query("SELECT new com.john.school.dto.Student(s.id, s.name, c.id) " +
            "From StudentsEntity s INNER JOIN s.classroom c")
    List<Student> fetchStudentsDto();

    List<Student> findAllByClassroomId(int classroomId);
}
