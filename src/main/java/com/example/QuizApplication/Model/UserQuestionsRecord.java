package com.example.QuizApplication.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "userQuestionsRecord")
public class UserQuestionsRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int q_id;

    public UserQuestionsRecord(String name, int q_id) {
        this.name = name;
        this.q_id = q_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQ_id() {
        return q_id;
    }

    public void setQ_id(int q_id) {
        this.q_id = q_id;
    }
}
