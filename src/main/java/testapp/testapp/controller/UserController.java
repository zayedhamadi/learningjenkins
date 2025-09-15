package testapp.testapp.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import testapp.testapp.entity.User;
import testapp.testapp.repository.UserRepository;
import testapp.testapp.service.MailService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/")
public class UserController {
    private final UserRepository repo;
    private final MailService mailService;

    @GetMapping("all")
    public List<User> all() {
        return repo.findAll();
    }

    @PostMapping("add")
    public User add(@RequestBody User u) {
        User saved = repo.save(u);
        mailService.sendMail(u.getEmail(),"Bienvenue",
                "Bonjour " + u.getName() + ", vous êtes ajouté !");
        return saved;
    }
}
