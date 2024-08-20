package com.example.takeNotesApp.restController;

import com.example.takeNotesApp.notes.Note;
import com.example.takeNotesApp.service.Service;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DemoController {
    Service service;
    @Autowired
    public DemoController(Service service){
        this.service=service;
    }
    @GetMapping("/showNotes")
    public String findAll(Model model){
        model.addAttribute("Notes",service.findAllNotes());
        return "notes";
    }
    @RequestMapping("/newNote")
    public String addNewNote(Model model){
        model.addAttribute("note",new Note());
        return "newNote";
    }
    @RequestMapping(value = "/saveNote", method = RequestMethod.POST)
    public String saveNote(@ModelAttribute Note theNote) {
        service.saveNote(theNote);
        return "redirect:/showNotes";
    }
    @GetMapping("/getNote")
    public String getById(Model model){
        return "getNote";
    }
    @GetMapping("/viewSingleNote")
    public String view(@RequestParam("id") int id, Model model) {
        Note note = service.getById(id);
        model.addAttribute("note", note);
        return "viewNote";
    }


}
