package com.example.notaneitor.services;


import com.example.notaneitor.entities.Mark;
import com.example.notaneitor.entities.Teacher;
import com.example.notaneitor.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository repo;


    private List<Teacher> teachers;

    public TeacherService(){

        this.teachers = new ArrayList<Teacher>();

    }

    public List<Teacher> getTeachers(){


        List<Teacher> teachers = new ArrayList<Teacher>();
        repo.findAll().forEach(teachers::add);
        return teachers;

    }


    public Teacher getTeacher(Long id){

        return repo.findById(id).get();

    }


    public void addTeacher(Teacher t){
        repo.save(t);
    }

    public void deleteTeacher(Long id){
        repo.deleteById(id);
    }
}
