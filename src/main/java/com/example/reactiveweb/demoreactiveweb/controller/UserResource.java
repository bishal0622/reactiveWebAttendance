package com.example.reactiveweb.demoreactiveweb.controller;

import com.example.reactiveweb.demoreactiveweb.domain.User;
import com.example.reactiveweb.demoreactiveweb.dto.UserDTO;
import com.example.reactiveweb.demoreactiveweb.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/user")
public class UserResource {

    private UserServiceImpl userService;

    public UserResource(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public Flux<User> getAllUser() {
        return userService.getUsers();
    }

    @PostMapping
    public Mono<ResponseEntity<User>> createUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO).map(user -> ResponseEntity.ok(user))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<User>> getUserById(@PathVariable(value = "id") String id) {
        return userService.getUser(id)
                .map(t -> ResponseEntity.ok(t))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteTweet(@PathVariable(value = "id") String id) {
        return userService.getUser(id)
                .flatMap(user ->
                        userService.deleteUser(user)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
