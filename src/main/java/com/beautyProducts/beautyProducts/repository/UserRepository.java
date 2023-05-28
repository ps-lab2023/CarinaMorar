package com.beautyProducts.beautyProducts.repository;

import com.beautyProducts.beautyProducts.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    List<User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String email);

    User findByEmailAndPassword(String email,String password);

}
