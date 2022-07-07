package com.john.school.entities;

import com.john.school.dto.Student;
import javax.persistence.*;

@Entity
@Table(name = "students")
public class StudentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private ClassroomEntity classroom;

    public StudentsEntity() {
    }

    public StudentsEntity(Student student) {
        this.id = student.getId();
        this.name = student.getName();
    }

    public StudentsEntity(int id, String name, ClassroomEntity classroom) {
        this.id = id;
        this.name = name;
        this.classroom = classroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClassroomEntity getClassroom() {
        return classroom;
    }

    public void setClassroom(ClassroomEntity classroom) {
        this.classroom = classroom;
    }
}
