package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Topic;
import ru.job4j.forum.repository.MemTopics;

import java.util.List;

@Service
public class TopicService {
    private MemTopics story;

    public TopicService(MemTopics story) {
        this.story = story;
    }

    public List<Topic> getAll() {
        return story.getAll();
    }

    public Topic getTopicById(int id) {
        return story.getTopicById(id);
    }

    public void save(Topic topic) {
        story.save(topic);
    }

    public void update(Topic topic) {
        story.update(topic);
    }
}
