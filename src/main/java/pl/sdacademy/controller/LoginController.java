package pl.sdacademy.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) { // czy jest ktoś zalogowany
            new SecurityContextLogoutHandler().logout(request,response ,authentication);
        }
        return "redirect:/login";
    }

}