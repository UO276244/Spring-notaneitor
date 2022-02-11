package com.example.notaneitor.controllers;

import com.example.notaneitor.entities.Mark;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class MarksController {

    @RequestMapping("/mark/list")
    public String getList() {
        return "Getting List";
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

    @RequestMapping(value = "/mark/add", method = RequestMethod.POST)
    public String setMark(@ModelAttribute Mark mark) {
        return "added: " + mark.getDescription() +
                " with score : " + mark.getScore() +
                " id: " + mark.getId();
    }

    //  @RequestMapping("/mark/details")
    //   public String getDetail(@RequestParam Long id) {
    //       return "Getting Details => " + id ;
//    }


    @RequestMapping("/mark/details/{id}")
    public String getDetails(@PathVariable Long id) {
        return "Getting Details => " + id;
    }


}
