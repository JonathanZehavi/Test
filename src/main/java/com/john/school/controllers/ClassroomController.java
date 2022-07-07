package com.john.school.controllers;

import com.john.school.dto.Classroom;
import com.john.school.logic.ClassroomLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classrooms")
public class ClassroomController {

    private final ClassroomLogic classroomLogic;

    @Autowired
    public ClassroomController(ClassroomLogic classroomLogic) {
        this.classroomLogic = classroomLogic;
    }

    @PostMapping
    public Classroom addClassroom(@RequestBody Classroom classroom) {
        return classroomLogic.addClassroom(classroom);
    }

    @GetMapping
    public List<Classroom> getClassrooms() {
        return classroomLogic.getClassrooms();
    }

    @GetMapping("/{id}")
    public Classroom getClassroom(@PathVariable(name = "id") int id) {
        return classroomLogic.getClassroomById(id);
    }

}
