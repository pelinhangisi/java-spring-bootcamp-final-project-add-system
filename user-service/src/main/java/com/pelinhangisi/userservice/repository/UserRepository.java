package com.pelinhangisi.userservice.repository;

import com.pelinhangisi.userservice.dto.UserRequest;
import com.pelinhangisi.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);
    void save(UserRequest userRequest);
    List<User> findAll();
    User findUserByUsername(String username);


}
