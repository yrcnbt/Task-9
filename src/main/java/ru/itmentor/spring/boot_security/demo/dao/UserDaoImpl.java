package ru.itmentor.spring.boot_security.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import ru.itmentor.spring.boot_security.demo.model.Role;
import ru.itmentor.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public  class UserDaoImpl {


//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Transactional
//    @Override
//    public void addUser(User user) {
//        entityManager.persist(user);
//    }
//
//    @Transactional
//    @Override
//    public void updateUser(Long id, User updatedUser) {
//        entityManager.merge(updatedUser);
//    }
//
//    @Transactional
//    @Override
//    public void removeUser(User user) {
//        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
//    }
//
//    @Override
//    public User getUserById(Long id) {
//        return entityManager.find(User.class, id);
//    }
//
//    @Override
//    public List<User> getListUser() {
//        return entityManager.createQuery("from User", User.class).getResultList();
//    }
//
//    @Override
//    public User getUserByUsername(String username){
//        return entityManager.find(User.class, username);
//    }


}
