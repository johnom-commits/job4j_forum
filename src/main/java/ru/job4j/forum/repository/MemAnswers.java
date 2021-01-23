package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Answer;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MemAnswers {

    private final List<Answer> answers = new CopyOnWriteArrayList<>();
    private final AtomicInteger atomInt = new AtomicInteger();

    public MemAnswers() {
    }

    public Answer getAnswerById(int id) {
        return answers.get(id - 1);
    }

    public void save(Answer answer) {
        atomInt.set(answers.size());
        answer.setId(atomInt.incrementAndGet());
        answer.setCreated(Calendar.getInstance());
        answers.add(answer);
    }
}
