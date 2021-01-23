package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.forum.service.TopicService;

import java.security.Principal;

@Controller
public class IndexControl {
    private final TopicService posts;

    public IndexControl(TopicService posts) {
        this.posts = posts;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model, Principal principal) {
        model.addAttribute("posts", posts.getAll());
        model.addAttribute("user", principal.getName());
        return "index";
    }
}
