package ru.itmentor.spring.boot_security.demo.Service;


import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {

    void addUser(User user);

    User updateUser(Long id, User user);

    void removeUser(User user);

    User getUserById(Long id);

    List<User> getListUser();

    public User findByUsername(String username);
}
