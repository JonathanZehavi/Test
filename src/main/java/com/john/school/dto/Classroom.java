package com.john.school.dto;

import com.john.school.entities.ClassroomEntity;

import java.util.List;

public class Classroom {
    private int id;
    private String classroomName;
    private List<Student> studentList;

    public Classroom(int id, String classroomName, List<Student> studentList) {
        this.id = id;
        this.classroomName = classroomName;
        this.studentList = studentList;
    }

    public Classroom(String classroomName, List<Student> studentList) {
        this.classroomName = classroomName;
        this.studentList = studentList;
    }

    public Classroom(ClassroomEntity classroomEntity) {
        this.id = classroomEntity.getId();
        this.classroomName = classroomEntity.getClassroomName();
    }

    public Classroom(int id, String classroomName) {
        this.id = id;
        this.classroomName = classroomName;
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

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", classroomName='" + classroomName + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
