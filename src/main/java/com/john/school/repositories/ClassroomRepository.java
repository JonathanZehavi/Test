package com.john.school.repositories;

import com.john.school.dto.Classroom;
import com.john.school.entities.ClassroomEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassroomRepository extends CrudRepository<ClassroomEntity, Integer> {
    @Query("SELECT new com.john.school.dto.Classroom(c.id, c.classroomName) " +
            "FROM ClassroomEntity c WHERE c.id= :id")
    Classroom fetchClassroomDto(@Param("id") int id);

    @Query("SELECT new com.john.school.dto.Classroom(c.id, c.classroomName) " +
            "FROM ClassroomEntity c")
    List<Classroom> fetchClassroomsDto();
}
