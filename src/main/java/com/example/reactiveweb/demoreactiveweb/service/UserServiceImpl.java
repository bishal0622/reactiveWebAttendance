package com.example.reactiveweb.demoreactiveweb.service;

import com.example.reactiveweb.demoreactiveweb.domain.User;
import com.example.reactiveweb.demoreactiveweb.dto.UserDTO;
import com.example.reactiveweb.demoreactiveweb.repository.ContactRepository;
import com.example.reactiveweb.demoreactiveweb.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ContactRepository contactRepository;

    public UserServiceImpl(UserRepository userRepository, ContactRepository contactRepository) {
        this.userRepository = userRepository;
        this.contactRepository = contactRepository;
    }

    @Override
    public Mono<User> getUser(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Flux<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Mono<User> updateUser(String id, UserDTO userDTO) {
        Mono<User> user = userRepository.findById(id);
        user.block().setFirstName(userDTO.getFirstName());
        user.block().setLastName(userDTO.getLastName());
        user.block().setContact(userDTO.getContact());
        user.block().setDesignation(userDTO.getDesignation());
        return userRepository.save(user.block());
    }

    @Override
    public Mono<Void> deleteUser(User user) {
        return userRepository.delete(user);
    }

    @Override
    public Mono<User> saveUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setContact(userDTO.getContact());
        user.setDesignation(userDTO.getDesignation());
        return userRepository.save(user);
    }
}
