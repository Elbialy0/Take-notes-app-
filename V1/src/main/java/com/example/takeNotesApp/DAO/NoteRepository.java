package com.example.takeNotesApp.DAO;

import com.example.takeNotesApp.notes.Note;

import java.util.List;

public interface NoteRepository {
    public List<String> findAllNotes();
    public Note getById(int id);
    public void saveNote(Note note);
    public int delete(int id);
}
