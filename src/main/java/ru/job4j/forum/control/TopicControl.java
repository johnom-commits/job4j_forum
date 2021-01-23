package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import ru.job4j.forum.model.Answer;
import ru.job4j.forum.model.Topic;
import ru.job4j.forum.service.AnswerService;
import ru.job4j.forum.service.TopicService;
import ru.job4j.forum.service.UserService;

import java.security.Principal;
import java.util.Calendar;

@Controller
public class TopicControl {
    private TopicService topicService;
    private AnswerService answerService;
    private UserService userService;

    public TopicControl(TopicService topicService, AnswerService answerService, UserService userService) {
        this.topicService = topicService;
        this.answerService = answerService;
        this.userService = userService;
    }

    @GetMapping("edit")
    public String edit(Model model, Principal principal) {
        model.addAttribute("user", principal.getName());
        return "edit";
    }

    @GetMapping("topic/{id}")
    public String showTopic(@PathVariable String id, Model model, Principal principal) {
        Topic topic = topicService.getTopicById(Integer.parseInt(id));
        model.addAttribute("topic", topic);
        model.addAttribute("user", principal.getName());
        return "topic";
    }

    @PostMapping("save")
    public String save(@ModelAttribute Topic topic, Principal principal) {
        topic.setAuthor(userService.findByUsername(principal.getName()));
        topicService.save(topic);
        return "redirect:/";
    }

    @PostMapping("save_answer")
    public View saveAnswer(@ModelAttribute Answer answer, @RequestParam("topic_id") String topic_id, Principal principal) {
        answer.setCreated(Calendar.getInstance());
        answer.setAuthor(userService.findByUsername(principal.getName()));
        answerService.save(answer);

        Topic topic = topicService.getTopicById(Integer.parseInt(topic_id));
        topic.addAnswer(answer);
        topicService.update(topic);
        return new RedirectView("/topic/" + topic_id);
    }
}
