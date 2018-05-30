package com.example.reactiveweb.demoreactiveweb.service;

import com.example.reactiveweb.demoreactiveweb.domain.Attendance;
import com.example.reactiveweb.demoreactiveweb.dto.AttendanceDTO;
import com.example.reactiveweb.demoreactiveweb.repository.AttendanceRepository;
import com.example.reactiveweb.demoreactiveweb.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd,HH:mm");

    private AttendanceRepository attendanceRepository;
    private UserRepository userRepository;

    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository, UserRepository userRepository) {
        this.attendanceRepository = attendanceRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Flux<Attendance> getAttendances() {
        return attendanceRepository.findAll();
    }

    @Override
    public Mono<Void> deleteAttendance(Attendance attendance) {
        return attendanceRepository.delete(attendance);
    }

    @Override
    public Mono<Attendance> saveAttendance(String userId) {
        Attendance attendance = new Attendance();
        attendance.setUser(userRepository.findById(userId).block());
        attendance.setTimeStamp(sdf.format(timestamp));
        return attendanceRepository.save(attendance);
    }
}
