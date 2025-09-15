package testapp.testapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import testapp.testapp.controller.UserController;
import testapp.testapp.entity.User;
import testapp.testapp.repository.UserRepository;
import testapp.testapp.service.MailService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserRepository repo;

    @Mock
    private MailService mailService;

    @InjectMocks
    private UserController userController;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void testGetAllUsers() throws Exception {
        User user1 = new User();
        user1.setId(1L);
        user1.setName("Zayed");
        user1.setEmail("zayed@example.com");

        User user2 = new User();
        user2.setId(2L);
        user2.setName("Ali");
        user2.setEmail("ali@example.com");

        List<User> users = Arrays.asList(user1, user2);

        when(repo.findAll()).thenReturn(users);

        mockMvc.perform(get("/users/all")).andExpect(status().isOk()).andExpect(content().json(objectMapper.writeValueAsString(users)));
    }
}