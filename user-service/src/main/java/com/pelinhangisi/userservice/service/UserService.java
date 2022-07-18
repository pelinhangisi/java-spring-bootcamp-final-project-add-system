package com.pelinhangisi.userservice.service;

import com.pelinhangisi.userservice.dto.UserRequest;
import com.pelinhangisi.userservice.entity.User;
import com.pelinhangisi.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;



    @Transactional
    public void save(UserRequest userRequest){
        User user = User.builder()
                .username(userRequest.getUsername())
                .firstname(userRequest.getFirstname())
                .lastname(userRequest.getLastname())
                .email(userRequest.getEmail())
                .build();
        userRepository.save(user);
        log.info("New user saved {}", user.getId());
    }


    public UserRequest get(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
        return modelMapper.map(user, UserRequest.class);
    }

    @Transactional
    public UserRequest update(String id, UserRequest userRequest) {
        Assert.isNull(id, "Id cannot be null");
        Optional<User> user = userRepository.findById(id);
        User userUpToUpdate = user.map(item -> {
            item.setUsername(userRequest.getUsername());
            item.setFirstname(userRequest.getFirstname());
            item.setLastname(userRequest.getLastname());
            return item;
        }).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(userRepository.save(userUpToUpdate), UserRequest.class);
    }

    @Transactional
    public void delete(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
        userRepository.delete(user);
    }

    public Slice<UserRequest> findAll(Pageable pageable) {
        Slice<User> users = userRepository.findAll(pageable);
        return null;
    }

    public User findUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }



}
