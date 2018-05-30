package com.example.reactiveweb.demoreactiveweb.repository;

import com.example.reactiveweb.demoreactiveweb.domain.Attendance;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AttendanceRepository extends ReactiveMongoRepository<Attendance,String> {
}
