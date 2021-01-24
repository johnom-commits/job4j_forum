package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Answer;
import ru.job4j.forum.repository.AnswerRepository;

@Service
public class AnswerService {
    private AnswerRepository story;

    public AnswerService(AnswerRepository story) {
        this.story = story;
    }

    public Answer getAnswerById(int id) {
        return story.findById(id).get();
    }

    public void save(Answer answer) {
        story.save(answer);
    }
}
