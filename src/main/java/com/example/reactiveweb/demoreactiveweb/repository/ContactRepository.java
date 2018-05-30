package com.example.reactiveweb.demoreactiveweb.repository;

import com.example.reactiveweb.demoreactiveweb.domain.Contact;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ContactRepository extends ReactiveMongoRepository<Contact,String> {
}
