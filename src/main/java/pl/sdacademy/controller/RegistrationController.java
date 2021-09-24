package pl.sdacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sdacademy.service.UserService;
import pl.sdacademy.model.User;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/addUser")
    public String registrationForm(Model model) {
        model.addAttribute("user", new User());
        return "user_add_form";
    }

    @PostMapping("/addUser")
    public String register(@ModelAttribute User user) {
        userService.encodePassword(user);
        userService.save(user);
        return "user_add_confirm";
    }
}