package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Answer;
import ru.job4j.forum.repository.MemAnswers;

@Service
public class AnswerService {
    private MemAnswers story;

    public AnswerService(MemAnswers story) {
        this.story = story;
    }

    public Answer getAnswerById(int id) {
        return story.getAnswerById(id);
    }

    public void save(Answer answer) {
        story.save(answer);
    }
}
