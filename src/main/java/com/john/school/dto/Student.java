package com.john.school.dto;

import com.john.school.entities.StudentsEntity;

public class Student {
    private int id;
    private String name;
    private int age;
    private int classroomId;

    public Student(int id, String name, int age, int classroomId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.classroomId = classroomId;
    }

    public Student(int id, String name, int classroomId) {
        this.id = id;
        this.name = name;
        this.classroomId = classroomId;
    }

    public Student(String name, int age, int classroomId) {
        this.name = name;
        this.age = age;
        this.classroomId = classroomId;
    }

    public Student(StudentsEntity studentsEntity) {
        this.id = studentsEntity.getId();
        this.name = studentsEntity.getName();
        this.classroomId = studentsEntity.getClassroom().getId();
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", classroomId=" + classroomId +
                '}';
    }

}
