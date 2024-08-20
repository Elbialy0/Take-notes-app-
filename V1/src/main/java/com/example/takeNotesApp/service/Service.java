package com.example.takeNotesApp.service;

import com.example.takeNotesApp.notes.Note;

import java.util.List;

public interface Service {
    public List<String> findAllNotes();
    public Note getById(int id);
    public void saveNote(Note note);
    public int delete(int id);
}
