package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLoginUsernameAndLoginPassword(String username, String password);
    List<User> findByFirstNameContainsOrLastNameContainsOrEmailContains(String firstName, String lastName, String email);
}
