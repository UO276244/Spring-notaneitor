package com.example.notaneitor.controllers;

import com.example.notaneitor.entities.Mark;
import com.example.notaneitor.entities.Teacher;
import com.example.notaneitor.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @RequestMapping("/teacher/list")
    public String getList() {

        List<Teacher> list = teacherService.getTeachers();

        String str = "";
        for(Teacher t : list){
            str += t.toString() +"\n";
        }

        return str;

    }


    @RequestMapping(value = "/teacher/add")
    public String setTeacher(@ModelAttribute Teacher teacher) {
        teacherService.addTeacher(teacher);
        return "Added: " + teacher.toString();
    }

    @RequestMapping("/teacher/details/{dni}")
    public String getDetail(@PathVariable String dni) {
        Teacher t = teacherService.getTeacher(dni);

        if(t == null){
            return "No existe profesor con dni " + dni;
        }else{
            return t.toString();
        }
    }

    @RequestMapping("/teacher/delete/{dni}")
    public String deleteTeacher(@PathVariable String dni) {
        if(teacherService.deleteTeacher(dni)){
            return "Deleted dni: " + dni;
        }else{
            return "No existe el dni";
        }

    }

    @RequestMapping(value = "/teacher/edit/{dni}", method = RequestMethod.POST)
    public String setEdit(@PathVariable String dni ,@ModelAttribute Teacher teacher) {

        teacher.setDni(dni);
        teacherService.deleteTeacher(dni);
        teacherService.addTeacher(teacher);

        return "Editado: " +teacher.toString();

    }


}
