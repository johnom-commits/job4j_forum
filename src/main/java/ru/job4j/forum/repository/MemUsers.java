package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemUsers {
    private final Map<String, User> users = new ConcurrentHashMap();

    public MemUsers() {
        users.put("user", User.of(1, "user", "$2a$10$ZEfTW2GO2vMTX06/Cxt9KueWPvhcbDts2alD2HPBfLktdB42tfP92", true));
        users.put("admin", User.of(2, "admin", "$2a$10$ZEfTW2GO2vMTX06/Cxt9KueWPvhcbDts2alD2HPBfLktdB42tfP92", true));
    }

    public User findByUsername(String name) {
        return users.get(name);
    }

    public void save(User user) {
        users.put(user.getUsername(), user);
    }
}
