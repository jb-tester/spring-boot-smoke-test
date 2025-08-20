package com.mytests.spring.springBootSmokeTest.events;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "person_events")
public class PersonEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String text;
    private String description;
    private LocalDate createdAt;

    public PersonEvent() {

    }
    public PersonEvent(String text, String description, LocalDate createdAt) {
        this.text = text;
        this.description = description;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "PersonEvent{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
