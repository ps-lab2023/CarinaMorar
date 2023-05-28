package com.beautyProducts.beautyProducts.service.ServiceImplementation;

import com.beautyProducts.beautyProducts.model.Orders;
import com.beautyProducts.beautyProducts.model.User;
import com.beautyProducts.beautyProducts.repository.UserRepository;
import com.beautyProducts.beautyProducts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public List<User> findAllUsers(){
        return (List<User>) userRepository.findAll();
    }
    @Override
    public Optional<User> findUserById(Long id){
        return userRepository.findById(id);
    }
    @Override
    public List<User> findUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }
    @Override
    public Optional<User> findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }
    @Override
    public Long deleteUserById(Long id){
        userRepository.deleteById(id);
        return id;
    }
    @Override
    public User deleteUser(User user){
        userRepository.delete(user);
        return user;
    }
    @Override
    public User createUser(User user){
        return userRepository.save(user);
    }
    @Override
    public User updateUserName(User user,String name) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        existingUser.setUsername(name);
        return userRepository.save(existingUser);
    }
    @Override
    public User updateUserLastName(User user,String name) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        existingUser.setLastName(name);
        return userRepository.save(existingUser);
    }
    @Override
    public User updateUserFirstName(User user,String name) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        existingUser.setFirstName(name);
        return userRepository.save(existingUser);
    }
    @Override
    public User updateUserEmail(User user,String email) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        existingUser.setEmail(email);
        return userRepository.save(existingUser);
    }
    @Override
    public User updateUserPass(User user,String pass) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        existingUser.setPassword(pass);
        return userRepository.save(existingUser);
    }
    public User updateOrdersList (User user, List<Orders> orders){
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        existingUser.setOrders(orders);
        return userRepository.save(existingUser);
    }
    @Override
    public User findByEmailAndPassword(String email, String password) {
        if(email != null && password != null)
            return userRepository.findByEmailAndPassword(email, password);
       else
        {
            System.out.println("Email sau parola invalida!");
           return null;
        }
    }
    @Override
    public User logIn(String email, String password)
    {
        User user = findByEmailAndPassword(email, password);
        if(user.getPassword().equals(password) && user.getEmail()==email) {
            System.out.println("Success login Client");
            user.setLogged(true);
            return user;
        }
        else {
            System.out.println("Try Again or become a client");
            return null;
        }
    }

    @Override
    public void logOut( @RequestBody String email) {
        userRepository.findUserByEmail(email)
                .ifPresent(user -> {
                    user.setLogged(false);
                    userRepository.save(user);
                });
    }

   /* @Override
    public String logIn(User user1, String email, String password)
    {
        User user=userRepository.findById(user1.getId()).orElse(null);
        if(user.getPassword().equals(password) && user.getEmail()==email)
            return  "Succes login Client";
        else
            return "Try Again or become a client";
    }*/
/*@Override
    public User updateUser(User user){
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        existingUser.setUsername(user.getUsername());
        existingUser.setLastName(user.getLastName());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        return userRepository.save(existingUser);
    }*/
}