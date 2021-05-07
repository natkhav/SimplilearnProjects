package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Login;
import com.app.model.User;
import com.app.service.UserService;

import java.util.List;

@Controller
@SessionAttributes("userId")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ModelAndView login(@ModelAttribute Login login, Model model,
                              @ModelAttribute("userId") Long userId) {
        ModelAndView modelAndView = null;
        User user = userService.findByUsernameAndPassword(login.getUsername(), login.getPassword());

        if (user != null) {
            modelAndView = new ModelAndView("redirect:/user?id=" + user.getId());
            modelAndView.addObject("user", user);
            // Store user id in session
            model.addAttribute("userId", user.getId());
        } else {
            modelAndView = new ModelAndView("redirect:/");
        }

        return modelAndView;
    }

    @GetMapping("/user")
    public ModelAndView login(@RequestParam Long id) {
        User user = userService.findById(id);
        ModelAndView result = new ModelAndView("user");
        result.addObject("user", user);
        return result;
    }

    @GetMapping("/users")
    public ModelAndView viewAllUsers() {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", userService.findAll());
        return modelAndView;
    }

    @GetMapping("/users/user")
    public ModelAndView searchUser(@RequestParam String search) {
        ModelAndView modelAndView = new ModelAndView("users");
        List<User> searchResult = search != null && !search.isEmpty() ? userService.findBySearchParameter(search) : null;
        modelAndView.addObject("users", userService.findAll());
        modelAndView.addObject("searchResult", searchResult);
        return modelAndView;
    }

    @ModelAttribute("userId")
    public Long userId() {
        return new Long(0);
    }
}
