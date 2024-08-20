package com.example.takeNotesApp.DAO;

import com.example.takeNotesApp.notes.Note;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class NoteRepositoryImp implements NoteRepository {
    // This is responsible on JPA operations
    EntityManager entityManager;
    @Autowired
    public NoteRepositoryImp(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    // retrieve all notes
    @Override
    public List<String > findAllNotes() {
        Query query =  entityManager.createQuery("select content from Note ");
        return query.getResultList();
    }

    @Override
    public Note getById(int id) {
        return entityManager.find(Note.class,id);
    }

    @Override
    public void saveNote(Note note) {
        entityManager.merge(note);

    }

    @Override
    public int delete(int id) {
        return 0;
    }


}
