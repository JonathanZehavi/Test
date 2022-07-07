package com.john.school.controllers;

import com.john.school.dto.Student;
import com.john.school.logic.StudentsLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {

    private StudentsLogic studentsLogic;

    @Autowired
    public StudentsController(StudentsLogic studentsLogic) {
        this.studentsLogic = studentsLogic;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentsLogic.addStudent(student);
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentsLogic.getStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable(name = "id") int id){
        return studentsLogic.getStudent(id);
    }

    @GetMapping("/byClassroom/{classroomId}")
    public List<Student> getStudentsByClassroomId(@PathVariable(name = "classroomId") int classroomId){
        return studentsLogic.getAllClassroomStudents(classroomId);
    }
}
