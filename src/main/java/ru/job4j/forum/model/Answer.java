package ru.job4j.forum.model;

import lombok.Data;

import java.util.Calendar;

@Data
public class Answer {
    private int id;
    private String content;
    private User author;
    private Calendar created;

    public static Answer of(String content) {
        Answer answer = new Answer();
        answer.content = content;
        return answer;
    }
}
