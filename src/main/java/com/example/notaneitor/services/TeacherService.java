package com.example.notaneitor.services;


import com.example.notaneitor.entities.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {


    private List<Teacher> teachers;

    public TeacherService(){

        this.teachers = new ArrayList<Teacher>();

    }

    public List<Teacher> getTeachers(){
        return new ArrayList<Teacher>(teachers);
    }


    public Teacher getTeacher( String dni){

        for(Teacher t : teachers){

            if(t.getDni().equals(dni)) return t;

        }

        return null;

    }


    public void addTeacher(Teacher t){
        teachers.add(t);
    }

    public boolean deleteTeacher(String dni){
        for(Teacher t : teachers){

            if(t.getDni().equals(dni)) {
                teachers.remove(t);
                return true;
            }

        }

        return false;

    }
}
