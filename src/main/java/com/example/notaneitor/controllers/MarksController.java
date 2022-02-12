package com.example.notaneitor.controllers;

import com.example.notaneitor.entities.Mark;
import com.example.notaneitor.services.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
public class MarksController {

    @Autowired //Inyectar el servicio
    private MarksService marksService;

    @RequestMapping("/mark/list")
    public String getList(Model model) {
        model.addAttribute("markList", marksService.getMarks());
        return "mark/list";
    }

    /**
     * @RequestMapping("/mark/add") public String setMark() {
     * return "Adding Mark";
     * }
     **/
    /**
     * @RequestMapping(value = "/mark/add", method = RequestMethod.POST)
     * public String setMark(@RequestParam String description, @RequestParam String score) {
     * return "Added: " + description + " with score " + score;
     * }
     **/

    @RequestMapping(value = "/mark/add")
    public String getMark() {

        return "mark/add";
    }

    @RequestMapping(value = "/mark/add", method = RequestMethod.POST)
    public String setMark(@ModelAttribute Mark mark) {
        marksService.addMark(mark);
        return "redirect:/mark/list";
    }


    @RequestMapping("/mark/details/{id}")
    public String getDetail(Model model, @PathVariable Long id) {
        model.addAttribute("mark", marksService.getMark(id));
        return "mark/details";
    }

    @RequestMapping("/mark/delete/{id}")
    public String deleteMark(@PathVariable Long id) {
        marksService.deleteMark(id);
        return "redirect:/mark/list";
    }


    @RequestMapping(value = "/mark/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        model.addAttribute("mark", marksService.getMark(id));
        return "mark/edit";
    }

    @RequestMapping(value = "/mark/edit/{id}", method = RequestMethod.POST)
    public String setEdit(@ModelAttribute Mark mark, @PathVariable Long id) {
        mark.setId(id);
        marksService.addMark(mark);
        return "redirect:/mark/details/" + id;
    }

}
