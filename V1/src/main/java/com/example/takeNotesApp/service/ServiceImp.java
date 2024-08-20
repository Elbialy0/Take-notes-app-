package com.example.takeNotesApp.service;

import com.example.takeNotesApp.DAO.NoteRepository;
import com.example.takeNotesApp.notes.Note;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service
public class ServiceImp implements Service{
    NoteRepository noteRepository;
    @Autowired
    public ServiceImp(NoteRepository noteRepository){
        this.noteRepository=noteRepository;
    }
    @Override
    public List<String > findAllNotes() {
        return noteRepository.findAllNotes();
    }

    @Override
    public Note getById(int id) {
        return noteRepository.getById(id);
    }

    @Override
    @Transactional
    public void saveNote(Note note) {
        noteRepository.saveNote(note);

    }

    @Override
    @Transactional
    public int delete(int id) {
        noteRepository.delete(id);
        return id;
    }
}
