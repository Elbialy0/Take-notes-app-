package com.example.takeNotesApp.restController;

import com.example.takeNotesApp.notes.Note;
import com.example.takeNotesApp.service.Service;
import com.example.takeNotesApp.service.ServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    Service service;
    public Controller(Service service){this.service=service;}

    @GetMapping("/Notes")
    public List<String > find(){
        return service.findAllNotes();
    }
    @PostMapping("/Notes")
    public void add(@RequestBody Note note){
        service.saveNote(note);
    }
    @DeleteMapping("/Notes/{noteId}")
    public int deleteNote(@PathVariable int id){
        service.delete(id);
        return id;
    }
    @PutMapping("/Notes/{noteId}")
    public Note getById (@PathVariable int id){
        return service.getById(id);
    }
}
