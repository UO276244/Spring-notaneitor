package com.example.notaneitor.repositories;

import com.example.notaneitor.entities.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher,Long> {
}
