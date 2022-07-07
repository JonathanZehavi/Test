package com.john.school.logic;

import com.john.school.dto.Classroom;
import com.john.school.entities.ClassroomEntity;
import com.john.school.repositories.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomLogic {

    private final ClassroomRepository classroomRepository;
    private final StudentsLogic studentsLogic;

    @Autowired
    public ClassroomLogic(ClassroomRepository classroomRepository, @Lazy StudentsLogic studentsLogic) {
        this.classroomRepository = classroomRepository;
        this.studentsLogic = studentsLogic;
    }

    public Classroom addClassroom(Classroom classroom){
        ClassroomEntity classroomEntity = new ClassroomEntity(classroom);
        classroomEntity = classroomRepository.save(classroomEntity);
        return new Classroom(classroomEntity);
    }

    public Classroom getClassroomById(int id){
        Classroom classroom = classroomRepository.fetchClassroomDto(id);
        classroom.setStudentList(studentsLogic.getAllClassroomStudents(id));
        return classroom;
    }

    public List<Classroom> getClassrooms(){
        List<Classroom> classrooms = classroomRepository.fetchClassroomsDto();
        classrooms.forEach(classroom -> {
            classroom.setStudentList(studentsLogic.getAllClassroomStudents(classroom.getId()));
        });
        return classrooms;
    }



}
