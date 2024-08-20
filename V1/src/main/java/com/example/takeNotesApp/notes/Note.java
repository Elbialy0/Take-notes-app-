package com.example.takeNotesApp.notes;

import jakarta.persistence.*;
import org.aspectj.weaver.ast.Not;

@Entity
@Table(name = "notes")
public class Note {
    // Primary key of the note
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    // Content of the note
    @Column(name = "content")
    private String content;

    // Default constructor
    public Note(){

    }
    // Param constructor
    public Note(String content){
        this.content = content;
    }
    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
