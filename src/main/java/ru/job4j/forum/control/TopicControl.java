package ru.job4j.forum.control;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import ru.job4j.forum.model.Answer;
import ru.job4j.forum.model.Topic;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.AnswerService;
import ru.job4j.forum.service.TopicService;

import java.util.Calendar;

@Controller
public class TopicControl {
    private TopicService topicService;
    private AnswerService answerService;

    public TopicControl(TopicService topicService, AnswerService answerService) {
        this.topicService = topicService;
        this.answerService = answerService;
    }

    @GetMapping("edit")
    public String edit(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        return "edit";
    }

    @GetMapping("topic/{id}")
    public String showTopic(@PathVariable int id, Model model, @AuthenticationPrincipal User user) {
        Topic topic = topicService.getTopicById(id);
        model.addAttribute("topic", topic);
        model.addAttribute("user", user);
        return "topic";
    }

    @PostMapping("save")
    public String save(@ModelAttribute Topic topic, @AuthenticationPrincipal User user) {
        topic.setAuthor(user);
        topicService.save(topic);
        return "redirect:/";
    }

    @PostMapping("save_answer")
    public View saveAnswer(@ModelAttribute Answer answer, @RequestParam("topic_id") String topic_id, @AuthenticationPrincipal User user) {
        answer.setCreated(Calendar.getInstance());
        answer.setAuthor(user);
        answerService.save(answer);

        Topic topic = topicService.getTopicById(Integer.parseInt(topic_id));
        topic.addAnswer(answer);
        topicService.save(topic);
        return new RedirectView("/topic/" + topic_id);
    }
}
