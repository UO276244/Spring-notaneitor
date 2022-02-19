package com.uniovi.notaneitor.controllers;

import com.uniovi.notaneitor.entities.Teacher;
import com.uniovi.notaneitor.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/teacher/details/{id}")
    public String getDetail(@PathVariable Long id) {
        Teacher t = teacherService.getTeacher(id);

        if(t == null){
            return "No existe profesor con id " + id;
        }else{
            return t.toString();
        }
    }

    @RequestMapping("/teacher/delete/{id}")
    public String deleteTeacher(@PathVariable Long id) {
            teacherService.deleteTeacher(id);
            return "Deleted id: " + id;


    }

    @RequestMapping(value = "/teacher/edit/{id}", method = RequestMethod.POST)
    public String setEdit(@PathVariable Long id ,@ModelAttribute Teacher teacher) {

        teacher.setId(id);
        teacherService.addTeacher(teacher);
        return "Editado: " +teacher.toString();

    }


}
