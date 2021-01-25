package ru.job4j.forum.control;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Answer;
import ru.job4j.forum.model.Topic;
import ru.job4j.forum.service.AnswerService;
import ru.job4j.forum.service.TopicService;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class PostControlTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TopicService topicService;

    @MockBean
    private AnswerService answerService;

    @Captor
    ArgumentCaptor<Topic> topicArgumentCaptor;

    @Captor
    ArgumentCaptor<Answer> answerArgumentCaptor;

    @Test
    @WithMockUser
    public void whenCreateNewTopic() throws Exception {
        mockMvc.perform(post("/save")
                .param("name", "Куплю ноутбук.")
                .param("description", "Недорого"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        verify(topicService).save(topicArgumentCaptor.capture());
        Topic topic = topicArgumentCaptor.getValue();
        assertEquals("Куплю ноутбук.", topic.getName());
        assertEquals("Недорого", topic.getDescription());
    }

    @Test
    @WithMockUser
    public void whenCreateNewAnswer() throws Exception {
        Topic topic = new Topic();
        topic.setName("Отдам кота в хорошие руки");
        when(topicService.getTopicById(anyInt())).thenReturn(topic);

        mockMvc.perform(post("/save_answer")
                .param("content", "Когда можно посмотреть?")
                .queryParam("topic_id", "1"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        verify(answerService).save(answerArgumentCaptor.capture());
        Answer answer = answerArgumentCaptor.getValue();
        assertEquals("Когда можно посмотреть?", answer.getContent());
    }
}
