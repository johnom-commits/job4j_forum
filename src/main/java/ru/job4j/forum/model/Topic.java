package ru.job4j.forum.model;

import lombok.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Data
public class Topic {
    private int id;
    private String name;
    private String description;
    private Calendar created;
    private User author;
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
