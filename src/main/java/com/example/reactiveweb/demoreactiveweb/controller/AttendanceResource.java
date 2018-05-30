package com.example.reactiveweb.demoreactiveweb.controller;

import com.example.reactiveweb.demoreactiveweb.domain.Attendance;
import com.example.reactiveweb.demoreactiveweb.repository.AttendanceRepository;
import com.example.reactiveweb.demoreactiveweb.service.AttendanceServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/attendance")
public class AttendanceResource {

    private AttendanceServiceImpl attendanceService;
    private AttendanceRepository attendanceRepository;

    public AttendanceResource(AttendanceServiceImpl attendanceService, AttendanceRepository attendanceRepository) {
        this.attendanceService = attendanceService;
        this.attendanceRepository = attendanceRepository;
    }

    @GetMapping
    public Flux<Attendance> getAllAttendance() {
        return attendanceService.getAttendances();
    }

    @PostMapping
    public Mono<ResponseEntity<Attendance>> createUser(@RequestBody String userId) {
        return attendanceService.saveAttendance(userId).map(attendance -> ResponseEntity.ok(attendance))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteTweet(@PathVariable(value = "id") String id) {
        return attendanceRepository.findById(id)
                .flatMap(attendance ->
                        attendanceService.deleteAttendance(attendance)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
