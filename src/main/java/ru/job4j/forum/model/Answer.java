package ru.job4j.forum.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;

@Data
@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author;
    @org.hibernate.annotations.CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar created;

    public static Answer of(String content) {
        Answer answer = new Answer();
        answer.content = content;
        return answer;
    }
}
