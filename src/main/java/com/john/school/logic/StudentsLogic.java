package com.john.school.logic;

import com.john.school.dto.Classroom;
import com.john.school.dto.Student;
import com.john.school.entities.ClassroomEntity;
import com.john.school.entities.StudentsEntity;
import com.john.school.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsLogic {

    private final StudentsRepository studentsRepository;
    private final ClassroomLogic classroomLogic;

    @Autowired
    public StudentsLogic(StudentsRepository studentsRepository, @Lazy ClassroomLogic classroomLogic) {
        this.studentsRepository = studentsRepository;
        this.classroomLogic = classroomLogic;
    }

    public Student addStudent(Student student){
        StudentsEntity studentsEntity = new StudentsEntity(student);
        Classroom classroom = classroomLogic.getClassroomById(student.getClassroomId());
        ClassroomEntity classroomEntity = new ClassroomEntity(classroom);
        studentsEntity.setClassroom(classroomEntity);
        studentsEntity = studentsRepository.save(studentsEntity);
        return new Student(studentsEntity);
    }

    public Student getStudent(int id){
        return studentsRepository.fetchStudentDto(id);
    }

    public List<Student> getStudents(){
        return studentsRepository.fetchStudentsDto();
    }

    public List<Student> getAllClassroomStudents(int classroomId){
        return studentsRepository.findAllByClassroomId(classroomId);
    }
}
