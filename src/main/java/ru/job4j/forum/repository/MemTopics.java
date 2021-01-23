package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Topic;
import ru.job4j.forum.model.User;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MemTopics {
    private final List<Topic> topics = new CopyOnWriteArrayList<>();
    private final AtomicInteger atomInt = new AtomicInteger();

    public MemTopics() {
        topics.add(Topic.of(1, "Продаю машину ладу 01.", "Год выпуска 1980, в хорошем состоянии", User.of(3, "Petr", "$2a$10$ZEfTW2GO2vMTX06/Cxt9KueWPvhcbDts2alD2HPBfLktdB42tfP92", true)));
        topics.add(Topic.of(2, "Продаю машину Лада Ока", "", User.of(4, "Stas", "$2a$10$ZEfTW2GO2vMTX06/Cxt9KueWPvhcbDts2alD2HPBfLktdB42tfP92", true)));
    }

    public List<Topic> getAll() {
        return topics;
    }

    public Topic getTopicById(int id) {
        return topics.get(id - 1);
    }

    public void save(Topic topic) {
        atomInt.set(topics.size());
        topic.setId(atomInt.incrementAndGet());
        topic.setCreated(Calendar.getInstance());
        topics.add(topic);
    }

    public void update(Topic topic) {
    }
}
