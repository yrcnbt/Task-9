package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.Service.UserService;
import ru.itmentor.spring.boot_security.demo.dao.RoleDao;
import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {
    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user")
    public List<User> index() {
        return userService.getListUser();
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<HttpStatus> remove(@PathVariable("id") Long id) {
        userService.removeUser(userService.getUserById(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/user")
    public User add(@RequestBody User user ) {
        userService.addUser(user);
        return user;
    }

    @PutMapping("/user")
    public User update(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }


}
