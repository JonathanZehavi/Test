package com.john.school.entities;

import com.john.school.dto.Classroom;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classrooms")
public class ClassroomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "classroom_name")
    private String classroomName;

    @OneToMany(mappedBy = "classroom")
    private List<StudentsEntity> students;

    public ClassroomEntity() {
    }

    public ClassroomEntity(Classroom classroom) {
        this.id = classroom.getId();
        this.classroomName = classroom.getClassroomName();
    }

    public ClassroomEntity(int id, String classroomName, List<StudentsEntity> students) {
        this.id = id;
        this.classroomName = classroomName;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String name) {
        this.classroomName = classroomName;
    }

    public List<StudentsEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentsEntity> students) {
        this.students = students;
    }

}
