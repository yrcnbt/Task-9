package ru.itmentor.spring.boot_security.demo.dao;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmentor.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long>{

    public User findByUsername(String username);
//    public void addUser(User user);
//
//    public void updateUser(Long id, User user);
//
//    public void removeUser(User user);
//
//    public User getUserById(Long id);
//
//    public List<User> getListUser();
//
//    public User getUserByUsername(String username);
}

