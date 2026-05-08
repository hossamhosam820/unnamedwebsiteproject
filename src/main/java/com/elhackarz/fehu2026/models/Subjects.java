package com.elhackarz.fehu2026.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20, unique = true)
    private String name;
    @Column(nullable = false, length = 100, unique = false)
    private String imagepath;
    @Column(nullable = false, length = 20, unique = false)
    private int lectures;
    @Column(nullable = false, length = 20, unique = false)
    private String instructor;
    public Subjects() {
        // dont need to implement
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImagepath() {
        return this.imagepath;
    }
    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }
    public int getLectures() {
        return lectures;
    }
    public void setLectures(int lectures) {
        this.lectures = lectures;
    }
    public String getInstructor() {
        return this.instructor;
    }
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
