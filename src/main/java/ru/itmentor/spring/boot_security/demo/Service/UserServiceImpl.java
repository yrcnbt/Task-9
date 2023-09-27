package ru.itmentor.spring.boot_security.demo.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itmentor.spring.boot_security.demo.dao.UserDao;
import ru.itmentor.spring.boot_security.demo.model.Role;
import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserDao ud;


    @Override
    public void addUser(User user) {
        ud.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser = ud.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setUsername(user.getUsername());
        existingUser.setRoles(user.getRoles());
        existingUser.setPassword(user.getPassword());
        existingUser.setEnabled(user.getEnabled());
        return ud.save(existingUser);
    }

    @Override
    public void removeUser(User user) {
        ud.delete(user);
    }

    @Override
    public User getUserById(Long id) {
        return ud.getById(id);
    }

    @Override
    public List<User> getListUser() {
        return ud.findAll();
    }

    @Override
    public User findByUsername(String username){
        return ud.findByUsername(username);
    }

    @Autowired
    public void setUd(UserDao ud) {
        this.ud = ud;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = ud.findByUsername(username);


        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToGrandAuthority(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToGrandAuthority(Collection<Role> roles){
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toSet());
    }
}
