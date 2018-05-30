package com.example.reactiveweb.demoreactiveweb.service;

import com.example.reactiveweb.demoreactiveweb.domain.User;
import com.example.reactiveweb.demoreactiveweb.dto.UserDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    public Mono<User> getUser(String id);
    public Flux<User> getUsers();
    public Mono<User> updateUser(String id, UserDTO userDTO);
    public Mono<Void> deleteUser(User user);
    public Mono<User> saveUser(UserDTO userDTO);
}
