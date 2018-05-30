package com.example.reactiveweb.demoreactiveweb.service;

import com.example.reactiveweb.demoreactiveweb.domain.Attendance;
import com.example.reactiveweb.demoreactiveweb.dto.AttendanceDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AttendanceService {
    public Flux<Attendance> getAttendances();
    public Mono<Void> deleteAttendance(Attendance attendance);
    public Mono<Attendance> saveAttendance(String userid);
}

