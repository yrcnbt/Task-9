package ru.itmentor.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.Service.UserService;
import ru.itmentor.spring.boot_security.demo.dao.RoleDao;
import ru.itmentor.spring.boot_security.demo.model.Role;
import ru.itmentor.spring.boot_security.demo.model.User;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    private RoleDao roleDao;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/admin")
    public String index(ModelMap model) {
        model.addAttribute("users", userService.getListUser());
        return "admin";
    }

    @DeleteMapping(value = "/{id}")
    public String remove(@PathVariable("id") Long id) {
        userService.removeUser(userService.getUserById(id));
        return "redirect:/users/admin";
    }

    @PostMapping
    public String add(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users/admin";
    }

    @GetMapping(value = "/add")
    public String newUser(Model model) {
//        List<Role> roles = roleDao.findAll();
//        model.addAttribute("roles", roles);
        model.addAttribute("user", new User());
        return "add";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.updateUser(id, user);
        return "redirect:/users/admin";
    }

    @GetMapping("/user")
    public String thisUser(Model model, Principal principal){
        String username = principal.getName();
        User user = userService.findByUsername(username);
        model.addAttribute("user", user);
        return "user";
    }

    @Autowired
    public void setUs(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}
