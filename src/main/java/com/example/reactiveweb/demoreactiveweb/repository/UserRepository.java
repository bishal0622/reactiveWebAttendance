package com.example.reactiveweb.demoreactiveweb.repository;

import com.example.reactiveweb.demoreactiveweb.domain.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User,String> {
}
