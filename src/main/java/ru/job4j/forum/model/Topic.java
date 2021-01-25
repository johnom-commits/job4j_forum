package ru.job4j.forum.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Data
@Table(name = "topics")
@NoArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 500)
    private String name;
    private String description;
    @org.hibernate.annotations.CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar created;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Answer> answers = new ArrayList<>();

    public static Topic of(int id, String name, String description, User author) {
        Topic topic = new Topic();
        topic.id = id;
        topic.name = name;
        topic.description = description;
        topic.created = Calendar.getInstance();
        topic.author = author;
        return topic;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public void addAnswers(List<Answer> list) {
        answers.addAll(list);
    }
}


