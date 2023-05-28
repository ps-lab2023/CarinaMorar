package com.beautyProducts.beautyProducts.service;

import com.beautyProducts.beautyProducts.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserService {
    List<User> findAllUsers();

    Optional<User> findUserById(Long id);

    List<User> findUserByUsername(String username);

    Optional<User> findUserByEmail(String email);

    Long deleteUserById(Long id);

    User deleteUser(User user);

    User createUser(User user);

    User updateUserName(User user, String name);

    User updateUserLastName(User user, String name);

    User updateUserFirstName(User user, String name);

    User updateUserEmail(User user, String email);

    User updateUserPass(User user, String pass);

    //String logIn(User user1, String email, String password);

    User findByEmailAndPassword(String email, String password);

    User logIn(String email, String password);

    void logOut(String email);

    //User updateUser(User user);
}
