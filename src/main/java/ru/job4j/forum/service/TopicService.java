package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Topic;
import ru.job4j.forum.repository.TopicRepository;

import java.util.List;

@Service
public class TopicService {
    private TopicRepository story;

    public TopicService(TopicRepository story) {
        this.story = story;
    }

    public List<Topic> getAll() {
        return (List<Topic>) story.findAll();
    }

    public Topic getTopicById(int id) {
        return story.findById(id).get();
    }

    public void save(Topic topic) {
        story.save(topic);
    }
}
